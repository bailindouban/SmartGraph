package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import originator.ailin.com.smartgraph.chart.base.obj.BarObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class SimpleBar extends LegendAbs {
    public SimpleBar(float leftInit, float bottom, BarObj barObj, float[] data, int color) {
        this.leftInit = leftInit;
        this.bottom = bottom;
        this.barObj = barObj;
        this.data = data;
        this.color = color;
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {
        paint.setColor(color);
        for(float d : data) {
            RectF rectF = new RectF(leftInit, bottom - d, leftInit + barObj.width, bottom);
            canvas.drawRect(rectF, paint);
            leftInit += barObj.width + barObj.interval;
        }
    }
}
