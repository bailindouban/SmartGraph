package originator.ailin.com.smartgraph.legend.barchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.label.Label;
import originator.ailin.com.smartgraph.legend.base.BaseChart;

public class SimpleBarChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleBarChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(data != null) {
            float leftInit = left;

            // Draw XY axis
            float dataMax = 0;
            for (float d : data) {
                dataMax = (d > dataMax) ? d : dataMax;
            }

            int unit = 100;
            int maxWidth = data.length * (barObj.width + barObj.interval);
            int maxHeight = (int) dataMax + unit;
            Axis axis = new Axis(canvas, paint, left, bottom);
            axis.drawAxisX(maxWidth);
            axis.drawAxisY(maxHeight);

            // Draw Grid
            Grid grid = new Grid(canvas, paint, left, bottom);
            grid.drawGridY(maxWidth, maxHeight, unit);

            // Draw Legend
            for(float d : data) {
                paint.setColor(color);
                RectF rectF = new RectF(leftInit, bottom - d, leftInit + barObj.width, bottom);
                canvas.drawRect(rectF, paint);
                leftInit += barObj.width + barObj.interval;
            }

            // Draw Title
            drawTitle(canvas, maxWidth, maxHeight);

            // Draw PolarXY
            drawPolarX(canvas, data.length, barObj.width, barObj.interval);
            drawPolarY(canvas, maxHeight);

            // Draw label
            Label label = new Label(getResources(), canvas, paint, left, bottom);
            label.drawLabel(labelsText, labelsTextColor, new int[]{color},  maxWidth, maxHeight);
        }
    }
}
