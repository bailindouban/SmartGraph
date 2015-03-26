package originator.ailin.com.smartgraph.legend.piechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.R;
import originator.ailin.com.smartgraph.legend.base.BaseChart;
import originator.ailin.com.smartgraph.title.Title;

public class SimplePieChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimplePieChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimplePieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(data != null) {
            // Draw Legend
            float total = 0;
            for(float d : data) {
                total += d;
            }
            for(int i = 0; i < data.length; i++) {
                paint.setColor(colors[i]);
                RectF oval = new RectF(pieObj.center.x - pieObj.radius, pieObj.center.y - pieObj.radius, pieObj.center.x + pieObj.radius, pieObj.center.y + pieObj.radius);
                float swipeAngle = data[i] * 360 / total;
                canvas.drawArc(oval, pieObj.startAngle, swipeAngle, true, paint);
                pieObj.startAngle += swipeAngle;
            }

            // Draw Title
            Title title = new Title(canvas, paint, pieObj.center.x - pieObj.radius, (int) (pieObj.center.y + pieObj.radius - getResources().getDimension(R.dimen.pie_title_margin)));
            title.drawTitle(titleText, titleSize, titleColor, pieObj.radius * 2, pieObj.radius * 2);
        }

    }
}
