package originator.ailin.com.smartgraph.chart.scatterplot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.AxisX;
import originator.ailin.com.smartgraph.axis.AxisY;
import originator.ailin.com.smartgraph.grid.GridY;
import originator.ailin.com.smartgraph.chart.BaseChart;
import originator.ailin.com.smartgraph.legend.Scatter;
import originator.ailin.com.smartgraph.polar.PolarBubbleX;
import originator.ailin.com.smartgraph.polar.PolarY;
import originator.ailin.com.smartgraph.title.Title;

public class ScatterPlot extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public ScatterPlot(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public ScatterPlot(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(scatterObj.scatterPoints != null) {
            // Draw XY axis
            float dataMaxX = 0, dataMaxY = 0;
            for (int i = 0; i < scatterObj.scatterPoints.length; i++) {
                for(PointF point : scatterObj.scatterPoints[i]) {
                    dataMaxX = ((point.x + scatterObj.radii[i]) > dataMaxX) ? (point.x + scatterObj.radii[i]) : dataMaxX;
                    dataMaxY = ((point.y + scatterObj.radii[i]) > dataMaxY) ? (point.y + scatterObj.radii[i]) : dataMaxY;
                }
            }

            int maxWidth = (int) dataMaxX + unitX;
            int maxHeight = (int) dataMaxY + unitY;
            axisX = new AxisX(left, bottom, maxWidth, maxHeight);
            axisY = new AxisY(left, bottom, maxWidth, maxHeight);
            showAxisX(canvas, paint);
            showAxisY(canvas, paint);

            // Draw Grid
            gridY = new GridY(left, bottom, maxWidth, maxHeight, unitY);
            showGridY(canvas, paint);

            // Draw Legend
            legend = new Scatter(left, bottom, scatterObj, colors);
            showLegend(canvas, paint);

            // Draw Title
            title = new Title(left, bottom, titleText, titleSize, titleColor, maxWidth, maxHeight);
            showTitle(canvas, paint);

            // Draw PolarXY
            polarBubbleX = new PolarBubbleX(left, bottom, maxWidth, unitX, polarTextColorX);
            polarY = new PolarY(left, bottom, maxHeight, unitY, polarTextColorY);
            showPolarBubbleX(getResources(), canvas, paint);
            showPolarY(getResources(), canvas, paint);

            // Draw label
            drawLabel(canvas, scatterObj.scatterPoints.length, maxWidth, maxHeight, colors);
        }
    }
}
