package originator.ailin.com.smartgraph.doughnut;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.BaseChart;

public class SimpleDoughnut extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleDoughnut(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleDoughnut(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(data != null) {
            float total = 0;
            for(float d : data) {
                total += d;
            }
            for(int i = 0; i < data.length; i++) {
                paint.setColor(colors[i]);
                RectF oval = new RectF(center.x - radius, center.y - radius, center.x + radius, center.y + radius);
                float swipeAngle = data[i] * 360 / total;
                canvas.drawArc(oval, startAngle, swipeAngle, true, paint);
                startAngle += swipeAngle;
            }
        }
    }
}
