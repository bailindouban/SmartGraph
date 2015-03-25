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
    public void drawPolarX(int num, int width, int interval, String[] polarX) {
        mPaint.setTextSize(mPolarTextSizeX);

        for(int i = 0; i < num; i++) {
            Rect bounds = new Rect();
            mPaint.getTextBounds(polarX[i], 0, polarX[i].length(), bounds);
            mCanvas.drawText(polarX[i], mLeft + width / 2 + (width + interval) * i - bounds.width() / 2, mBottom + bounds.height() + mPolarMarginX, mPaint);    // X Polars
        }
    }

    /**
     *
     * @param maxWidth
     * @param unitX
     */
    public void drawPolarBubbleX(int maxWidth, int unitX) {
        mPaint.setTextSize(mPolarTextSizeX);
        int num = (int) (maxWidth / unitX + 1);

        for(int i = 0; i < num; i++) {
            String polarX = String.valueOf(unitX * i);
            Rect bounds = new Rect();
            mPaint.getTextBounds(polarX, 0, polarX.length(), bounds);
            mCanvas.drawText(polarX, mLeft + unitX * i - bounds.width() / 2, mBottom + bounds.height() + mPolarMarginX, mPaint);    // X Polars
        }

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
        mPaint.setTextSize(mPolarTextSizeY);
        int num = (int) (maxHeight / unitY + 1);

        for(int i = 0; i < num; i++) {
            String polarY = String.valueOf(unitY * i);
            Rect bounds = new Rect();
            mPaint.getTextBounds(polarY, 0, polarY.length(), bounds);
            mCanvas.drawText(polarY, mLeft - bounds.width() - mPolarMarginY, mBottom - unitY * i + bounds.height() / 2, mPaint);    // Y Polars
        }
    }

    // Setters
    public void setmPolarTextSizeY(int mPolarTextSizeY) {
        this.mPolarTextSizeY = mPolarTextSizeY;
    }

    public void setmPolarTextSizeX(int mPolarTextSizeX) {
        this.mPolarTextSizeX = mPolarTextSizeX;
    }

    public void setmPolarMarginX(int mPolarMarginX) {
        this.mPolarMarginX = mPolarMarginX;
    }

    public void setmPolarMarginY(int mPolarMarginY) {
        this.mPolarMarginY = mPolarMarginY;
    }
}