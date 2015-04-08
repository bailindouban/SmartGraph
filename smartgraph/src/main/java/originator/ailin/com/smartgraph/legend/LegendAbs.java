package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;

import originator.ailin.com.smartgraph.chart.base.obj.BarObj;
import originator.ailin.com.smartgraph.chart.base.obj.BubbleObj;
import originator.ailin.com.smartgraph.chart.base.obj.ScatterObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public abstract class LegendAbs {
    /**
     * Legend
     * @param canvas
     * @param paint
     * @param leftInit
     * @param bottom
     * @param barObj
     * @param datas
     * @param colors
     */
    public void drawLegend(Canvas canvas, Paint paint, float leftInit, float bottom, BarObj barObj, float[][] datas, int[] colors) {};

    /**
     * Simple Legend
     * @param canvas
     * @param paint
     * @param leftInit
     * @param bottom
     * @param barObj
     * @param data
     * @param color
     */
    public void drawLegend(Canvas canvas, Paint paint, float leftInit, float bottom, BarObj barObj, float[] data, int color) {};

    /**
     *
     * @param canvas
     * @param paint
     * @param leftInit
     * @param bottom
     * @param bubbleObj
     * @param color
     */
    public void drawLegend(Canvas canvas, Paint paint, float leftInit, float bottom, BubbleObj bubbleObj, int color) {};

    /**
     *
     * @param canvas
     * @param paint
     * @param leftInit
     * @param bottom
     * @param bubbleObj
     * @param colors
     */
    public void drawLegend(Canvas canvas, Paint paint, float leftInit, float bottom, BubbleObj bubbleObj, int[] colors) {};

    /**
     *
     * @param canvas
     * @param paint
     * @param leftInit
     * @param bottom
     * @param scatterObj
     * @param color
     */
    public void drawLegend(Canvas canvas, Paint paint, float leftInit, float bottom, ScatterObj scatterObj, int color) {};

    /**
     *
     * @param canvas
     * @param paint
     * @param leftInit
     * @param bottom
     * @param scatterObj
     * @param colors
     */
    public void drawLegend(Canvas canvas, Paint paint, float leftInit, float bottom, ScatterObj scatterObj, int[] colors) {};

}
