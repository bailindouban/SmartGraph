package originator.ailin.com.smartgraph.title;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 3/2/2015.
 */
public class Title {
    private Canvas mCanvas;
    private Paint mPaint;
    private float mLeft, mBottom;

    /**
     *
     * @param mCanvas
     * @param mPaint
     * @param mLeft
     * @param mBottom
     */
    public Title(Canvas mCanvas, Paint mPaint, float mLeft, float mBottom) {
        this.mCanvas = mCanvas;
        this.mPaint = mPaint;
        this.mLeft = mLeft;
        this.mBottom = mBottom;
    }

    /**
     *
     * @param titleText
     * @param titleSize
     * @param titleColor
     * @param maxWidth
     * @param maxHeight
     */
    public void drawTitle(String titleText, int titleSize, int titleColor, float maxWidth, float maxHeight) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(1);
        mPaint.setTextSize(titleSize);
        mPaint.setColor(titleColor);
        mCanvas.drawText(titleText, mLeft + (maxWidth - mPaint.measureText(titleText)) / 2, mBottom - maxHeight, mPaint);
    }
}
