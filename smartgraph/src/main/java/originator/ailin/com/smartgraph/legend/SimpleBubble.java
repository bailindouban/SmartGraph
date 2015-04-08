package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;

import originator.ailin.com.smartgraph.chart.base.obj.BubbleObj;
import originator.ailin.com.smartgraph.chart.base.obj.MyPoint;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class SimpleBubble extends LegendAbs {
    public SimpleBubble(float leftInit, float bottom, BubbleObj bubbleObj, int color) {
        initBubbleSimpleParams(leftInit, bottom, bubbleObj, color);
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {
        paint.setColor(color);
        for(MyPoint point : bubbleObj.bubblePoint) {
            canvas.drawCircle(leftInit + point.x, bottom - point.y, point.radius, paint);
        }
    }
}
