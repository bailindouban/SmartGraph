package originator.ailin.com.smartgraph.chart.doughnutchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.R;
import originator.ailin.com.smartgraph.chart.base.BaseChart;
import originator.ailin.com.smartgraph.legend.Doughnut;

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
            legend = new Doughnut(pieObj, data, colors);
            showLegend(canvas, paint);

            // Draw Legend Value
            drawLegendValuePie(canvas, pieObj, pieObj.radiusOuter, data);

            // Draw Title
            float total = 0;
            for(float d : data) {
                total += d;
            }

            float startAngleInit = pieObj.startAngle;
            for(int i = 0; i < data.length; i++) {
                paint.setColor(colors[i]);
                float swipeAngle = data[i] * 360 / total;

                double radian = Math.PI * (2 * startAngleInit + swipeAngle) / 360;
                PointF biasXY = new PointF();
                biasXY.set(pieObj.bias[i] * (float)Math.cos(radian), pieObj.bias[i] * (float)Math.sin(radian));
                mBiasXMax = (mBiasXMax < biasXY.x) ? biasXY.x : mBiasXMax;
                mBiasXMin = (mBiasXMin > biasXY.x) ? biasXY.x : mBiasXMin;
                mBiasYMax = (mBiasYMax < biasXY.y) ? biasXY.y : mBiasYMax;
                mBiasYMin = (mBiasYMin > biasXY.y) ? biasXY.y : mBiasYMin;

                startAngleInit += swipeAngle;
            }

            left = pieObj.center.x - pieObj.radiusOuter + mBiasXMin;
            bottom = pieObj.center.y + pieObj.radiusOuter + mBiasYMax - getResources().getDimension(R.dimen.pie_title_margin);
            float maxWidth = pieObj.radiusOuter * 2 - mBiasXMin + mBiasXMax;
            float maxHeight = pieObj.radiusOuter * 2 - mBiasYMin + mBiasYMax;
            drawTitle(canvas, maxWidth, maxHeight);

            // Draw label
            drawLabel(canvas, data.length, maxWidth, maxHeight, colors);
        }
    }
}
