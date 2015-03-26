package originator.ailin.com.smartgraph.legend.bubblechart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.base.BaseChart;
import originator.ailin.com.smartgraph.legend.base.MyPoint;
import originator.ailin.com.smartgraph.title.Title;

public class BubbleChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public BubbleChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public BubbleChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(bubbleObj.bubblePoints != null) {

            // Draw XY axis
            float dataMaxX = 0, dataMaxY = 0;
            for (MyPoint[] points : bubbleObj.bubblePoints) {
                for(MyPoint point : points) {
                    dataMaxX = ((point.x + point.radius) > dataMaxX) ? (point.x + point.radius) : dataMaxX;
                    dataMaxY = ((point.y + point.radius) > dataMaxY) ? (point.y + point.radius) : dataMaxY;
                }
            }

            int unitX = 100, unitY = 100;
            int maxWidth = (int) dataMaxX + unitX;
            int maxHeight = (int) dataMaxY + unitY;
            Axis axis = new Axis(canvas, paint, left, bottom);
            axis.drawAxisX(maxWidth);
            axis.drawAxisY(maxHeight);

            // Draw Grid
            Grid grid = new Grid(canvas, paint, left, bottom);
            grid.drawGridY(maxWidth, maxHeight, unitY);

            // Draw Legend
            for(int i = 0; i < bubbleObj.bubblePoints.length; i++) {
                paint.setColor(colors[i]);
                for(MyPoint point : bubbleObj.bubblePoints[i]) {
                    canvas.drawCircle(left + point.x, bottom - point.y, point.radius, paint);
                }
            }

            // Draw Title
            Title title = new Title(canvas, paint, left, bottom);
            title.drawTitle(titleText, titleSize, titleColor, maxWidth, maxHeight);

            // Draw PolarXY
            drawPolarBubbleX(canvas, maxWidth);
            drawPolarY(canvas, maxHeight);
        }
    }
}
