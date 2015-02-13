package originator.ailin.com.smartgraph.doughnutchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.BaseChart;

public class DoughnutChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public DoughnutChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public DoughnutChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(data != null) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(doughnutObj.radiusOuter - doughnutObj.radiusInner);
            float radius = (doughnutObj.radiusInner + doughnutObj.radiusOuter ) / 2;

            float total = 0;
            for(float d : data) {
                total += d;
            }

            for(int i = 0; i < data.length; i++) {
                paint.setColor(colors[i]);
                float swipeAngle = data[i] * 360 / total;

                double radian = Math.PI * (2 * doughnutObj.startAngle + swipeAngle) / 360;
                PointF biasXY = new PointF();
                biasXY.set(doughnutObj.bias[i] * (float)Math.cos(radian), doughnutObj.bias[i] * (float)Math.sin(radian));
                RectF oval = new RectF(doughnutObj.center.x - radius + biasXY.x, doughnutObj.center.y - radius + biasXY.y, doughnutObj.center.x + radius + biasXY.x, doughnutObj.center.y + radius + biasXY.y);

                canvas.drawArc(oval, doughnutObj.startAngle, swipeAngle, false, paint);
                doughnutObj.startAngle += swipeAngle;
            }
        }
    }
}
