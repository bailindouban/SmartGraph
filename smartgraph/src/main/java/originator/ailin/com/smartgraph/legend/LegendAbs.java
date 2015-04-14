package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;

import originator.ailin.com.smartgraph.obj.BarObj;
import originator.ailin.com.smartgraph.obj.BubbleObj;
import originator.ailin.com.smartgraph.obj.PieObj;
import originator.ailin.com.smartgraph.obj.ScatterObj;

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
    public float ratio = 20;

    /**
     *
     * @param leftInit
     * @param bottom
     * @param barObj
     * @param data
     * @param color
     * @param ratio
     */
    public void initBarSimpleParams(float leftInit, float bottom, BarObj barObj, float[] data, int color, float ratio) {
        initLeftBottom(leftInit, bottom);
        this.barObj = barObj;
        this.data = data;
        this.color = color;
        this.ratio = ratio;
    }

    /**
     *
     * @param leftInit
     * @param bottom
     * @param barObj
     * @param datas
     * @param colors
     * @param ratio
     */
    public void initBarParams(float leftInit, float bottom, BarObj barObj, float[][] datas, int[] colors, float ratio) {
        initLeftBottom(leftInit, bottom);
        this.barObj = barObj;
        this.datas = datas;
        this.colors = colors;
        this.ratio = ratio;
    }

    /**
     *
     * @param leftInit
     * @param bottom
     * @param bubbleObj
     * @param color
     */
    public void initBubbleSimpleParams(float leftInit, float bottom, BubbleObj bubbleObj, int color, float ratio) {
        initLeftBottom(leftInit, bottom);
        this.bubbleObj = bubbleObj;
        this.color = color;
        this.ratio = ratio;
    }

    /**
     *
     * @param leftInit
     * @param bottom
     * @param bubbleObj
     * @param colors
     */
    public void initBubbleParams(float leftInit, float bottom, BubbleObj bubbleObj, int[] colors, float ratio) {
        initLeftBottom(leftInit, bottom);
        this.bubbleObj = bubbleObj;
        this.colors = colors;
        this.ratio = ratio;
    }

    /**
     *
     * @param leftInit
     * @param bottom
     * @param scatterObj
     * @param color
     */
    public void initScatterSimpleParams(float leftInit, float bottom, ScatterObj scatterObj, int color, float ratio) {
        initLeftBottom(leftInit, bottom);
        this.scatterObj = scatterObj;
        this.color = color;
        this.ratio = ratio;
    }

    /**
     *
     * @param leftInit
     * @param bottom
     * @param scatterObj
     * @param colors
     */
    public void initScatterParams(float leftInit, float bottom, ScatterObj scatterObj, int[] colors, float ratio) {
        initLeftBottom(leftInit, bottom);
        this.scatterObj = scatterObj;
        this.colors = colors;
        this.ratio = ratio;
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
    public void initPieParams(PieObj pieObj, float[] data, int[] colors, float ratio) {
        this.pieObj = pieObj;
        this.data = data;
        this.colors = colors;
        this.ratio = ratio;
    }

    /**
     *
     * @param canvas
     * @param paint
     */
    public abstract void drawLegend(Canvas canvas, Paint paint);
}
