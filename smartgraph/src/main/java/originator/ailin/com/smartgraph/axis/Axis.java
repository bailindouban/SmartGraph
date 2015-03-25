package originator.ailin.com.smartgraph.axis;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 2/15/2015.
 */
public class Axis {
    private Canvas mCanvas;
    private Paint mPaint;
    private int mLeft, mBottom;

    public Axis(Canvas mCanvas, Paint mPaint, int mLeft, int mBottom) {
        this.mCanvas = mCanvas;
        this.mPaint = mPaint;
        this.mLeft = mLeft - 1;
        this.mBottom = mBottom + 1;

        init();
    }

    private void init() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(2);
    }

    public void drawAxisX(int maxWidth) {
        mCanvas.drawLine(mLeft, mBottom, maxWidth + mLeft + 1, mBottom, mPaint);
    }

    public void drawAxisY(int maxHeight) {
        mCanvas.drawLine(mLeft, mBottom, mLeft, mBottom - maxHeight, mPaint);
    }

}