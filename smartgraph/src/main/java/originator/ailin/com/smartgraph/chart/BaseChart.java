package originator.ailin.com.smartgraph.chart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import originator.ailin.com.smartgraph.axis.AxisAbs;
import originator.ailin.com.smartgraph.grid.GridAbs;
import originator.ailin.com.smartgraph.label.LabelAbs;
import originator.ailin.com.smartgraph.legend.LegendAbs;
import originator.ailin.com.smartgraph.value.LegendValue;
import originator.ailin.com.smartgraph.obj.BarObj;
import originator.ailin.com.smartgraph.obj.BubbleObj;
import originator.ailin.com.smartgraph.obj.PieObj;
import originator.ailin.com.smartgraph.obj.ScatterObj;
import originator.ailin.com.smartgraph.polar.PolarAbs;
import originator.ailin.com.smartgraph.title.TitleAbs;
import originator.ailin.com.smartgraph.value.ValueAbs;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public abstract class BaseChart extends View {
    protected LegendAbs legend;
    protected GridAbs grid;
    protected AxisAbs axis;
    protected PolarAbs polar;
    protected TitleAbs title;
    protected LabelAbs label;
    protected ValueAbs value;

    /**
     * Draw Simple Legend
     * @param canvas
     * @param paint
     */
    protected void showLegend(Canvas canvas, Paint paint) {
        legend.drawLegend(canvas, paint);
    }

    /**
     *
     * @param canvas
     * @param paint
     */
    protected void showGrid(Canvas canvas, Paint paint) {
        grid.drawGrid(canvas, paint);
    }

    /**
     *
     * @param canvas
     * @param paint
     */
    protected void showAxis(Canvas canvas, Paint paint) {
        axis.drawAxis(canvas, paint);
    }

    /**
     *
     * @param resources
     * @param canvas
     * @param paint
     */
    protected void showPolar(Resources resources, Canvas canvas, Paint paint) {
        polar.drawPolar(resources, canvas, paint);
    }

    /**
     *
     * @param resources
     * @param canvas
     * @param paint
     */
    protected void showValue(Resources resources, Canvas canvas, Paint paint) {
        value.drawValue(resources, canvas, paint);
    }

    /**
     *
     * @param canvas
     * @param paint
     */
    protected void showTitle(Canvas canvas, Paint paint) {
        title.drawTitle(canvas, paint);
    }

    /**
     *
     * @param resources
     * @param canvas
     * @param paint
     */
    protected void showLabel (Resources resources, Canvas canvas, Paint paint) {
        label.drawLabel(resources, canvas, paint);
    }

    // Setters
    public void setLegend(LegendAbs legend) {
        this.legend = legend;
    }

    public void setAxis(AxisAbs axis) {
        this.axis = axis;
    }

    public void setGrid(GridAbs grid) {
        this.grid = grid;
    }

    public void setPolar(PolarAbs polar) {
        this.polar = polar;
    }

    public void setTitle(TitleAbs title) {
        this.title = title;
    }

    public void setLabel(LabelAbs label) {
        this.label = label;
    }

    public void setValue(ValueAbs value) {
        this.value = value;
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
    public int polarTextColorX, polarTextColorY;

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
        polarTextColorX = Color.BLUE;
        polarTextColorY = Color.BLUE;

        labelsText = new String[] {"小明", "小李", "小王", "小白", "小朱", "小志", "小管", "小张"};
        labelsTextColor = Color.BLUE;
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
