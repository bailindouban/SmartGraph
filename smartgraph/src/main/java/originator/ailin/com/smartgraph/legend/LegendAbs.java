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
    public float leftInit;
    public float bottom;
    public BarObj barObj;
    public BubbleObj bubbleObj;
    public ScatterObj scatterObj;

    public float[] data;
    public int color;
    public float[][] datas;
    public int[] colors;

    /**
     *
     * @param canvas
     * @param paint
     */
    public void drawLegend(Canvas canvas, Paint paint) {};

    // Setters
    public void setLeftInit(float leftInit) {
        this.leftInit = leftInit;
    }

    public void setBottom(float bottom) {
        this.bottom = bottom;
    }

    public void setBarObj(BarObj barObj) {
        this.barObj = barObj;
    }

    public void setBubbleObj(BubbleObj bubbleObj) {
        this.bubbleObj = bubbleObj;
    }

    public void setScatterObj(ScatterObj scatterObj) {
        this.scatterObj = scatterObj;
    }

    public void setData(float[] data) {
        this.data = data;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setDatas(float[][] datas) {
        this.datas = datas;
    }

    public void setColors(int[] colors) {
        this.colors = colors;
    }
}
