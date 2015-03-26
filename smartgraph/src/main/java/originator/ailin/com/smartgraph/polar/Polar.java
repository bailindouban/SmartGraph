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
    private int mPolarsTextSizeX, mPolarsTextSizeY;
    private float mPolarsMarginX, mPolarsMarginY;
    private Resources mResources;

    /**
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
        mPolarsTextSizeX = 34;
        mPolarsTextSizeY = 34;
        mPolarsMarginX = mResources.getDimension(R.dimen.polar_margin_x);
        mPolarsMarginY = mResources.getDimension(R.dimen.polar_margin_y);
    }

    /**
     * @param num
     * @param width
     * @param interval
     * @param polarsTextX
     */
    public void drawPolarX(int num, int width, int interval, String[] polarsTextX, int polarTextColorX) {
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextSize(mPolarsTextSizeX);
        mPaint.setColor(polarTextColorX);

        for (int i = 0; i < num; i++) {
            Rect bounds = new Rect();
            mPaint.getTextBounds(polarsTextX[i], 0, polarsTextX[i].length(), bounds);
            mCanvas.drawText(polarsTextX[i], mLeft + width / 2 + (width + interval) * i - bounds.width() / 2, mBottom + bounds.height() + mPolarsMarginX, mPaint);    // X Polars
        }
    }

    /**
     * @param maxWidth
     * @param unitX
     */
    public void drawPolarBubbleX(int maxWidth, int unitX, int polarsTextColorX) {
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(mPolarsTextSizeX);
        mPaint.setColor(polarsTextColorX);
        int num = (int) (maxWidth / unitX + 1);

        // Draw PolarX Text
        for (int i = 0; i < num; i++) {
            String polarXText = String.valueOf(unitX * i);
            Rect bounds = new Rect();
            mPaint.getTextBounds(polarXText, 0, polarXText.length(), bounds);
            mCanvas.drawText(polarXText, mLeft + unitX * i, mBottom + bounds.height() + mPolarsMarginX, mPaint);    // X Polars
        }

        // Draw Tick Mark
        for (int i = 1; i < num; i++) {
            mPaint.setColor(Color.BLACK);
            mCanvas.drawLine(mLeft + unitX * i, mBottom - mPolarsMarginX, mLeft + unitX * i, mBottom + mPolarsMarginX, mPaint);
        }
    }

    /**
     * @param maxHeight
     * @param unitY
     */
    public void drawPolarY(int maxHeight, int unitY, int polarsTextColorY) {
        mPaint.setTextAlign(Paint.Align.RIGHT);
        mPaint.setTextSize(mPolarsTextSizeY);
        mPaint.setColor(polarsTextColorY);
        int num = (int) (maxHeight / unitY + 1);

        for (int i = 0; i < num; i++) {
            String polarYText = String.valueOf(unitY * i);
            Rect bounds = new Rect();
            mPaint.getTextBounds(polarYText, 0, polarYText.length(), bounds);
            mCanvas.drawText(polarYText, mLeft - mPolarsMarginY, mBottom - unitY * i + bounds.height() / 2, mPaint);    // Y Polars
        }
    }

    // Setters

    public void setmPolarsTextSizeX(int mPolarsTextSizeX) {
        this.mPolarsTextSizeX = mPolarsTextSizeX;
    }

    public void setmPolarsTextSizeY(int mPolarsTextSizeY) {
        this.mPolarsTextSizeY = mPolarsTextSizeY;
    }

    public void setmPolarsMarginX(float mPolarsMarginX) {
        this.mPolarsMarginX = mPolarsMarginX;
    }

    public void setmPolarsMarginY(float mPolarsMarginY) {
        this.mPolarsMarginY = mPolarsMarginY;
    }
}