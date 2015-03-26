package originator.ailin.com.smartgraph.legend.linechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.base.BaseChart;

public class SimpleLineChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleLineChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleLineChart(Context context, AttributeSet attrs) {
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

            int maxWidth = (data.length - 1)* barObj.interval;
            int maxHeight = (int) dataMax + unitY;
            Axis axis = new Axis(canvas, paint, leftInit, bottom);
            axis.drawAxisX(maxWidth);
            axis.drawAxisY(maxHeight);

            // Draw Grid
            Grid grid = new Grid(canvas, paint, leftInit, bottom);
            grid.drawGridY(maxWidth, maxHeight, unitY);

            // Draw Legend
            paint.setColor(color);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(barObj.width);
            Path path = new Path();
            path.moveTo(leftInit, bottom - data[0]);
            for(int i = 1; i < data.length; i++) {
                leftInit += barObj.interval;
                path.lineTo(leftInit, bottom - data[i]);
            }
            canvas.drawPath(path, paint);

            // Draw Title
            drawTitle(canvas, maxWidth, maxHeight);

            // Draw PolarXY
            drawPolarX(canvas, data.length, 0, barObj.interval);
            drawPolarY(canvas, maxHeight);

            // Draw label
            drawLabel(canvas, 1, maxWidth, maxHeight, new int[]{color});
        }
    }
}
