package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;

import originator.ailin.com.smartgraph.chart.base.obj.BarObj;
import originator.ailin.com.smartgraph.chart.base.obj.BubbleObj;
import originator.ailin.com.smartgraph.chart.base.obj.PieObj;
import originator.ailin.com.smartgraph.chart.base.obj.ScatterObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public abstract class LegendAbs {
    public float leftInit;
    public float bottom;
    public BarObj barObj;
    public BubbleObj bubbleObj;
    public ScatterObj scatterObj;
    public PieObj pieObj;

    public float[] data;
    public int color;
    public float[][] datas;
    public int[] colors;

    /**
     *
     * @param leftInit
     * @param bottom
     * @param barObj
     * @param data
     * @param color
     */
    public void initBarSimpleParams(float leftInit, float bottom, BarObj barObj, float[] data, int color) {
        initLeftBottom(leftInit, bottom);
        this.barObj = barObj;
        this.data = data;
        this.color = color;
    }

    /**
     *
     * @param leftInit
     * @param bottom
     * @param barObj
     * @param datas
     * @param colors
     */
    public void initBarParams(float leftInit, float bottom, BarObj barObj, float[][] datas, int[] colors) {
        initLeftBottom(leftInit, bottom);
        this.barObj = barObj;
        this.datas = datas;
        this.colors = colors;
    }

    /**
     *
     * @param leftInit
     * @param bottom
     * @param bubbleObj
     * @param color
     */
    public void initBubbleSimpleParams(float leftInit, float bottom, BubbleObj bubbleObj, int color) {
        initLeftBottom(leftInit, bottom);
        this.bubbleObj = bubbleObj;
        this.color = color;
    }

    /**
     *
     * @param leftInit
     * @param bottom
     * @param bubbleObj
     * @param colors
     */
    public void initBubbleParams(float leftInit, float bottom, BubbleObj bubbleObj, int[] colors) {
        initLeftBottom(leftInit, bottom);
        this.bubbleObj = bubbleObj;
        this.colors = colors;
    }

    /**
     *
     * @param leftInit
     * @param bottom
     * @param scatterObj
     * @param color
     */
    public void initScatterSimpleParams(float leftInit, float bottom, ScatterObj scatterObj, int color) {
        initLeftBottom(leftInit, bottom);
        this.scatterObj = scatterObj;
        this.color = color;
    }

    /**
     *
     * @param leftInit
     * @param bottom
     * @param scatterObj
     * @param colors
     */
    public void initScatterParams(float leftInit, float bottom, ScatterObj scatterObj, int[] colors) {
        initLeftBottom(leftInit, bottom);
        this.scatterObj = scatterObj;
        this.colors = colors;
    }

    /**
     *
     * @param leftInit
     * @param bottom
     */
    private void initLeftBottom(float leftInit, float bottom) {
        this.leftInit = leftInit;
        this.bottom = bottom;
    }

    /**
     *
     * @param pieObj
     * @param data
     * @param colors
     */
    public void initPieParams(PieObj pieObj, float[] data, int[] colors) {
        this.pieObj = pieObj;
        this.data = data;
        this.colors = colors;
    }

    /**
     *
     * @param canvas
     * @param paint
     */
    public abstract void drawLegend(Canvas canvas, Paint paint);
}
