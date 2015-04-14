package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import originator.ailin.com.smartgraph.obj.BarObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class Bar extends LegendAbs {
    public Bar(float leftInit, float bottom, BarObj barObj, float[][] datas, int[] colors, float ratio) {
        initBarParams(leftInit, bottom, barObj, datas, colors, ratio);
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {

        for(int i = 0; i < datas.length; i++) {
            for(int j = 0; j < datas[i].length; j++) {
                paint.setColor(colors[j]);
                RectF rectF = new RectF(leftInit, bottom - datas[i][j] * ratio, leftInit + barObj.width, bottom);
                canvas.drawRect(rectF, paint);
                leftInit += barObj.width;
            }

            leftInit += barObj.interval;
        }
    }
}
