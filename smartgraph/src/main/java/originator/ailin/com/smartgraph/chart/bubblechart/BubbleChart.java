package originator.ailin.com.smartgraph.chart.bubblechart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.axis.AxisX;
import originator.ailin.com.smartgraph.axis.AxisY;
import originator.ailin.com.smartgraph.chart.BaseChart;
import originator.ailin.com.smartgraph.grid.GridY;
import originator.ailin.com.smartgraph.label.Label;
import originator.ailin.com.smartgraph.legend.Bubble;
import originator.ailin.com.smartgraph.obj.MyPoint;
import originator.ailin.com.smartgraph.polar.PolarBubbleX;
import originator.ailin.com.smartgraph.polar.PolarY;
import originator.ailin.com.smartgraph.title.Title;

public class BubbleChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public BubbleChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public BubbleChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(bubbleObj.bubblePoints != null) {
            // Draw XY axis
            float dataMaxX = 0, dataMaxY = 0;
            for (MyPoint[] points : bubbleObj.bubblePoints) {
                for(MyPoint point : points) {
                    dataMaxX = ((point.x + point.radius) > dataMaxX) ? (point.x + point.radius) : dataMaxX;
                    dataMaxY = ((point.y + point.radius) > dataMaxY) ? (point.y + point.radius) : dataMaxY;
                }
            }

            int maxWidth = (int) dataMaxX + unitX;
            int maxHeight = (int) dataMaxY + unitY;
            axis = new AxisX(left, bottom, maxWidth, maxHeight);
            showAxis(canvas, paint);
            axis = new AxisY(left, bottom, maxWidth, maxHeight);
            showAxis(canvas, paint);

            // Draw Grid
            grid = new GridY(left, bottom, maxWidth, maxHeight, unitY);
            showGrid(canvas, paint);

            // Draw Legend
            legend = new Bubble(left, bottom, bubbleObj, colors);
            showLegend(canvas, paint);

            // Draw Title
            title = new Title(left, bottom, titleText, titleSize, titleColor, maxWidth, maxHeight);
            showTitle(canvas, paint);

            // Draw PolarXY
            polar = new PolarBubbleX(left, bottom, maxWidth, unitX, polarTextColorX);
            showPolar(getResources(), canvas, paint);
            polar = new PolarY(left, bottom, maxHeight, unitY, polarTextColorY);
            showPolar(getResources(), canvas, paint);

            // Draw label
            label = new Label(left, bottom, bubbleObj.bubblePoints.length, labelsText, labelsTextColor, colors,  maxWidth, maxHeight);
            showLabel(getResources(), canvas, paint);
        }
    }
}
