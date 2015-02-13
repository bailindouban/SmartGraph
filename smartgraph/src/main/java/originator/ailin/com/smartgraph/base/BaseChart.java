package originator.ailin.com.smartgraph.base;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class BaseChart extends View {
    public Paint paint;

    // For Chart Objects
    public BarObj barObj = new BarObj();
    public PieObj pieObj = new PieObj();
    public DoughnutObj doughnutObj = new DoughnutObj();

    // For Bubble Chart
    public float size;

    // For data
    public float[] data;
    public float[][] datas;

    // For color
    public int color = Color.BLACK;
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

        // For Bubble Chart
        size = 10;
    }
}
