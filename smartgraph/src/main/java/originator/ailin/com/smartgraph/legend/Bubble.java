package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;

import originator.ailin.com.smartgraph.obj.BubbleObj;
import originator.ailin.com.smartgraph.obj.MyPoint;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class Bubble extends LegendAbs {
    public Bubble(float leftInit, float bottom, BubbleObj bubbleObj, int[] colors, float ratio) {
        initBubbleParams(leftInit, bottom, bubbleObj, colors, ratio);
    }

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {

        for(int i = 0; i < bubbleObj.bubblePoints.length; i++) {
            paint.setColor(colors[i]);
            for(int j = 0; j < ratio; j++) {
                MyPoint point = bubbleObj.bubblePoints[i][j];
                canvas.drawCircle(leftInit + point.x, bottom - point.y, point.radius, paint);
            }
        }
    }
}
