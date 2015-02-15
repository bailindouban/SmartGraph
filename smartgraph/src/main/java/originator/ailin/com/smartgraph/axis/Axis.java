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
    private int mLeftInit, mBottom;

    public Axis(Canvas mCanvas, Paint mPaint, int mLeftInit, int mBottom) {
        this.mCanvas = mCanvas;
        this.mPaint = mPaint;
        this.mLeftInit = mLeftInit;
        this.mBottom = mBottom;

        init();
    }

    private void init() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(2);
    }

    public void drawAxisX(int maxWidth) {
        mCanvas.drawLine(mLeftInit, mBottom, maxWidth + mLeftInit, mBottom, mPaint);
    }

    public void drawAxisY(int maxHeight) {
        mCanvas.drawLine(mLeftInit, mBottom, mLeftInit, mBottom - maxHeight, mPaint);
    }

}
