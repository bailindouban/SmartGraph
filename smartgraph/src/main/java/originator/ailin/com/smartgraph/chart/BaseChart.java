package originator.ailin.com.smartgraph.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import originator.ailin.com.smartgraph.axis.AxisAbs;
import originator.ailin.com.smartgraph.obj.BarObj;
import originator.ailin.com.smartgraph.obj.BubbleObj;
import originator.ailin.com.smartgraph.obj.PieObj;
import originator.ailin.com.smartgraph.obj.ScatterObj;
import originator.ailin.com.smartgraph.grid.GridAbs;
import originator.ailin.com.smartgraph.label.Label;
import originator.ailin.com.smartgraph.legend.LegendAbs;
import originator.ailin.com.smartgraph.legend_value.LegendValue;
import originator.ailin.com.smartgraph.polar.Polar;
import originator.ailin.com.smartgraph.title.Title;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public abstract class BaseChart extends View {
    protected LegendAbs legend;
    protected GridAbs grid;
    protected AxisAbs axis;

    /**
     * Draw Simple Legend
     * @param canvas
     * @param paint
     */
    protected void showLegend(Canvas canvas, Paint paint) {
        legend.drawLegend(canvas, paint);
    }

    protected void showGrid(Canvas canvas, Paint paint) {
        grid.drawGridY(canvas, paint);
    }

    protected void showAxisX(Canvas canvas, Paint paint) {
        axis.drawAxisX(canvas, paint);
    }

    protected void showAxisY(Canvas canvas, Paint paint) {
        axis.drawAxisY(canvas, paint);
    }

    // Setters
    public void setLegend(LegendAbs legend) {
        this.legend = legend;
    }

    public void setGrid(GridAbs grid) {
        this.grid = grid;
    }


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

        labelsText = new String[] {"小明", "小李", "小王", "小白", "小朱", "小志", "小管", "小张"};
        labelsTextColor = Color.BLUE;
    }

    /**
     * Draw PolarX
     * @param canvas
     */
    public void drawPolarX (Canvas canvas, int num, int width, int interval) {
        Polar polar = new Polar(getResources(), canvas, paint, left, bottom);
        polar.drawPolarX(num, width, interval, polarsTextX, polarsTextColorX);
    }

    /**
     * Draw PolarX
     * @param canvas
     * @param maxWidth
     */
    public void drawPolarBubbleX (Canvas canvas, int maxWidth) {
        Polar polar = new Polar(getResources(), canvas, paint, left, bottom);
        polar.drawPolarBubbleX(maxWidth, unitX, polarsTextColorX);
    }

    /**
     * Draw PolarY
     * @param canvas
     * @param maxHeight
     */
    public void drawPolarY (Canvas canvas, int maxHeight) {
        Polar polar = new Polar(getResources(), canvas, paint, left, bottom);
        polar.drawPolarY(maxHeight, unitY, polarsTextColorY);
    }

    /**
     *
     * @param canvas
     * @param maxWidth
     * @param maxHeight
     */
    public void drawTitle (Canvas canvas, float maxWidth, float maxHeight) {
        Title title = new Title(canvas, paint, left, bottom);
        title.drawTitle(titleText, titleSize, titleColor, maxWidth, maxHeight);
    }

    /**
     *
     * @param canvas
     * @param num
     * @param maxWidth
     * @param maxHeight
     * @param labelsIconColor
     */
    public void drawLabel (Canvas canvas, int num, float maxWidth, float maxHeight, int[] labelsIconColor) {
        Label label = new Label(getResources(), canvas, paint, left, bottom);
        label.drawLabel(num, labelsText, labelsTextColor, labelsIconColor,  maxWidth, maxHeight);
    }

    /**
     *
     * @param canvas
     * @param pieObj
     * @param radius
     * @param data
     */
    public void drawLegendValuePie(Canvas canvas, PieObj pieObj, float radius, float[] data) {
        LegendValue legendValue = new LegendValue(getResources(), canvas, paint);
        legendValue.drawValuePie(pieObj, radius, data);
    }

    /**
     *
     * @param canvas
     * @param pieObj
     * @param radiusDealArray
     * @param data
     */
    public void drawLegendValuePieRose(Canvas canvas, PieObj pieObj, float[] radiusDealArray, float[] data) {
        LegendValue legendValue = new LegendValue(getResources(), canvas, paint);
        legendValue.drawValuePieRose(pieObj, radiusDealArray, data);
    }

    public void drawLegendValueBar(Canvas canvas, PieObj pieObj, float radius, float[] data) {
        LegendValue legendValue = new LegendValue(getResources(), canvas, paint);
        legendValue.drawValuePie(pieObj, radius, data);
    }
}
