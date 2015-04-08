package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import originator.ailin.com.smartgraph.chart.base.obj.ScatterObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class SimpleScatter extends LegendAbs {

    @Override
    public void drawLegend(Canvas canvas, Paint paint, float leftInit, float bottom, ScatterObj scatterObj, int color) {
        paint.setColor(color);
        for(PointF point : scatterObj.scatterPoint) {
            canvas.drawCircle(leftInit + point.x, bottom - point.y, scatterObj.radius, paint);
        }
    }
}