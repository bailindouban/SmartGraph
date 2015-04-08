package originator.ailin.com.smartgraph.chart.doughnutchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.R;
import originator.ailin.com.smartgraph.chart.base.BaseChart;

public class RoseChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public RoseChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public RoseChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(data != null) {
            // Draw Legend
            paint.setStyle(Paint.Style.STROKE);

            float maxData = data[0];
            for(float d : data) {
                maxData = (d > maxData) ? d : maxData;
            }

            float startAngleInit = pieObj.startAngle;
            float[] radiusDealArray = new float[data.length];
            for(int i = 0; i < data.length; i++) {
                float widthDeal = (pieObj.radiusOuter - pieObj.radiusInner) * data[i] / maxData;
                float radiusDeal = pieObj.radiusInner + (pieObj.radiusOuter - pieObj.radiusInner) * data[i] / maxData / 2;
                radiusDealArray[i] = radiusDeal + widthDeal / 2;
                paint.setStrokeWidth(widthDeal);

                paint.setColor(colors[i]);
                RectF oval = new RectF(pieObj.center.x - radiusDeal, pieObj.center.y - radiusDeal, pieObj.center.x + radiusDeal, pieObj.center.y + radiusDeal);
                float swipeAngle = 360 / data.length;
                canvas.drawArc(oval, startAngleInit, swipeAngle, false, paint);

                startAngleInit += swipeAngle;
            }

            // Draw Legend Value
            drawLegendValuePieRose(canvas, pieObj, radiusDealArray, data);

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
