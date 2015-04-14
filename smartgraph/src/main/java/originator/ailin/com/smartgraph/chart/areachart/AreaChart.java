package originator.ailin.com.smartgraph.chart.areachart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;

import originator.ailin.com.smartgraph.axis.AxisX;
import originator.ailin.com.smartgraph.axis.AxisY;
import originator.ailin.com.smartgraph.chart.BaseChart;
import originator.ailin.com.smartgraph.grid.GridY;
import originator.ailin.com.smartgraph.label.Label;
import originator.ailin.com.smartgraph.legend.Area;
import originator.ailin.com.smartgraph.polar.PolarX;
import originator.ailin.com.smartgraph.polar.PolarY;
import originator.ailin.com.smartgraph.title.Title;

public class AreaChart extends BaseChart {
    private int size;
    private int size_sub;

    /**
     * Constructor 1
     * @param context
     */
    public AreaChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public AreaChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void drawBackground(Canvas canvas) {

        if(datas != null) {
            // Draw XY axis
            Float[][] dataArray = getDataArray();
            float dataMax = 0;
            for (float d : dataArray[0]) {
                dataMax = (d > dataMax) ? d : dataMax;
            }

            int maxWidth = (size_sub - 1) * barObj.interval;
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
            polar = new PolarX(left, bottom, size_sub, 0, barObj.interval, polarsTextX, polarTextColorX);
            showPolar(getResources(), canvas, paint);
            polar = new PolarY(left, bottom, maxHeight, unitY, polarTextColorY);
            showPolar(getResources(), canvas, paint);

            // Draw label
            label = new Label(left, bottom, size, labelsText, labelsTextColor, colors,  maxWidth, maxHeight);
            showLabel(getResources(), canvas, paint);
        }
    }

    /**
     * 要用迭代算法？
     * @return
     */
    private Float[][] getDataArray() {
        size = datas.length;
        size_sub = datas[0].length;

        Float[][] dataArray = new Float[size][size_sub];
        Float[] totalArray = new Float[size_sub];

        for(int j = 0; j < size_sub; j++) {
            float total = 0;
            for(int i = 0; i < size; i++) {
                total += datas[i][j];
            }
            totalArray[j] = total;
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size_sub; j++) {
                dataArray[i][j] = totalArray[j];
                totalArray[j] -= datas[size - i - 1][j];
            }
        }

        return dataArray;
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
                for(int i = 1; i <= animTime; i++) {
                    Canvas canvas = holder.lockCanvas();
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

                    // Draw Chart Background
                    drawBackground(canvas);

                    // Draw Legend
                    legend = new Area(left, bottom, barObj, datas, colors, (float) i / animTime);
                    showLegend(canvas, paint);

                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
