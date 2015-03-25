package originator.ailin.com.smartgraph.legend.areachart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.base.BaseChart;
import originator.ailin.com.smartgraph.polar.Polar;
import originator.ailin.com.smartgraph.title.Title;

public class AreaChart extends BaseChart {
    private int size;
    private int size_sub;

    /**
     * Constructor 1
     * @param context
     */
    public AreaChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public AreaChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if(datas != null) {
            int leftInit = left;

            // Draw XY axis
            Float[][] dataArray = getDataArray();
            float dataMax = 0;
            for (float d : dataArray[0]) {
                dataMax = (d > dataMax) ? d : dataMax;
            }

            int unit = 100;
            int maxWidth = (size_sub - 1) * barObj.interval;
            int maxHeight = (int) dataMax + unit;
            Axis axis = new Axis(canvas, paint, leftInit, bottom);
            axis.drawAxisX(maxWidth);
            axis.drawAxisY(maxHeight);

            // Draw Grid
            Grid grid = new Grid(canvas, paint, leftInit, bottom);
            grid.drawGridY(maxWidth, maxHeight, unit);

            // Draw Legend
            for(int i = 0; i < size; i++) {
                leftInit = left;
                paint.setColor(colors[size - i - 1]);
                Path path = new Path();
                path.moveTo(leftInit, bottom - dataArray[i][0]);
                for(int j = 1; j < size_sub; j++) {
                    leftInit += barObj.interval;
                    path.lineTo(leftInit, bottom - dataArray[i][j]);
                }
                path.lineTo(leftInit, bottom);
                path.lineTo(left, bottom);
                path.close();
                canvas.drawPath(path, paint);
            }

            // Draw Title
            Title title = new Title(canvas, paint, left, bottom);
            title.drawTitle(titleText, titleSize, titleColor, maxWidth, maxHeight);

            // Draw PolarXY
            Polar polar = new Polar(getResources(), canvas, paint, left, bottom);
            polar.drawPolarY(maxHeight, unit);
            polar.drawPolarX(size_sub, 0, barObj.interval, polarX);

            // Draw label
        }
    }

    /**
     * 要用迭代算法？
     * @return
     */
    private Float[][] getDataArray() {
        size = datas.length;
        size_sub = datas[0].length;

        Float[][] dataArray = new Float[size][size_sub];
        Float[] totalArray = new Float[size_sub];

        for(int j = 0; j < size_sub; j++) {
            float total = 0;
            for(int i = 0; i < size; i++) {
                total += datas[i][j];
            }
            totalArray[j] = total;
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size_sub; j++) {
                dataArray[i][j] = totalArray[j];
                totalArray[j] -= datas[size - i - 1][j];
            }
        }

        return dataArray;
    }
}
