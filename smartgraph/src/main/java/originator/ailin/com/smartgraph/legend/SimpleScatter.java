package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import originator.ailin.com.smartgraph.obj.ScatterObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class SimpleScatter extends LegendAbs {
    public SimpleScatter(float leftInit, float bottom, ScatterObj scatterObj, int color, float ratio) {
        initScatterSimpleParams(leftInit, bottom, scatterObj, color, ratio);
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {
        paint.setColor(color);
        for(int i = 0; i < ratio; i++) {
            PointF point = scatterObj.scatterPoint[i];
            canvas.drawCircle(leftInit + point.x, bottom - point.y, scatterObj.radius, paint);
        }
    }
}
