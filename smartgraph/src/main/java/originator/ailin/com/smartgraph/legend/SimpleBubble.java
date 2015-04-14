package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;

import originator.ailin.com.smartgraph.obj.BubbleObj;
import originator.ailin.com.smartgraph.obj.MyPoint;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class SimpleBubble extends LegendAbs {
    public SimpleBubble(float leftInit, float bottom, BubbleObj bubbleObj, int color, float ratio) {
        initBubbleSimpleParams(leftInit, bottom, bubbleObj, color, ratio);
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {
        paint.setColor(color);
        for(int i = 0; i < ratio; i++) {
            MyPoint point = bubbleObj.bubblePoint[i];
            canvas.drawCircle(leftInit + point.x, bottom - point.y, point.radius, paint);
        }
    }
}
