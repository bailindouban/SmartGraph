package originator.ailin.com.smartgraph.legend_value;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import originator.ailin.com.smartgraph.R;
import originator.ailin.com.smartgraph.obj.PieObj;

/**
 * Created by Kim_Bai on 2/15/2015.
 */
public class LegendValue {
    private Canvas mCanvas;
    private Paint mPaint;
    private Resources mResources;
    private float mPieLegendValueMargin, mPieRoseLegendValueMargin;

    /**
     * Constructor
     * @param mResources
     * @param mCanvas
     * @param mPaint
     */
    public LegendValue(Resources mResources, Canvas mCanvas, Paint mPaint) {
        this.mResources = mResources;
        this.mCanvas = mCanvas;
        this.mPaint = mPaint;

        init();
    }

    /**
     * Init Params
     */
    private void init() {
        mPaint.setTextSize(34);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Paint.Style.FILL);
        mPieLegendValueMargin = mResources.getDimension(R.dimen.pie_legend_value_margin);
        mPieRoseLegendValueMargin = mResources.getDimension(R.dimen.pie_rose_legend_value_margin);
    }

    /**
     *
     * @param maxWidth
     */
    public void drawValueBar(float maxWidth) {

    }

    /**
     * Draw Legend Value for Pie
     * @param pieObj
     * @param radius
     * @param data
     */
    public void drawValuePie(PieObj pieObj, float radius, float[] data) {
        float startAngleInit = pieObj.startAngle;

        float total = 0;
        for(float d : data) {
            total += d;
        }

        for(int i = 0; i < data.length; i++) {
            float swipeAngle = data[i] * 360 / total;
            mPaint.setTextAlign(Paint.Align.CENTER);
            Rect bounds = new Rect();
            String legendValueText = String.valueOf(data[i]);
            mPaint.getTextBounds(legendValueText, 0, legendValueText.length(), bounds);
            double radian = Math.PI * (2 * startAngleInit + swipeAngle) / 360;
            mCanvas.drawText(String.valueOf(data[i]), pieObj.center.x + (radius + pieObj.bias[i] - mPieLegendValueMargin) * (float) Math.cos(radian), pieObj.center.y + (radius + pieObj.bias[i] - mPieLegendValueMargin) * (float) Math.sin(radian) + bounds.height() / 2, mPaint);

            // swipeAngle++
            startAngleInit += swipeAngle;
        }
    }

    /**
     * Draw Legend Value for PieRose
     * @param pieObj
     * @param radiusDealArray
     * @param data
     */
    public void drawValuePieRose(PieObj pieObj, float[] radiusDealArray, float[] data) {
        mPaint.setTextSize(28);
        float startAngleInit = pieObj.startAngle;

        for(int i = 0; i < data.length; i++) {
            float swipeAngle = 360 / data.length;
            mPaint.setTextAlign(Paint.Align.CENTER);
            Rect bounds = new Rect();
            String legendValueText = String.valueOf(data[i]);
            mPaint.getTextBounds(legendValueText, 0, legendValueText.length(), bounds);
            double radian = Math.PI * (2 * startAngleInit + swipeAngle) / 360;
            mCanvas.drawText(String.valueOf(data[i]), pieObj.center.x + (radiusDealArray[i] - mPieRoseLegendValueMargin) * (float) Math.cos(radian), pieObj.center.y + (radiusDealArray[i] - mPieRoseLegendValueMargin) * (float) Math.sin(radian) + bounds.height() / 2, mPaint);

            // swipeAngle++
            startAngleInit += swipeAngle;
        }
    }

    // Setters
    public void setmPieLegendValueMargin(float mPieLegendValueMargin) {
        this.mPieLegendValueMargin = mPieLegendValueMargin;
    }
}
