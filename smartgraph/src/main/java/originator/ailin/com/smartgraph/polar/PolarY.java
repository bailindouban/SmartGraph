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
     * @param unitY
     * @param polarsTextColorY
     */
    public PolarY(float left, float bottom, float maxHeight, int unitY, int polarsTextColorY) {
        this.left = left;
        this.bottom = bottom;
        this.maxHeight = maxHeight;
        this.unitY = unitY;
        this.polarTextColorY = polarsTextColorY;
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
        paint.setTextSize(polarTextSizeY);
        paint.setColor(polarTextColorY);
        int num = (int) (maxHeight / unitY + 1);

        for (int i = 0; i < num; i++) {
            String polarYText = String.valueOf(unitY * i);
            Rect bounds = new Rect();
            paint.getTextBounds(polarYText, 0, polarYText.length(), bounds);
            canvas.drawText(polarYText, left - polarMarginY, bottom - unitY * i + bounds.height() / 2, paint);    // Y Polars
        }
    }
}