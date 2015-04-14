package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import originator.ailin.com.smartgraph.obj.PieObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class SimpleDoughnut extends LegendAbs {
    public SimpleDoughnut(PieObj pieObj, float[] data, int[] colors, float ratio) {
        initPieParams(pieObj, data, colors, ratio);
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(pieObj.radiusOuter - pieObj.radiusInner);
        float radius = (pieObj.radiusInner + pieObj.radiusOuter) / 2;

        float total = 0;
        for(float d : data) {
            total += d;
        }

        float startAngleInit = pieObj.startAngle;
        for(int i = 0; i < ratio; i++) {
            paint.setColor(colors[i]);
            RectF oval = new RectF(pieObj.center.x - radius, pieObj.center.y - radius, pieObj.center.x + radius, pieObj.center.y + radius);
            float swipeAngle = data[i] * 360 / total;
            canvas.drawArc(oval, startAngleInit, swipeAngle, false, paint);

            startAngleInit += swipeAngle;
        }
    }
}
