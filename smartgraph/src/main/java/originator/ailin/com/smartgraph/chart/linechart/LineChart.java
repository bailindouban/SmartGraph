package originator.ailin.com.smartgraph.chart.linechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;

import originator.ailin.com.smartgraph.axis.AxisX;
import originator.ailin.com.smartgraph.axis.AxisY;
import originator.ailin.com.smartgraph.chart.BaseChart;
import originator.ailin.com.smartgraph.grid.GridY;
import originator.ailin.com.smartgraph.label.Label;
import originator.ailin.com.smartgraph.legend.Line;
import originator.ailin.com.smartgraph.polar.PolarX;
import originator.ailin.com.smartgraph.polar.PolarY;
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
    protected void drawBackground(Canvas canvas) {
        Log.d("kim", "onDraw");
        if(datas != null) {
            // Draw XY axis
            float dataMax = 0;
            for (float[] data : datas) {
                for(float d : data) {
                    dataMax = (d > dataMax) ? d : dataMax;
                }
            }

            int maxWidth = (datas[0].length - 1) * barObj.interval;
            int maxHeight = (int) dataMax + unitY;
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
            polar = new PolarX(left, bottom, datas[0].length, 0, barObj.interval, polarsTextX, polarTextColorX);
            showPolar(getResources(), canvas, paint);
            polar = new PolarY(left, bottom, maxHeight, unitY, polarTextColorY);
            showPolar(getResources(), canvas, paint);

            // Draw label
            label = new Label(left, bottom, datas.length, labelsText, labelsTextColor, colors,  maxWidth, maxHeight);
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
                for(int i = 2; i <= datas[0].length; i++) {
                    Canvas canvas = holder.lockCanvas();
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

                    // Draw Chart Background
                    drawBackground(canvas);

                    // Draw Legend
                    legend = new Line(left, bottom, barObj, datas, colors, (float) i);
                    showLegend(canvas, paint);

                    holder.unlockCanvasAndPost(canvas);

                    try {
                        wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
