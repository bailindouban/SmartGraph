package originator.ailin.com.smartgraph.chart.doughnutchart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.R;
import originator.ailin.com.smartgraph.chart.BaseChart;
import originator.ailin.com.smartgraph.label.Label;
import originator.ailin.com.smartgraph.legend.Rose;
import originator.ailin.com.smartgraph.title.Title;
import originator.ailin.com.smartgraph.value.ValueRose;

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
            legend = new Rose(pieObj, data, colors);
            showLegend(canvas, paint);

            // Draw Legend Value
            float maxData = data[0];
            for(float d : data) {
                maxData = (d > maxData) ? d : maxData;
            }
            float[] radiusDealArray = new float[data.length];
            for(int i = 0; i < data.length; i++) {
                float widthDeal = (pieObj.radiusOuter - pieObj.radiusInner) * data[i] / maxData;
                float radiusDeal = pieObj.radiusInner + (pieObj.radiusOuter - pieObj.radiusInner) * data[i] / maxData / 2;
                radiusDealArray[i] = radiusDeal + widthDeal / 2;
            }
            value = new ValueRose(pieObj, radiusDealArray, data);
            showValue(getResources(), canvas, paint);

            // Draw Title
            left = pieObj.center.x - pieObj.radiusOuter;
            bottom = pieObj.center.y + pieObj.radiusOuter - getResources().getDimension(R.dimen.pie_title_margin);
            float maxWidth = pieObj.radiusOuter * 2;
            float maxHeight = pieObj.radiusOuter * 2;
            title = new Title(left, bottom, titleText, titleSize, titleColor, maxWidth, maxHeight);
            showTitle(canvas, paint);

            // Draw label
            label = new Label(left, bottom, data.length, labelsText, labelsTextColor, colors,  maxWidth, maxHeight);
            showLabel(getResources(), canvas, paint);
        }
    }
}
