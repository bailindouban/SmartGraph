package originator.ailin.com.smartgraph.legend.doughnutchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.R;
import originator.ailin.com.smartgraph.legend.base.BaseChart;
import originator.ailin.com.smartgraph.title.Title;

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
            for(int i = 0; i < data.length; i++) {
                float widthDeal = (doughnutObj.radiusOuter - doughnutObj.radiusInner) * data[i] / maxData;
                float radiusDeal = doughnutObj.radiusInner + (doughnutObj.radiusOuter - doughnutObj.radiusInner) * data[i] / maxData / 2;
                paint.setStrokeWidth(widthDeal);

                paint.setColor(colors[i]);
                RectF oval = new RectF(doughnutObj.center.x - radiusDeal, doughnutObj.center.y - radiusDeal, doughnutObj.center.x + radiusDeal, doughnutObj.center.y + radiusDeal);
                float swipeAngle = 360 / data.length;
                canvas.drawArc(oval, doughnutObj.startAngle, swipeAngle, false, paint);

                doughnutObj.startAngle += swipeAngle;
            }

            // Draw Title
            Title title = new Title(canvas, paint, doughnutObj.center.x - doughnutObj.radiusOuter, (int) (doughnutObj.center.y + doughnutObj.radiusOuter - getResources().getDimension(R.dimen.pie_title_margin)));
            title.drawTitle(titleText, titleSize, titleColor, doughnutObj.radiusOuter * 2, doughnutObj.radiusOuter * 2);
        }
    }
}
