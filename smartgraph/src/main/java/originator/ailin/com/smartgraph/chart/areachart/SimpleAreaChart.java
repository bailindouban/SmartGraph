package originator.ailin.com.smartgraph.chart.areachart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.chart.base.BaseChart;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.SimpleArea;

public class SimpleAreaChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleAreaChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleAreaChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(data != null) {
            // Draw XY axis
            float dataMax = 0;
            for (float d : data) {
                dataMax = (d > dataMax) ? d : dataMax;
            }

            int maxWidth = (data.length - 1)* barObj.interval;
            int maxHeight = (int) dataMax + unitY;
            axis = new Axis(left, bottom, maxWidth, maxHeight);
            showAxisX(canvas, paint);
            showAxisY(canvas, paint);

            // Draw Grid
            grid = new Grid(left, bottom, maxWidth, maxHeight, unitY);
            showGrid(canvas, paint);

            // Draw Legend
            legend = new SimpleArea(left, bottom, barObj, data, color);
            showLegend(canvas, paint);

            // Draw Title
            drawTitle(canvas, maxWidth, maxHeight);

            // Draw PolarXY
            drawPolarX(canvas, data.length, 0, barObj.interval);
            drawPolarY(canvas, maxHeight);

            // Draw label
            drawLabel(canvas, 1, maxWidth, maxHeight, new int[] {color});
        }
    }
}
