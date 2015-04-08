package originator.ailin.com.smartgraph.chart.doughnutchart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.R;
import originator.ailin.com.smartgraph.chart.base.BaseChart;
import originator.ailin.com.smartgraph.legend.SimpleDoughnut;

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
            legend = new SimpleDoughnut(pieObj, data, colors);
            showLegend(canvas, paint);

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
