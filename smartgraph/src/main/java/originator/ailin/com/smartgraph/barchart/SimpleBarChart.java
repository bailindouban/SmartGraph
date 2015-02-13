package originator.ailin.com.smartgraph.barchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.BaseChart;

public class SimpleBarChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleBarChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        int leftInit = barObj.left;
        if(data != null) {
            for(float d : data) {
                paint.setColor(color);
                RectF rectF = new RectF(leftInit, barObj.bottom - d, leftInit + barObj.width, barObj.bottom);
                canvas.drawRect(rectF, paint);
                leftInit += barObj.width + barObj.interval;
            }
        }
    }
}
