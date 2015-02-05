package originator.ailin.com.smartgraph.linechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.Chart;

public class LineChart extends Chart {
    /**
     * Constructor 1
     * @param context
     */
    public LineChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public LineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(data != null) {
            for(int i = 0; i < data.length; i++) {
                int leftInit = left;
                paint.setColor(color[i]);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(width);
                Path path = new Path();
                path.moveTo(leftInit, bottom - data[i][0]);
                for(int j = 1; j < data[i].length; j++) {
                    leftInit += interval;
                    path.lineTo(leftInit, bottom - data[i][j]);
                }
                canvas.drawPath(path, paint);
            }
        }
    }
}
