package originator.ailin.com.smartgraph.chart.doughnutchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.R;
import originator.ailin.com.smartgraph.chart.base.BaseChart;

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
            // Draw Legend
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(pieObj.radiusOuter - pieObj.radiusInner);
            float radius = (pieObj.radiusInner + pieObj.radiusOuter) / 2;

            float total = 0;
            for(float d : data) {
                total += d;
            }

            float startAngleInit = pieObj.startAngle;
            for(int i = 0; i < data.length; i++) {
                paint.setColor(colors[i]);
                RectF oval = new RectF(pieObj.center.x - radius, pieObj.center.y - radius, pieObj.center.x + radius, pieObj.center.y + radius);
                float swipeAngle = data[i] * 360 / total;
                canvas.drawArc(oval, startAngleInit, swipeAngle, false, paint);

                startAngleInit += swipeAngle;
            }

            // Draw Legend Value
            drawLegendValuePie(canvas, pieObj, pieObj.radiusOuter, data);

            // Draw Title
            left = pieObj.center.x - pieObj.radiusOuter;
            bottom = pieObj.center.y + pieObj.radiusOuter - getResources().getDimension(R.dimen.pie_title_margin);
            float maxWidth = pieObj.radiusOuter * 2;
            float maxHeight = pieObj.radiusOuter * 2;
            drawTitle(canvas, maxWidth, maxHeight);

            // Draw label
            drawLabel(canvas, data.length, maxWidth, maxHeight, colors);
        }
    }
}