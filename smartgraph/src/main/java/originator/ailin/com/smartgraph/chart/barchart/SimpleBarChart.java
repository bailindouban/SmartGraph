package originator.ailin.com.smartgraph.chart.barchart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.chart.base.BaseChart;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.SimpleBar;

public class SimpleBarChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleBarChart(Context context) {
        super(context);
        init();
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        legend = new SimpleBar();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(data != null) {
            float leftInit = left;

            // Draw XY axis
            float dataMax = 0;
            for (float d : data) {
                dataMax = (d > dataMax) ? d : dataMax;
            }

            int unit = 100;
            int maxWidth = data.length * (barObj.width + barObj.interval);
            int maxHeight = (int) dataMax + unit;
            Axis axis = new Axis(canvas, paint, left, bottom);
            axis.drawAxisX(maxWidth);
            axis.drawAxisY(maxHeight);

            // Draw Grid
            Grid grid = new Grid(canvas, paint, left, bottom);
            grid.drawGridY(maxWidth, maxHeight, unit);

            // Draw Legend
            showLegend(canvas, paint, leftInit, bottom, barObj, data, color);

            // Draw Title
            drawTitle(canvas, maxWidth, maxHeight);

            // Draw PolarXY
            drawPolarX(canvas, data.length, barObj.width, barObj.interval);
            drawPolarY(canvas, maxHeight);

            // Draw label
            drawLabel(canvas, 1, maxWidth, maxHeight, new int[]{color});
        }
    }
}