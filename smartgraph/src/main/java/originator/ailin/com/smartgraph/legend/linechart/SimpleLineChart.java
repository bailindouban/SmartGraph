package originator.ailin.com.smartgraph.legend.linechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.legend.base.BaseChart;

public class SimpleLineChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleLineChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleLineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(data != null) {
            int leftInit = left;
            paint.setColor(color);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(barObj.width);
            Path path = new Path();
            path.moveTo(leftInit, bottom - data[0]);
            for(int i = 1; i < data.length; i++) {
                leftInit += barObj.interval;
                path.lineTo(leftInit, bottom - data[i]);
            }
            canvas.drawPath(path, paint);
        }
    }
}
