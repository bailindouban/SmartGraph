package originator.ailin.com.smartgraph.chart.scatterplot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.chart.base.BaseChart;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.SimpleScatter;

public class SimpleScatterPlot extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleScatterPlot(Context context) {
        super(context);
        init();
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleScatterPlot(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        legend = new SimpleScatter();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(scatterObj.scatterPoint != null) {
            // Draw XY axis
            float dataMaxX = 0, dataMaxY = 0;
            for (PointF point : scatterObj.scatterPoint) {
                dataMaxX = ((point.x + scatterObj.radius) > dataMaxX) ? (point.x + scatterObj.radius) : dataMaxX;
                dataMaxY = ((point.y + scatterObj.radius) > dataMaxY) ? (point.y + scatterObj.radius) : dataMaxY;
            }

            int maxWidth = (int) dataMaxX + unitX;
            int maxHeight = (int) dataMaxY + unitY;
            Axis axis = new Axis(canvas, paint, left, bottom);
            axis.drawAxisX(maxWidth);
            axis.drawAxisY(maxHeight);

            // Draw Grid
            Grid grid = new Grid(canvas, paint, left, bottom);
            grid.drawGridY(maxWidth, maxHeight, unitY);

            // Draw Legend
            showLegend(canvas, paint, left, bottom, scatterObj, color);

            // Draw Title
            drawTitle(canvas, maxWidth, maxHeight);

            // Draw PolarXY
            drawPolarBubbleX(canvas, maxWidth);
            drawPolarY(canvas, maxHeight);

            // Draw label
            drawLabel(canvas, 1, maxWidth, maxHeight, new int[] {color});
        }
    }
}
