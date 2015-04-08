package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import originator.ailin.com.smartgraph.chart.base.obj.BarObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class Line extends LegendAbs {
    public Line(float leftInit, float bottom, BarObj barObj, float[][] datas, int[] colors) {
        this.leftInit = leftInit;
        this.bottom = bottom;
        this.barObj = barObj;
        this.datas = datas;
        this.colors = colors;
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {
        for(int i = 0; i < datas.length; i++) {
            // Draw Legend
            float left = leftInit;
            paint.setColor(colors[i]);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(barObj.width);
            Path path = new Path();
            path.moveTo(left, bottom - datas[i][0]);
            for(int j = 1; j < datas[i].length; j++) {
                left += barObj.interval;
                path.lineTo(left, bottom - datas[i][j]);
            }
            canvas.drawPath(path, paint);

        }
    }
}
