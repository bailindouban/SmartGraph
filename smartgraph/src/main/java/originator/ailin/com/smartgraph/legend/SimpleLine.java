package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import originator.ailin.com.smartgraph.chart.base.obj.BarObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class SimpleLine extends LegendAbs {

    @Override
    public void drawLegend(Canvas canvas, Paint paint, float leftInit, float bottom, BarObj barObj, float[] data, int color) {
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(barObj.width);
        Path path = new Path();
        path.moveTo(leftInit, bottom - data[0]);
        for(int i = 1; i < data.length; i++) {
            leftInit += barObj.interval;
            path.lineTo(leftInit, bottom - data[i]);
        }
        canvas.drawPath(path, paint);
    }
}