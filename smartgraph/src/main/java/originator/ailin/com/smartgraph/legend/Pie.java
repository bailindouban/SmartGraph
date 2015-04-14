package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;

import originator.ailin.com.smartgraph.obj.PieObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class Pie extends LegendAbs {
    private float mBiasXMax = 0, mBiasXMin = 0, mBiasYMax = 0, mBiasYMin = 0;

    public Pie(PieObj pieObj, float[] data, int[] colors, float ratio) {
        initPieParams(pieObj, data, colors, ratio);
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {
        float startAngleInit = pieObj.startAngle;
        float total = 0;
        for (float d : data) {
            total += d;
        }
        for (int i = 0; i < ratio; i++) {
            paint.setColor(colors[i]);
            float swipeAngle = data[i] * 360 / total;

            double radian = Math.PI * (2 * startAngleInit + swipeAngle) / 360;
            PointF biasXY = new PointF();
            biasXY.set(pieObj.bias[i] * (float) Math.cos(radian), pieObj.bias[i] * (float) Math.sin(radian));
            mBiasXMax = (mBiasXMax < biasXY.x) ? biasXY.x : mBiasXMax;
            mBiasXMin = (mBiasXMin > biasXY.x) ? biasXY.x : mBiasXMin;
            mBiasYMax = (mBiasYMax < biasXY.y) ? biasXY.y : mBiasYMax;
            mBiasYMin = (mBiasYMin > biasXY.y) ? biasXY.y : mBiasYMin;

            RectF oval = new RectF(pieObj.center.x - pieObj.radius + biasXY.x, pieObj.center.y - pieObj.radius + biasXY.y, pieObj.center.x + pieObj.radius + biasXY.x, pieObj.center.y + pieObj.radius + biasXY.y);
            canvas.drawArc(oval, startAngleInit, swipeAngle, true, paint);

            startAngleInit += swipeAngle;
        }
    }
}
