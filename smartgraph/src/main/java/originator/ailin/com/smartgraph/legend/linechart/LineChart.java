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
            int leftInit = left;

            // Draw XY axis
            float dataMax = 0;
            for (float[] data : datas) {
                for(float d : data) {
                    dataMax = (d > dataMax) ? d : dataMax;
                }
            }
            int unit = 100;
            int maxWidth = (datas[0].length - 1) * barObj.interval;
            int maxHeight = (int) dataMax + unit;
            Axis axis = new Axis(canvas, paint, leftInit, bottom);
            axis.drawAxisX(maxWidth);
            axis.drawAxisY(maxHeight);

            // Draw Grid
            Grid grid = new Grid(canvas, paint, leftInit, bottom);
            grid.drawGridY(maxWidth, maxHeight, unit);

            for(int i = 0; i < datas.length; i++) {
                leftInit = left;
                // Draw Legend
                paint.setColor(colors[i]);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(barObj.width);
                Path path = new Path();
                path.moveTo(leftInit, bottom - datas[i][0]);
                for(int j = 1; j < datas[i].length; j++) {
                    leftInit += barObj.interval;
                    path.lineTo(leftInit, bottom - datas[i][j]);
                }
                canvas.drawPath(path, paint);

            }

            // Draw Title
            Title title = new Title(canvas, paint, left, bottom);
            title.drawTitle(titleText, titleSize, titleColor, maxWidth, maxHeight);
        }
    }
}
