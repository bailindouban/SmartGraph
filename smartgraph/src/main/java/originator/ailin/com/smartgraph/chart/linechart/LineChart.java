package originator.ailin.com.smartgraph.chart.linechart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.AxisX;
import originator.ailin.com.smartgraph.axis.AxisY;
import originator.ailin.com.smartgraph.chart.BaseChart;
import originator.ailin.com.smartgraph.grid.GridY;
import originator.ailin.com.smartgraph.legend.Line;
import originator.ailin.com.smartgraph.polar.PolarX;
import originator.ailin.com.smartgraph.polar.PolarY;
import originator.ailin.com.smartgraph.title.Title;

public class LineChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public LineChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public LineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(datas != null) {
            float leftInit = left;

            // Draw XY axis
            float dataMax = 0;
            for (float[] data : datas) {
                for(float d : data) {
                    dataMax = (d > dataMax) ? d : dataMax;
                }
            }

            int maxWidth = (datas[0].length - 1) * barObj.interval;
            int maxHeight = (int) dataMax + unitY;
            axisX = new AxisX(left, bottom, maxWidth, maxHeight);
            axisY = new AxisY(left, bottom, maxWidth, maxHeight);
            showAxisX(canvas, paint);
            showAxisY(canvas, paint);

            // Draw Grid
            gridY = new GridY(left, bottom, maxWidth, maxHeight, unitY);
            showGridY(canvas, paint);

            // Draw Legend
            legend = new Line(left, bottom, barObj, datas, colors);
            showLegend(canvas, paint);

            // Draw Title
            title = new Title(left, bottom, titleText, titleSize, titleColor, maxWidth, maxHeight);
            showTitle(canvas, paint);

            // Draw PolarXY
            polarX = new PolarX(left, bottom, datas[0].length, 0, barObj.interval, polarsTextX, polarTextColorX);
            polarY = new PolarY(left, bottom, maxHeight, unitY, polarTextColorY);
            showPolarX(getResources(), canvas, paint);
            showPolarY(getResources(), canvas, paint);

            // Draw label
            drawLabel(canvas, datas.length, maxWidth, maxHeight, colors);
        }
    }
}
