package originator.ailin.com.smartgraph.areachart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.BaseChart;

public class SimpleAreaChart extends BaseChart {
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
            int leftInit = barObj.left;
            paint.setColor(color);
            Path path = new Path();
            path.moveTo(leftInit, barObj.bottom - data[0]);
            for(int i = 1; i < data.length; i++) {
                leftInit += barObj.interval;
                path.lineTo(leftInit, barObj.bottom - data[i]);
            }
            path.lineTo(leftInit, barObj.bottom);
            path.lineTo(barObj.left, barObj.bottom);
            path.close();
            canvas.drawPath(path, paint);
        }
    }
}
