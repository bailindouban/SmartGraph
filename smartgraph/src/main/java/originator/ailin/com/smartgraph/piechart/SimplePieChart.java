package originator.ailin.com.smartgraph.piechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.SimpleChart;

public class SimplePieChart extends SimpleChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimplePieChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimplePieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        int leftInit = left;
        if(data != null) {
            for(int d : data) {
                paint.setColor(color);
                Rect rect = new Rect(leftInit, bottom - d, leftInit + width, bottom);
                canvas.drawRect(rect, paint);
                leftInit += width + interval;
            }
        }
    }
}
