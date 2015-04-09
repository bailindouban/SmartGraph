package originator.ailin.com.smartgraph.value;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import originator.ailin.com.smartgraph.obj.PieObj;

/**
 * Created by Kim_Bai on 2/15/2015.
 */
public class ValueRose extends ValueAbs {
    /**
     *
     * @param pieObj
     * @param radiusDealArray
     * @param data
     */
    public ValueRose(PieObj pieObj, float[] radiusDealArray, float[] data) {
        this.pieObj = pieObj;
        this.radiusDealArray = radiusDealArray;
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

        paint.setTextSize(28);
        float startAngleInit = pieObj.startAngle;

        for(int i = 0; i < data.length; i++) {
            float swipeAngle = 360 / data.length;
            paint.setTextAlign(Paint.Align.CENTER);
            Rect bounds = new Rect();
            String legendValueText = String.valueOf(data[i]);
            paint.getTextBounds(legendValueText, 0, legendValueText.length(), bounds);
            double radian = Math.PI * (2 * startAngleInit + swipeAngle) / 360;
            canvas.drawText(String.valueOf(data[i]), pieObj.center.x + (radiusDealArray[i] - pieRoseLegendValueMargin) * (float) Math.cos(radian), pieObj.center.y + (radiusDealArray[i] - pieRoseLegendValueMargin) * (float) Math.sin(radian) + bounds.height() / 2, paint);

            // swipeAngle++
            startAngleInit += swipeAngle;
        }
    }

}
