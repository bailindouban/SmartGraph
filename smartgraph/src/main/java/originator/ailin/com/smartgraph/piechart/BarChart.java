package originator.ailin.com.smartgraph.piechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.Chart;

public class BarChart extends Chart {
    /**
     * Constructor 1
     * @param context
     */
    public BarChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public BarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(data != null) {
            int leftInit = left;
            for(int i = 0; i < data.length; i++) {
                for(int j = 0; j < data[i].length; j++) {
                    paint.setColor(color[j]);
                    Rect rect = new Rect(leftInit, bottom - data[i][j], leftInit + width, bottom);
                    canvas.drawRect(rect, paint);
                    leftInit += width;
                }

                leftInit += interval;
            }
        }
    }
}
