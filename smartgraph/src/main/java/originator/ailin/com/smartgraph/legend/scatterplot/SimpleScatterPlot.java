package originator.ailin.com.smartgraph.legend.scatterplot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.legend.base.BaseChart;

public class SimpleScatterPlot extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleScatterPlot(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleScatterPlot(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(scatterObj.scatterPoint != null) {
            paint.setColor(color);
            for(PointF point : scatterObj.scatterPoint) {
                canvas.drawCircle(left + point.x, bottom - point.y, scatterObj.radius, paint);
            }
        }
    }
}
