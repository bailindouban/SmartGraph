package originator.ailin.com.smartgraph.polar;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Kim_Bai on 3/2/2015.
 */
public class PolarY extends PolarAbs {
    /**
     *
     * @param left
     * @param bottom
     * @param maxHeight
     * @param interval
     * @param polarsTextColor
     */
    public PolarY(float left, float bottom, float maxHeight, float interval, int polarsTextColor) {
        this.left = left;
        this.bottom = bottom;
        this.maxHeight = maxHeight;
        this.interval = interval;
        this.polarTextColor = polarsTextColor;
    }

    /**
     *
     * @param resources
     * @param canvas
     * @param paint
     */
    @Override
    public void drawPolar(Resources resources, Canvas canvas, Paint paint) {
        init(resources, paint);
        
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setTextSize(polarTextSize);
        paint.setColor(polarTextColor);
        int num = (int) (maxHeight / interval + 1);

        for (int i = 0; i < num; i++) {
            String polarYText = String.valueOf((int) interval * i);
            Rect bounds = new Rect();
            paint.getTextBounds(polarYText, 0, polarYText.length(), bounds);
            canvas.drawText(polarYText, left - polarMargin, bottom - interval * i + bounds.height() / 2, paint);    // Y Polars
        }
    }
}