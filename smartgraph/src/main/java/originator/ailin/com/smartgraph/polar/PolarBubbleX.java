package originator.ailin.com.smartgraph.polar;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Kim_Bai on 3/2/2015.
 */
public class PolarBubbleX extends PolarAbs {

    /**
     *
     * @param left
     * @param bottom
     * @param maxWidth
     * @param unitX
     * @param polarTextColorX
     */
    public PolarBubbleX(float left, float bottom, float maxWidth, int unitX, int polarTextColorX) {
        this.left = left;
        this.bottom = bottom;
        this.maxWidth = maxWidth;
        this.unitX = unitX;
        this.polarTextColorX = polarTextColorX;
    }


    public void drawPolar(Resources mResources, Canvas mCanvas, Paint mPaint) {
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(polarTextSizeX);
        mPaint.setColor(polarTextColorX);
        int num = (int) (maxWidth / unitX + 1);

        // Draw PolarX Text
        for (int i = 0; i < num; i++) {
            String polarXText = String.valueOf(unitX * i);
            Rect bounds = new Rect();
            mPaint.getTextBounds(polarXText, 0, polarXText.length(), bounds);
            mCanvas.drawText(polarXText, left + unitX * i, bottom + bounds.height() + polarMarginX, mPaint);    // X Polars
        }

        // Draw Tick Mark
        for (int i = 1; i < num; i++) {
            mPaint.setColor(Color.BLACK);
            mCanvas.drawLine(left + unitX * i, bottom - polarMarginX, left + unitX * i, bottom + polarMarginX, mPaint);
        }
    }
}