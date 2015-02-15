package originator.ailin.com.smartgraph.legend.doughnutchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.legend.base.BaseChart;

public class SimpleDoughnutChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleDoughnutChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleDoughnutChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(data != null) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(doughnutObj.radiusOuter - doughnutObj.radiusInner);
            float radius = (doughnutObj.radiusInner + doughnutObj.radiusOuter) / 2;

            float total = 0;
            for(float d : data) {
                total += d;
            }

            for(int i = 0; i < data.length; i++) {
                paint.setColor(colors[i]);
                RectF oval = new RectF(doughnutObj.center.x - radius, doughnutObj.center.y - radius, doughnutObj.center.x + radius, doughnutObj.center.y + radius);
                float swipeAngle = data[i] * 360 / total;
                canvas.drawArc(oval, doughnutObj.startAngle, swipeAngle, false, paint);

                doughnutObj.startAngle += swipeAngle;
            }
        }
    }
}
