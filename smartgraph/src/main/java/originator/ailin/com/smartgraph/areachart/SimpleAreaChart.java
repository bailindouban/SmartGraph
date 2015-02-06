package originator.ailin.com.smartgraph.areachart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.SimpleChart;

public class SimpleAreaChart extends SimpleChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleAreaChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleAreaChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(data != null) {
            int leftInit = left;
            paint.setColor(color);
            Path path = new Path();
            path.moveTo(leftInit, bottom - data[0]);
            for(int i = 1; i < data.length; i++) {
                leftInit += interval;
                path.lineTo(leftInit, bottom - data[i]);
            }
            path.lineTo(leftInit, bottom);
            path.lineTo(left, bottom);
            path.close();
            canvas.drawPath(path, paint);
        }
    }
}
