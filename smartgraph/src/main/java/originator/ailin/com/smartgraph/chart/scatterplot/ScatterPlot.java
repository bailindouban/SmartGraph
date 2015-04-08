package originator.ailin.com.smartgraph.chart.scatterplot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.chart.base.BaseChart;
import originator.ailin.com.smartgraph.legend.Scatter;

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
            axis = new Axis(left, bottom, maxWidth, maxHeight);
            showAxisX(canvas, paint);
            showAxisY(canvas, paint);

            // Draw Grid
            grid = new Grid(left, bottom, maxWidth, maxHeight, unitY);
            showGrid(canvas, paint);

            // Draw Legend
            legend = new Scatter(left, bottom, scatterObj, colors);
            showLegend(canvas, paint);

            // Draw Title
            drawTitle(canvas, maxWidth, maxHeight);

            // Draw PolarXY
            drawPolarBubbleX(canvas, maxWidth);
            drawPolarY(canvas, maxHeight);

            // Draw label
            drawLabel(canvas, scatterObj.scatterPoints.length, maxWidth, maxHeight, colors);
        }
    }
}
