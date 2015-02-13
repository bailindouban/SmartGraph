package originator.ailin.com.smartgraph.bubblechart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.BaseChart;
import originator.ailin.com.smartgraph.base.MyPoint;

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
            for(int i = 0; i < bubbleObj.bubblePoints.length; i++) {
                paint.setColor(colors[i]);
                for(MyPoint point : bubbleObj.bubblePoints[i]) {
                    canvas.drawCircle(left + point.x, bottom - point.y, point.radius, paint);
                }
            }
        }
    }
}