package originator.ailin.com.smartgraph.base;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class BaseChart extends View {
    public Paint paint;

    // For Bar Chart
    public int left, bottom, width, interval;

    // For Pie Chart
    public Point center;
    public int radius;
    public float startAngle;
    public float bias[];

    // For data
    public float[] data;
    public float[][] datas;

    // For color
    public int color;
    public int[] colors;

    /**
     * Constructor 1
     *
     * @param context
     */
    public BaseChart(Context context) {
        super(context);
        init();
    }

    /**
     * Constructor 2
     *
     * @param context
     * @param attrs
     */
    public BaseChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * Init params
     */
    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);

        // For Bar Chart
        left = 100;
        bottom = 1000;
        width = 50;
        interval = 30;

        // For Pie Chart
        center = new Point(500, 400);
        radius = 150;
        startAngle = 0;

        // For color
        color = Color.BLACK;
    }
}
