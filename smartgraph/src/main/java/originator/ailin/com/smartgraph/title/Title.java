package originator.ailin.com.smartgraph.title;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 3/2/2015.
 */
public class Title {
    private Canvas mCanvas;
    private Paint mPaint;
    private int mLeft, mBottom;

    public Title(Canvas mCanvas, Paint mPaint, int mLeft, int mBottom) {
        this.mCanvas = mCanvas;
        this.mPaint = mPaint;
        this.mLeft = mLeft;
        this.mBottom = mBottom;
    }

    public void drawTitle(String titleText, int titleSize, int titleColor, int maxWidth, int maxHeight) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(1);
        mPaint.setTextSize(titleSize);
        mPaint.setColor(titleColor);
        mCanvas.drawText(titleText, mLeft + (maxWidth - titleText.length() * titleSize / 2) / 2, mBottom - maxHeight, mPaint);
    }
}
