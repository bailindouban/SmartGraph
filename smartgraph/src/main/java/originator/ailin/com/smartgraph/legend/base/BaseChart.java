package originator.ailin.com.smartgraph.legend.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import originator.ailin.com.smartgraph.legend.base.obj.BarObj;
import originator.ailin.com.smartgraph.legend.base.obj.BubbleObj;
import originator.ailin.com.smartgraph.legend.base.obj.DoughnutObj;
import originator.ailin.com.smartgraph.legend.base.obj.PieObj;
import originator.ailin.com.smartgraph.legend.base.obj.ScatterObj;
import originator.ailin.com.smartgraph.polar.Polar;
import originator.ailin.com.smartgraph.title.Title;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public abstract class BaseChart extends View {
    public Paint paint;

    // For X / Y axis
    public float left = 100, bottom = 1000;

    // For title
    public String titleText;
    public int titleSize;
    public int titleColor;

    // For polarX
    public String[] polarsTextX;
    public int polarsTextColorX, polarsTextColorY;

    // For label
    public String[] labelsText;
    public int labelsTextColor;

    // For Chart Objects
    public BarObj barObj = new BarObj();
    public PieObj pieObj = new PieObj();
    public DoughnutObj doughnutObj = new DoughnutObj();
    public BubbleObj bubbleObj = new BubbleObj();
    public ScatterObj scatterObj = new ScatterObj();

    // For data
    public float[] data;
    public float[][] datas;

    // For color
    public int color = Color.BLACK;
    public int[] colors;

    // Unit Scale
    public int unitX = 100, unitY = 100;

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

        titleText = "Chart Title";
        titleColor = Color.BLUE;
        titleSize = 50;

        polarsTextX = new String[] {"1月份", "2月份", "3月份", "4月份", "5月份", "6月份", "7月份", "8月份", "9月份", "10月份", "11月份", "12月份"};
        polarsTextColorX = Color.BLUE;
        polarsTextColorY = Color.BLUE;

        labelsText = new String[] {"小明", "小李", "小王", "小白"};
        labelsTextColor = Color.BLUE;
    }

    /**
     * Draw PolarX
     * @param canvas
     */
    public void drawPolarX(Canvas canvas, int num, int width, int interval) {
        Polar polar = new Polar(getResources(), canvas, paint, left, bottom);
        polar.drawPolarX(num, width, interval, polarsTextX, polarsTextColorX);
    }

    /**
     * Draw PolarX
     * @param canvas
     * @param maxWidth
     */
    public void drawPolarBubbleX(Canvas canvas, int maxWidth) {
        Polar polar = new Polar(getResources(), canvas, paint, left, bottom);
        polar.drawPolarBubbleX(maxWidth, unitX, polarsTextColorX);
    }

    /**
     * Draw PolarY
     * @param canvas
     * @param maxHeight
     */
    public void drawPolarY(Canvas canvas, int maxHeight) {
        Polar polar = new Polar(getResources(), canvas, paint, left, bottom);
        polar.drawPolarY(maxHeight, unitY, polarsTextColorY);
    }

    public void drawTitle(Canvas canvas, float maxWidth, float maxHeight) {
        Title title = new Title(canvas, paint, left, bottom);
        title.drawTitle(titleText, titleSize, titleColor, maxWidth, maxHeight);
    }
}
