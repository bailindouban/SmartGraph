package originator.ailin.com.smartgraph.grid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 2/15/2015.
 */
public class Grid {
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
    public Grid(Canvas mCanvas, Paint mPaint, float mLeft, float mBottom) {
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
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(2);
    }

    /**
     *
     * @param maxWidth
     * @param maxHeight
     * @param unit
     */
    public void drawGridY(float maxWidth, float maxHeight, int unit) {
        int num = (int) (maxHeight / unit + 1);

        for(int i = 1; i < num; i++) {
            mCanvas.drawLine(mLeft, mBottom - unit * i, maxWidth + mLeft, mBottom - unit * i, mPaint);    // X lines
        }
    }
}
