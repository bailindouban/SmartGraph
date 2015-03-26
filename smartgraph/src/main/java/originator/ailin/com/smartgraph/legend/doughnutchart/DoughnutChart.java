package originator.ailin.com.smartgraph.legend.doughnutchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.R;
import originator.ailin.com.smartgraph.legend.base.BaseChart;
import originator.ailin.com.smartgraph.title.Title;

public class DoughnutChart extends BaseChart {
    private float mBiasXMax = 0, mBiasXMin = 0, mBiasYMax = 0, mBiasYMin = 0;

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
            // Draw Legend
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
                mBiasXMax = (mBiasXMax < biasXY.x) ? biasXY.x : mBiasXMax;
                mBiasXMin = (mBiasXMin > biasXY.x) ? biasXY.x : mBiasXMin;
                mBiasYMax = (mBiasYMax < biasXY.y) ? biasXY.y : mBiasYMax;
                mBiasYMin = (mBiasYMin > biasXY.y) ? biasXY.y : mBiasYMin;

                RectF oval = new RectF(doughnutObj.center.x - radius + biasXY.x, doughnutObj.center.y - radius + biasXY.y, doughnutObj.center.x + radius + biasXY.x, doughnutObj.center.y + radius + biasXY.y);

                canvas.drawArc(oval, doughnutObj.startAngle, swipeAngle, false, paint);
                doughnutObj.startAngle += swipeAngle;
            }

            // Draw Title
            Title title = new Title(canvas, paint, doughnutObj.center.x - doughnutObj.radiusOuter + mBiasXMin, doughnutObj.center.y + doughnutObj.radiusOuter + mBiasYMax - getResources().getDimension(R.dimen.pie_title_margin));
            title.drawTitle(titleText, titleSize, titleColor, doughnutObj.radiusOuter * 2 - mBiasXMin + mBiasXMax, doughnutObj.radiusOuter * 2 - mBiasYMin + mBiasYMax);
        }
    }
}
