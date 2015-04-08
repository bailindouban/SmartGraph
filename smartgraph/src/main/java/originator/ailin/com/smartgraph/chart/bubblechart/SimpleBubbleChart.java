package originator.ailin.com.smartgraph.chart.bubblechart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.chart.base.BaseChart;
import originator.ailin.com.smartgraph.chart.base.obj.MyPoint;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.SimpleBubble;

public class SimpleBubbleChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleBubbleChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleBubbleChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(bubbleObj.bubblePoint != null) {
            // Draw XY axis
            float dataMaxX = 0, dataMaxY = 0;
            for (MyPoint point : bubbleObj.bubblePoint) {
                dataMaxX = ((point.x + point.radius) > dataMaxX) ? (point.x + point.radius) : dataMaxX;
                dataMaxY = ((point.y + point.radius) > dataMaxY) ? (point.y + point.radius) : dataMaxY;
            }

            int maxWidth = (int) dataMaxX + unitX;
            int maxHeight = (int) dataMaxY + unitY;
            axis = new Axis(left, bottom, maxWidth, maxHeight);
            showAxisX(canvas, paint);
            showAxisY(canvas, paint);

            // Draw Grid
            grid = new Grid(left, bottom, maxWidth, maxHeight, unitY);
            showGrid(canvas, paint);

            // Draw Legend
            legend = new SimpleBubble(left, bottom, bubbleObj, color);
            showLegend(canvas, paint);

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
