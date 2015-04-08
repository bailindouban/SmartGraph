package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import originator.ailin.com.smartgraph.chart.base.obj.ScatterObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class Scatter extends LegendAbs {
    public Scatter(float leftInit, float bottom, ScatterObj scatterObj, int[] colors) {
        this.leftInit = leftInit;
        this.bottom = bottom;
        this.scatterObj = scatterObj;
        this.colors = colors;
    }
    @Override
    public void drawLegend(Canvas canvas, Paint paint) {

        for(int i = 0; i < scatterObj.scatterPoints.length; i++) {
            paint.setColor(colors[i]);
            for(PointF point : scatterObj.scatterPoints[i]) {
                canvas.drawCircle(leftInit + point.x, bottom - point.y, scatterObj.radii[i], paint);
            }
        }
    }
}
