package originator.ailin.com.smartgraph.chart.scatterplot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;

import originator.ailin.com.smartgraph.axis.AxisX;
import originator.ailin.com.smartgraph.axis.AxisY;
import originator.ailin.com.smartgraph.chart.BaseChart;
import originator.ailin.com.smartgraph.grid.GridY;
import originator.ailin.com.smartgraph.label.Label;
import originator.ailin.com.smartgraph.legend.SimpleScatter;
import originator.ailin.com.smartgraph.polar.PolarBubbleX;
import originator.ailin.com.smartgraph.polar.PolarY;
import originator.ailin.com.smartgraph.title.Title;

public class SimpleScatterPlot extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimpleScatterPlot(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleScatterPlot(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void drawBackground(Canvas canvas) {
        Log.d("kim", "onDraw");
        if(scatterObj.scatterPoint != null) {
            // Draw XY axis
            float dataMaxX = 0, dataMaxY = 0;
            for (PointF point : scatterObj.scatterPoint) {
                dataMaxX = ((point.x + scatterObj.radius) > dataMaxX) ? (point.x + scatterObj.radius) : dataMaxX;
                dataMaxY = ((point.y + scatterObj.radius) > dataMaxY) ? (point.y + scatterObj.radius) : dataMaxY;
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

            // Draw Title
            title = new Title(left, bottom, titleText, titleSize, titleColor, maxWidth, maxHeight);
            showTitle(canvas, paint);

            // Draw PolarXY
            polar = new PolarBubbleX(left, bottom, maxWidth, unitX, polarTextColorX);
            showPolar(getResources(), canvas, paint);
            polar = new PolarY(left, bottom, maxHeight, unitY, polarTextColorY);
            showPolar(getResources(), canvas, paint);

            // Draw label
            label = new Label(left, bottom, 1, labelsText, labelsTextColor, new int[] {color},  maxWidth, maxHeight);
            showLabel(getResources(), canvas, paint);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Thread drawThread = new Thread(new DrawRunnable(holder));
        drawThread.start();
    }

    class DrawRunnable implements Runnable {
        SurfaceHolder holder;

        public DrawRunnable(SurfaceHolder holder) {
            this.holder = holder;
        }

        @Override
        public void run() {
            synchronized (this) {
                for(int i = 1; i <= scatterObj.scatterPoint.length; i++) {
                    Canvas canvas = holder.lockCanvas();
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

                    // Draw Chart Background
                    drawBackground(canvas);

                    // Draw Legend
                    legend = new SimpleScatter(left, bottom, scatterObj, color, (float) i);
                    showLegend(canvas, paint);

                    holder.unlockCanvasAndPost(canvas);

                    try {
                        wait(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
