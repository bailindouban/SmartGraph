package originator.ailin.com.smartgraph.piechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.BaseChart;

public class PieChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public PieChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(data != null) {
            float total = 0;
            for(float d : data) {
                total += d;
            }
            for(int i = 0; i < data.length; i++) {
                paint.setColor(colors[i]);
                float swipeAngle = data[i] * 360 / total;

                double radian = Math.PI * (2 * startAngle + swipeAngle) / 360;
                PointF biasXY = new PointF();
                biasXY.set(bias[i] * (float)Math.cos(radian), bias[i] * (float)Math.sin(radian));
                RectF oval = new RectF(center.x - radius + biasXY.x, center.y - radius + biasXY.y, center.x + radius + biasXY.x, center.y + radius + biasXY.y);

                canvas.drawArc(oval, startAngle, swipeAngle, true, paint);
                startAngle += swipeAngle;
            }
        }
    }
}
