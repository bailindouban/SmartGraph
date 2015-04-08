package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import originator.ailin.com.smartgraph.chart.base.obj.BarObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class SimpleArea extends LegendAbs {
    public SimpleArea(float leftInit, float bottom, BarObj barObj, float[] data, int color) {
        this.leftInit = leftInit;
        this.bottom = bottom;
        this.barObj = barObj;
        this.data = data;
        this.color = color;
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {
        paint.setColor(color);
        Path path = new Path();
        float left = leftInit;
        path.moveTo(leftInit, bottom - data[0]);
        for(int i = 1; i < data.length; i++) {
            leftInit += barObj.interval;
            path.lineTo(leftInit, bottom - data[i]);
        }
        path.lineTo(leftInit, bottom);
        path.lineTo(left, bottom);
        path.close();
        canvas.drawPath(path, paint);
    }
}
