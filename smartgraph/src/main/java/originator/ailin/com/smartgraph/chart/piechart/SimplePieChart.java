package originator.ailin.com.smartgraph.chart.piechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;

import originator.ailin.com.smartgraph.R;
import originator.ailin.com.smartgraph.chart.BaseChart;
import originator.ailin.com.smartgraph.label.Label;
import originator.ailin.com.smartgraph.legend.SimplePie;
import originator.ailin.com.smartgraph.title.Title;
import originator.ailin.com.smartgraph.value.ValuePie;

public class SimplePieChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public SimplePieChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimplePieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void drawBackground(Canvas canvas) {
        Log.d("kim", "onDraw");

        if(data != null) {

            // Draw Title
            left = pieObj.center.x - pieObj.radius;
            bottom = pieObj.center.y + pieObj.radius - getResources().getDimension(R.dimen.pie_title_margin);
            float maxWidth = pieObj.radius * 2;
            float maxHeight = pieObj.radius * 2;
            title = new Title(left, bottom, titleText, titleSize, titleColor, maxWidth, maxHeight);
            showTitle(canvas, paint);

            // Draw label
            label = new Label(left, bottom, data.length, labelsText, labelsTextColor, colors,  maxWidth, maxHeight);
            showLabel(getResources(), canvas, paint);

            // Draw Legend Value
            value = new ValuePie(pieObj, pieObj.radius, data);
            showValue(getResources(), canvas, paint);
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
                for(int i = 1; i <= data.length; i++) {
                    Canvas canvas = holder.lockCanvas();
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

                    // Draw Legend
                    legend = new SimplePie(pieObj, data, colors, i);
                    showLegend(canvas, paint);

                    // Draw Chart Background
                    drawBackground(canvas);

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
