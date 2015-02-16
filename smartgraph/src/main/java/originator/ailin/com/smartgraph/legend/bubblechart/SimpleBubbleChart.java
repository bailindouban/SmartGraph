package originator.ailin.com.smartgraph.legend.bubblechart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.base.BaseChart;
import originator.ailin.com.smartgraph.legend.base.MyPoint;

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

            int unit = 100;
            int maxWidth = (int) dataMaxX;
            int maxHeight = (int) dataMaxY + unit;
            Axis axis = new Axis(canvas, paint, left, bottom);
            axis.drawAxisX(maxWidth);
            axis.drawAxisY(maxHeight);

            // Draw Grid
            Grid grid = new Grid(canvas, paint, left, bottom);
            grid.drawGridY(maxWidth, maxHeight, unit);

            // Draw Legend
            paint.setColor(color);
            for(MyPoint point : bubbleObj.bubblePoint) {
                canvas.drawCircle(left + point.x, bottom - point.y, point.radius, paint);
            }
        }
    }
}
