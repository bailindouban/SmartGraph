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
    private int mLeft, mBottom;

    public Grid(Canvas mCanvas, Paint mPaint, int mLeft, int mBottom) {
        this.mCanvas = mCanvas;
        this.mPaint = mPaint;
        this.mLeft = mLeft;
        this.mBottom = mBottom;

        init();
    }

    private void init() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(2);
    }

    public void drawGridY(int maxWidth, int maxHeight, int unit) {
        int num = (int) (maxHeight / unit + 1);

        for(int i = 1; i < num; i++) {
            mCanvas.drawLine(mLeft, mBottom - unit * i, maxWidth + mLeft, mBottom - unit * i, mPaint);    // X lines
        }
    }
}
