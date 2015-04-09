package originator.ailin.com.smartgraph.polar;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Kim_Bai on 3/2/2015.
 */
public class PolarX extends PolarAbs {
    /**
     *
     * @param left
     * @param bottom
     * @param num
     * @param width
     * @param interval
     * @param polarsText
     * @param polarTextColor
     */
    public PolarX(float left, float bottom, int num, float width, float interval, String[] polarsText, int polarTextColor) {
        this.left = left;
        this.bottom = bottom;
        this.num = num;
        this.width = width;
        this.interval = interval;
        this.polarsText = polarsText;
        this.polarTextColor = polarTextColor;
    }

    /**
     *
     * @param canvas
     * @param paint
     */
    public void drawPolar(Resources resources, Canvas canvas, Paint paint) {
        init(resources, paint);

        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(polarTextSize);
        paint.setColor(polarTextColor);

        for (int i = 0; i < num; i++) {
            Rect bounds = new Rect();
            paint.getTextBounds(polarsText[i], 0, polarsText[i].length(), bounds);
            canvas.drawText(polarsText[i], left + width / 2 + (width + interval) * i - bounds.width() / 2, bottom + bounds.height() + polarMargin, paint);    // X Polars
        }
    }

}