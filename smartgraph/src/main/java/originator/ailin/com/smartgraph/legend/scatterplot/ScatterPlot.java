package originator.ailin.com.smartgraph.legend.scatterplot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.legend.base.BaseChart;

public class ScatterPlot extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public ScatterPlot(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public ScatterPlot(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(scatterObj.scatterPoints != null) {
            for(int i = 0; i < scatterObj.scatterPoints.length; i++) {
                paint.setColor(colors[i]);
                for(PointF point : scatterObj.scatterPoints[i]) {
                    canvas.drawCircle(left + point.x, bottom - point.y, scatterObj.radii[i], paint);
                }
            }
        }
    }
}
