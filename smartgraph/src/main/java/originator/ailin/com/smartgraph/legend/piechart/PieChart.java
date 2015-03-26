package originator.ailin.com.smartgraph.legend.piechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.R;
import originator.ailin.com.smartgraph.legend.base.BaseChart;

public class PieChart extends BaseChart {
    private float mBiasXMax = 0, mBiasXMin = 0, mBiasYMax = 0, mBiasYMin = 0;

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
            // Draw Legend
            float total = 0;
            for (float d : data) {
                total += d;
            }
            for (int i = 0; i < data.length; i++) {
                paint.setColor(colors[i]);
                float swipeAngle = data[i] * 360 / total;

                double radian = Math.PI * (2 * pieObj.startAngle + swipeAngle) / 360;
                PointF biasXY = new PointF();
                biasXY.set(pieObj.bias[i] * (float) Math.cos(radian), pieObj.bias[i] * (float) Math.sin(radian));
                mBiasXMax = (mBiasXMax < biasXY.x) ? biasXY.x : mBiasXMax;
                mBiasXMin = (mBiasXMin > biasXY.x) ? biasXY.x : mBiasXMin;
                mBiasYMax = (mBiasYMax < biasXY.y) ? biasXY.y : mBiasYMax;
                mBiasYMin = (mBiasYMin > biasXY.y) ? biasXY.y : mBiasYMin;

                RectF oval = new RectF(pieObj.center.x - pieObj.radius + biasXY.x, pieObj.center.y - pieObj.radius + biasXY.y, pieObj.center.x + pieObj.radius + biasXY.x, pieObj.center.y + pieObj.radius + biasXY.y);

                canvas.drawArc(oval, pieObj.startAngle, swipeAngle, true, paint);
                pieObj.startAngle += swipeAngle;
            }

            // Draw Title
            left = pieObj.center.x - pieObj.radius + mBiasXMin;
            bottom = pieObj.center.y + pieObj.radius + mBiasYMax - getResources().getDimension(R.dimen.pie_title_margin);
            float maxWidth = pieObj.radius * 2 - mBiasXMin + mBiasXMax;
            float maxHeight = pieObj.radius * 2 - mBiasYMin + mBiasYMax;
            drawTitle(canvas, maxWidth, maxHeight);

            // Draw label
            drawLabel(canvas, data.length, maxWidth, maxHeight, colors);
        }
    }
}
