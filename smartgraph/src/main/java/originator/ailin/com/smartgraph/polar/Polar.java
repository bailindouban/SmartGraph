package originator.ailin.com.smartgraph.polar;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import originator.ailin.com.smartgraph.R;

/**
 * Created by Kim_Bai on 3/2/2015.
 */
public class Polar {
    private Canvas mCanvas;
    private Paint mPaint;
    private int mLeft, mBottom;
    private int mPolarTextSizeX, mPolarTextSizeY;
    private float mPolarMarginX, mPolarMarginY;
    private Resources mResources;

    /**
     *
     * @param mResources
     * @param mCanvas
     * @param mPaint
     * @param mLeft
     * @param mBottom
     */
    public Polar(Resources mResources, Canvas mCanvas, Paint mPaint, int mLeft, int mBottom) {
        this.mResources = mResources;
        this.mCanvas = mCanvas;
        this.mPaint = mPaint;
        this.mLeft = mLeft;
        this.mBottom = mBottom;

        init();
    }

    /**
     * Init Params
     */
    private void init() {
        mPaint.setColor(Color.BLUE);
        mPolarTextSizeX = 34;
        mPolarTextSizeY = 34;
        mPolarMarginX = mResources.getDimension(R.dimen.polar_margin_x);
        mPolarMarginY = mResources.getDimension(R.dimen.polar_margin_y);
    }

    /**
     *
     * @param num
     * @param width
     * @param interval
     */
    public void drawPolarX(int num, int width, int interval, String[] polarsXText) {
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextSize(mPolarTextSizeX);

        for(int i = 0; i < num; i++) {
            Rect bounds = new Rect();
            mPaint.getTextBounds(polarsXText[i], 0, polarsXText[i].length(), bounds);
            mCanvas.drawText(polarsXText[i], mLeft + width / 2 + (width + interval) * i - bounds.width() / 2, mBottom + bounds.height() + mPolarMarginX, mPaint);    // X Polars
        }
    }

    /**
     *
     * @param maxWidth
     * @param unitX
     */
    public void drawPolarBubbleX(int maxWidth, int unitX) {
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(mPolarTextSizeX);
        int num = (int) (maxWidth / unitX + 1);

        // Draw PolarX Text
        for(int i = 0; i < num; i++) {
            String polarXText = String.valueOf(unitX * i);
            Rect bounds = new Rect();
            mPaint.getTextBounds(polarXText, 0, polarXText.length(), bounds);
            mCanvas.drawText(polarXText, mLeft + unitX * i, mBottom + bounds.height() + mPolarMarginX, mPaint);    // X Polars
        }

        // Draw Tick Mark
        for(int i = 1; i < num; i++) {
            mPaint.setColor(Color.BLACK);
            mCanvas.drawLine(mLeft + unitX * i, mBottom - mPolarMarginX, mLeft + unitX * i, mBottom + mPolarMarginX, mPaint);
        }
    }

    /**
     *
     * @param maxHeight
     * @param unitY
     */
    public void drawPolarY(int maxHeight, int unitY) {
        mPaint.setTextAlign(Paint.Align.RIGHT);
        mPaint.setTextSize(mPolarTextSizeY);
        int num = (int) (maxHeight / unitY + 1);

        for(int i = 0; i < num; i++) {
            String polarYText = String.valueOf(unitY * i);
            Rect bounds = new Rect();
            mPaint.getTextBounds(polarYText, 0, polarYText.length(), bounds);
            mCanvas.drawText(polarYText, mLeft - mPolarMarginY, mBottom - unitY * i + bounds.height() / 2, mPaint);    // Y Polars
        }
    }

    // Setters

    public void setmPolarTextSizeX(int mPolarTextSizeX) {
        this.mPolarTextSizeX = mPolarTextSizeX;
    }

    public void setmPolarTextSizeY(int mPolarTextSizeY) {
        this.mPolarTextSizeY = mPolarTextSizeY;
    }

    public void setmPolarMarginX(float mPolarMarginX) {
        this.mPolarMarginX = mPolarMarginX;
    }

    public void setmPolarMarginY(float mPolarMarginY) {
        this.mPolarMarginY = mPolarMarginY;
    }
}