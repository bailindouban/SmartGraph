package originator.ailin.com.smartgraph.chart.areachart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import originator.ailin.com.smartgraph.axis.AxisX;
import originator.ailin.com.smartgraph.axis.AxisY;
import originator.ailin.com.smartgraph.chart.BaseChart;
import originator.ailin.com.smartgraph.grid.GridY;
import originator.ailin.com.smartgraph.legend.Area;
import originator.ailin.com.smartgraph.polar.PolarX;
import originator.ailin.com.smartgraph.polar.PolarY;
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
            // Draw XY axis
            Float[][] dataArray = getDataArray();
            float dataMax = 0;
            for (float d : dataArray[0]) {
                dataMax = (d > dataMax) ? d : dataMax;
            }

            int maxWidth = (size_sub - 1) * barObj.interval;
            int maxHeight = (int) dataMax + unitY;
            axisX = new AxisX(left, bottom, maxWidth, maxHeight);
            axisY = new AxisY(left, bottom, maxWidth, maxHeight);
            showAxisX(canvas, paint);
            showAxisY(canvas, paint);

            // Draw Grid
            gridY = new GridY(left, bottom, maxWidth, maxHeight, unitY);
            showGridY(canvas, paint);

            // Draw Legend
            legend = new Area(left, bottom, barObj, datas, colors);
            showLegend(canvas, paint);

            // Draw Title
            title = new Title(left, bottom, titleText, titleSize, titleColor, maxWidth, maxHeight);
            showTitle(canvas, paint);

            // Draw PolarXY
            polarX = new PolarX(left, bottom, size_sub, 0, barObj.interval, polarsTextX, polarTextColorX);
            polarY = new PolarY(left, bottom, maxHeight, unitY, polarTextColorY);
            showPolarX(getResources(), canvas, paint);
            showPolarY(getResources(), canvas, paint);

            // Draw label
            drawLabel(canvas, size, maxWidth, maxHeight, colors);
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
