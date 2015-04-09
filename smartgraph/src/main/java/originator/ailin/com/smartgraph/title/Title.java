package originator.ailin.com.smartgraph.title;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 3/2/2015.
 */
public class Title extends TitleAbs {
    /**
     * Constructor
     * @param left
     * @param bottom
     * @param titleText
     * @param titleSize
     * @param titleColor
     * @param maxWidth
     * @param maxHeight
     */
    public Title(float left, float bottom, String titleText, int titleSize, int titleColor, float maxWidth, float maxHeight) {
        this.left = left;
        this.bottom = bottom;
        this.titleText = titleText;
        this.titleSize = titleSize;
        this.titleColor = titleColor;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    /**
     *
     * @param canvas
     * @param paint
     */
    @Override
    public void drawTitle(Canvas canvas, Paint paint) {
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1);
        paint.setTextSize(titleSize);
        paint.setColor(titleColor);
        canvas.drawText(titleText, left + maxWidth / 2, bottom - maxHeight, paint);
    }
}
