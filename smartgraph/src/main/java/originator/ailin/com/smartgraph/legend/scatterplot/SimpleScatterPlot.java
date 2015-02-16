package originator.ailin.com.smartgraph.legend.scatterplot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.base.BaseChart;

public class SimpleScatterPlot extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleScatterPlot(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleScatterPlot(Context context, AttributeSet attrs) {
        super(context, attrs);
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
            for(PointF point : scatterObj.scatterPoint) {
                canvas.drawCircle(left + point.x, bottom - point.y, scatterObj.radius, paint);
            }
        }
    }
}
