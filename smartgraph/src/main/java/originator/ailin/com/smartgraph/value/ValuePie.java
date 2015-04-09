package originator.ailin.com.smartgraph.value;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import originator.ailin.com.smartgraph.obj.PieObj;

/**
 * Created by Kim_Bai on 2/15/2015.
 */
public class ValuePie extends ValueAbs {
    /**
     * Constructor
     * @param pieObj
     * @param radius
     * @param data
     */
    public ValuePie(PieObj pieObj, float radius, float[] data) {
        this.pieObj = pieObj;
        this.radius = radius;
        this.data = data;
    }

    /**
     *
     * @param resources
     * @param canvas
     * @param paint
     */
    @Override
    public void drawValue(Resources resources, Canvas canvas, Paint paint) {
        init(resources, paint);
        float startAngleInit = pieObj.startAngle;

        float total = 0;
        for(float d : data) {
            total += d;
        }

        for(int i = 0; i < data.length; i++) {
            float swipeAngle = data[i] * 360 / total;
            paint.setTextAlign(Paint.Align.CENTER);
            Rect bounds = new Rect();
            String legendValueText = String.valueOf(data[i]);
            paint.getTextBounds(legendValueText, 0, legendValueText.length(), bounds);
            double radian = Math.PI * (2 * startAngleInit + swipeAngle) / 360;
            canvas.drawText(String.valueOf(data[i]), pieObj.center.x + (radius + pieObj.bias[i] - pieLegendValueMargin) * (float) Math.cos(radian), pieObj.center.y + (radius + pieObj.bias[i] - pieLegendValueMargin) * (float) Math.sin(radian) + bounds.height() / 2, paint);

            // swipeAngle++
            startAngleInit += swipeAngle;
        }
    }
}
