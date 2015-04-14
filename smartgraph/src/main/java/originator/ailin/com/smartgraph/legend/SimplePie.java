package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import originator.ailin.com.smartgraph.obj.PieObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class SimplePie extends LegendAbs {
    public SimplePie(PieObj pieObj, float[] data, int[] colors, float ratio) {
        initPieParams(pieObj, data, colors, ratio);
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {
        float total = 0;
        for(float d : data) {
            total += d;
        }

        float startAngleInit = pieObj.startAngle;
        for(int i = 0; i < ratio; i++) {
            // Draw Legend
            paint.setColor(colors[i]);
            RectF oval = new RectF(pieObj.center.x - pieObj.radius, pieObj.center.y - pieObj.radius, pieObj.center.x + pieObj.radius, pieObj.center.y + pieObj.radius);
            float swipeAngle = data[i] * 360 / total;
            canvas.drawArc(oval, startAngleInit, swipeAngle, true, paint);

            // swipeAngle++
            startAngleInit += swipeAngle;
        }
    }
}
