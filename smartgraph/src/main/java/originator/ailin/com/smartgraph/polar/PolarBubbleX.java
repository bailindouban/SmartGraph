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
     * @param interval
     * @param polarTextColor
     */
    public PolarBubbleX(float left, float bottom, float maxWidth, float interval, int polarTextColor) {
        this.left = left;
        this.bottom = bottom;
        this.maxWidth = maxWidth;
        this.interval = interval;
        this.polarTextColor = polarTextColor;
    }


    public void drawPolar(Resources resources, Canvas canvas, Paint paint) {
        init(resources, paint);

        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(polarTextSize);
        paint.setColor(polarTextColor);
        int num = (int) (maxWidth / interval + 1);

        // Draw PolarX Text
        for (int i = 0; i < num; i++) {
            String polarXText = String.valueOf((int) interval * i);
            Rect bounds = new Rect();
            paint.getTextBounds(polarXText, 0, polarXText.length(), bounds);
            canvas.drawText(polarXText, left + interval * i, bottom + bounds.height() + polarMargin, paint);    // X Polars
        }

        // Draw Tick Mark
        for (int i = 1; i < num; i++) {
            paint.setColor(Color.BLACK);
            canvas.drawLine(left + interval * i, bottom - polarMargin, left + interval * i, bottom + polarMargin, paint);
        }
    }
}