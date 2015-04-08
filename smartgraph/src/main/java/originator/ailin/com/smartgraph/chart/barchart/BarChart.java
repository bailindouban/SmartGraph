package originator.ailin.com.smartgraph.chart.barchart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.chart.base.BaseChart;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.Bar;

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
            float leftInit = left;

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
            legend = new Bar(left, bottom, barObj, datas, colors);
            showLegend(canvas, paint);

            // Draw Title
            drawTitle(canvas, maxWidth, maxHeight);

            // Draw PolarXY
            drawPolarX(canvas, datas.length, barObj.width * datas[0].length, barObj.interval);
            drawPolarY(canvas, maxHeight);

            // Draw label
            drawLabel(canvas, datas[0].length, maxWidth, maxHeight, colors);
        }
    }
}
