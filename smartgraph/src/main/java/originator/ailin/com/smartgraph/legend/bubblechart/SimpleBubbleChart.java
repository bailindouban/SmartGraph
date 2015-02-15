package originator.ailin.com.smartgraph.legend.bubblechart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

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
            paint.setColor(color);
            for(MyPoint point : bubbleObj.bubblePoint) {
                canvas.drawCircle(left + point.x, bottom - point.y, point.radius, paint);
            }
        }
    }
}
