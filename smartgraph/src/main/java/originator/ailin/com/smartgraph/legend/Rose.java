package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import originator.ailin.com.smartgraph.obj.PieObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class Rose extends LegendAbs {
    public Rose(PieObj pieObj, float[] data, int[] colors, float ratio) {
        initPieParams(pieObj, data, colors, ratio);
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);

        float maxData = data[0];
        for(float d : data) {
            maxData = (d > maxData) ? d : maxData;
        }

        float startAngleInit = pieObj.startAngle;
        float[] radiusDealArray = new float[data.length];
        for(int i = 0; i < ratio; i++) {
            float widthDeal = (pieObj.radiusOuter - pieObj.radiusInner) * data[i] / maxData;
            float radiusDeal = pieObj.radiusInner + (pieObj.radiusOuter - pieObj.radiusInner) * data[i] / maxData / 2;
            radiusDealArray[i] = radiusDeal + widthDeal / 2;
            paint.setStrokeWidth(widthDeal);

            paint.setColor(colors[i]);
            RectF oval = new RectF(pieObj.center.x - radiusDeal, pieObj.center.y - radiusDeal, pieObj.center.x + radiusDeal, pieObj.center.y + radiusDeal);
            float swipeAngle = 360 / data.length;
            canvas.drawArc(oval, startAngleInit, swipeAngle, false, paint);

            startAngleInit += swipeAngle;
        }
    }
}
