package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import originator.ailin.com.smartgraph.obj.ScatterObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class Scatter extends LegendAbs {
    public Scatter(float leftInit, float bottom, ScatterObj scatterObj, int[] colors, float ratio) {
        initScatterParams(leftInit, bottom, scatterObj, colors, ratio);
    }
    @Override
    public void drawLegend(Canvas canvas, Paint paint) {

        for(int i = 0; i < scatterObj.scatterPoints.length; i++) {
            paint.setColor(colors[i]);
            for(int j = 0; j < ratio; j++) {
                PointF point = scatterObj.scatterPoints[i][j];
                canvas.drawCircle(leftInit + point.x, bottom - point.y, scatterObj.radii[i], paint);
            }
        }
    }
}
