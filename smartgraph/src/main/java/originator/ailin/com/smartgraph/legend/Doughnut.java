package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;

import originator.ailin.com.smartgraph.obj.PieObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class Doughnut extends LegendAbs {
    private float mBiasXMax = 0, mBiasXMin = 0, mBiasYMax = 0, mBiasYMin = 0;

    public Doughnut(PieObj pieObj, float[] data, int[] colors, float ratio) {
        initPieParams(pieObj, data, colors, ratio);
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(pieObj.radiusOuter - pieObj.radiusInner);
        float radius = (pieObj.radiusInner + pieObj.radiusOuter ) / 2;

        float total = 0;
        for(float d : data) {
            total += d;
        }

        float startAngleInit = pieObj.startAngle;
        for(int i = 0; i < ratio; i++) {
            paint.setColor(colors[i]);
            float swipeAngle = data[i] * 360 / total;

            double radian = Math.PI * (2 * startAngleInit + swipeAngle) / 360;
            PointF biasXY = new PointF();
            biasXY.set(pieObj.bias[i] * (float)Math.cos(radian), pieObj.bias[i] * (float)Math.sin(radian));
            mBiasXMax = (mBiasXMax < biasXY.x) ? biasXY.x : mBiasXMax;
            mBiasXMin = (mBiasXMin > biasXY.x) ? biasXY.x : mBiasXMin;
            mBiasYMax = (mBiasYMax < biasXY.y) ? biasXY.y : mBiasYMax;
            mBiasYMin = (mBiasYMin > biasXY.y) ? biasXY.y : mBiasYMin;

            RectF oval = new RectF(pieObj.center.x - radius + biasXY.x, pieObj.center.y - radius + biasXY.y, pieObj.center.x + radius + biasXY.x, pieObj.center.y + radius + biasXY.y);
            canvas.drawArc(oval, startAngleInit, swipeAngle, false, paint);

            startAngleInit += swipeAngle;
        }
    }
}
