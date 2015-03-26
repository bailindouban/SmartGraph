package originator.ailin.com.smartgraph.legend.barchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.label.Label;
import originator.ailin.com.smartgraph.legend.base.BaseChart;
import originator.ailin.com.smartgraph.polar.Polar;
import originator.ailin.com.smartgraph.title.Title;

public class BarChart extends BaseChart {


    /**
     * Constructor 1
     * @param context
     */
    public BarChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public BarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(datas != null) {
            int leftInit = left;

            // Draw XY axis
            float dataMax = 0;
            for (float[] data : datas) {
                for(float d : data) {
                    dataMax = (d > dataMax) ? d : dataMax;
                }
            }

            int unit = 100;
            int maxWidth = datas.length * barObj.interval + datas.length * datas[0].length * barObj.width;
            int maxHeight = (int) dataMax + unit;
            Axis axis = new Axis(canvas, paint, leftInit, bottom);
            axis.drawAxisX(maxWidth);
            axis.drawAxisY(maxHeight);

            // Draw Grid
            Grid grid = new Grid(canvas, paint, leftInit, bottom);
            grid.drawGridY(maxWidth, maxHeight, unit);

            // Draw Legend
            for(int i = 0; i < datas.length; i++) {
                for(int j = 0; j < datas[i].length; j++) {
                    paint.setColor(colors[j]);
                    RectF rectF = new RectF(leftInit, bottom - datas[i][j], leftInit + barObj.width, bottom);
                    canvas.drawRect(rectF, paint);
                    leftInit += barObj.width;
                }

                leftInit += barObj.interval;
            }

            // Draw Title
            Title title = new Title(canvas, paint, left, bottom);
            title.drawTitle(titleText, titleSize, titleColor, maxWidth, maxHeight);

            // Draw PolarXY
            Polar polar = new Polar(getResources(), canvas, paint, left, bottom);
            polar.drawPolarY(maxHeight, unit);
            polar.drawPolarX(datas.length, barObj.width * datas[0].length, barObj.interval, polarsTextX);

            // Draw label
            Label label = new Label(getResources(), canvas, paint, left, bottom);
            label.drawLabel(labelsText, maxWidth, maxHeight);
        }
    }
}
