package originator.ailin.com.smartgraph.legend.areachart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.base.BaseChart;
import originator.ailin.com.smartgraph.title.Title;

public class SimpleAreaChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleAreaChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleAreaChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");

        if(data != null) {
            int leftInit = left;

            // Draw XY axis
            float dataMax = 0;
            for (float d : data) {
                dataMax = (d > dataMax) ? d : dataMax;
            }

            int unit = 100;
            int maxWidth = (data.length - 1)* barObj.interval;
            int maxHeight = (int) dataMax + unit;
            Axis axis = new Axis(canvas, paint, leftInit, bottom);
            axis.drawAxisX(maxWidth);
            axis.drawAxisY(maxHeight);

            // Draw Grid
            Grid grid = new Grid(canvas, paint, leftInit, bottom);
            grid.drawGridY(maxWidth, maxHeight, unit);

            // Draw Legend
            paint.setColor(color);
            Path path = new Path();
            path.moveTo(leftInit, bottom - data[0]);
            for(int i = 1; i < data.length; i++) {
                leftInit += barObj.interval;
                path.lineTo(leftInit, bottom - data[i]);
            }
            path.lineTo(leftInit, bottom);
            path.lineTo(left, bottom);
            path.close();
            canvas.drawPath(path, paint);

            // Draw Title
            Title title = new Title(canvas, paint, left, bottom);
            title.drawTitle(titleText, titleSize, titleColor, maxWidth, maxHeight);

            // Draw PolarXY
            drawPolarX(canvas, data.length, 0, barObj.interval);
            drawPolarY(canvas, maxHeight);
        }
    }
}
