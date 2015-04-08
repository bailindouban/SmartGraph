package originator.ailin.com.smartgraph.chart.linechart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.Axis;
import originator.ailin.com.smartgraph.chart.base.BaseChart;
import originator.ailin.com.smartgraph.grid.Grid;
import originator.ailin.com.smartgraph.legend.Line;

public class LineChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public LineChart(Context context) {
        super(context);

        init();
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public LineChart(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        legend = new Line();
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
            Axis axis = new Axis(canvas, paint, leftInit, bottom);
            axis.drawAxisX(maxWidth);
            axis.drawAxisY(maxHeight);

            // Draw Grid
            Grid grid = new Grid(canvas, paint, leftInit, bottom);
            grid.drawGridY(maxWidth, maxHeight, unitY);

            // Draw Legend
            showLegend(canvas, paint, leftInit, bottom, barObj, datas, colors);

            // Draw Title
            drawTitle(canvas, maxWidth, maxHeight);

            // Draw PolarXY
            drawPolarX(canvas, datas[0].length, 0, barObj.interval);
            drawPolarY(canvas, maxHeight);

            // Draw label
            drawLabel(canvas, datas.length, maxWidth, maxHeight, colors);
        }
    }
}