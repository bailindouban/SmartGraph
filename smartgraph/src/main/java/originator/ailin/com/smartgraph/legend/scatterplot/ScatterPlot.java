package originator.ailin.com.smartgraph.legend.scatterplot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.base.BaseChart;
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

            int unitX = 100, unitY = 100;
            int maxWidth = (int) dataMaxX + unitX;
            int maxHeight = (int) dataMaxY + unitY;
            Axis axis = new Axis(canvas, paint, left, bottom);
            axis.drawAxisX(maxWidth);
            axis.drawAxisY(maxHeight);

            // Draw Grid
            Grid grid = new Grid(canvas, paint, left, bottom);
            grid.drawGridY(maxWidth, maxHeight, unitY);

            // Draw Legend
            for(int i = 0; i < scatterObj.scatterPoints.length; i++) {
                paint.setColor(colors[i]);
                for(PointF point : scatterObj.scatterPoints[i]) {
                    canvas.drawCircle(left + point.x, bottom - point.y, scatterObj.radii[i], paint);
                }
            }

            // Draw Title
            Title title = new Title(canvas, paint, left, bottom);
            title.drawTitle(titleText, titleSize, titleColor, maxWidth, maxHeight);

            // Draw PolarXY
            drawPolarBubbleX(canvas, maxWidth);
            drawPolarY(canvas, maxHeight);
        }
    }
}
