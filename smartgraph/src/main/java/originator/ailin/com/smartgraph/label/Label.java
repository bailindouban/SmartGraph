package originator.ailin.com.smartgraph.label;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import originator.ailin.com.smartgraph.R;

/**
 * Created by Kim_Bai on 3/26/2015.
 */
public class Label {
    private Canvas mCanvas;
    private Paint mPaint;
    private float mLeft, mBottom;
    private int mLabelTextSize;
    private float mLabelMarginL, mLabelMarginT, mLabelMarginR, mLabelMarginB;
    private float mLabelIconWidth, mLabelIconHeight;
    private float mLabelIconMargin;
    private Resources mResources;

    /**
     *
     * @param mCanvas
     * @param mPaint
     * @param mLeft
     * @param mBottom
     */
    public Label(Resources mResources, Canvas mCanvas, Paint mPaint, float mLeft, float mBottom) {
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
        mLabelTextSize = 34;
        mLabelMarginL = mResources.getDimension(R.dimen.label_margin_left);
        mLabelMarginT = mResources.getDimension(R.dimen.label_margin_top);
        mLabelMarginR = mResources.getDimension(R.dimen.label_margin_right);
        mLabelMarginB = mResources.getDimension(R.dimen.label_margin_bottom);
        mLabelIconMargin = mResources.getDimension(R.dimen.label_icon_margin);

        mLabelIconWidth = 40;
        mLabelIconHeight = 40;
    }

    /**
     *
     * @param labelsText
     * @param labelsTextColor
     * @param iconsColor
     * @param maxWidth
     * @param maxHeight
     */
    public void drawLabel(int num, String[] labelsText, int labelsTextColor, int[] iconsColor, float maxWidth, float maxHeight) {
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextSize(mLabelTextSize);
        Rect bounds = new Rect();
        mPaint.getTextBounds(labelsText[0], 0, labelsText[0].length(), bounds);

        float itemHeightMax = mLabelIconHeight > bounds.height() ? mLabelIconHeight : bounds.height();
        itemHeightMax += mResources.getDimension(R.dimen.label_icon_margin);
        for(int i = 0; i < num; i++) {
            // Draw Label Icon
            float LeftInit = mLeft + maxWidth + mLabelMarginL;
            float topInit = mBottom - maxHeight / 2 - itemHeightMax * labelsText.length / 2 + itemHeightMax * i;
            mPaint.setColor(iconsColor[i]);
            mCanvas.drawRect(LeftInit, topInit, LeftInit + mLabelIconWidth, topInit + mLabelIconHeight, mPaint);

            // Draw Label Text
            mPaint.setColor(labelsTextColor);
            mCanvas.drawText(labelsText[i], LeftInit + mLabelIconWidth + mLabelIconMargin, topInit + mLabelIconHeight / 2 + bounds.height() / 2, mPaint);    // Labels
        }
    }

    // Setters
    public void setmLabelTextSize(int mLabelTextSize) {
        this.mLabelTextSize = mLabelTextSize;
    }

    public void setmLabelMarginL(float mLabelMarginL) {
        this.mLabelMarginL = mLabelMarginL;
    }

    public void setmLabelMarginT(float mLabelMarginT) {
        this.mLabelMarginT = mLabelMarginT;
    }

    public void setmLabelMarginR(float mLabelMarginR) {
        this.mLabelMarginR = mLabelMarginR;
    }

    public void setmLabelMarginB(float mLabelMarginB) {
        this.mLabelMarginB = mLabelMarginB;
    }
}
