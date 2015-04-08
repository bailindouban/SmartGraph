package originator.ailin.com.smartgraph.axis;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 2/15/2015.
 */
public class Axis extends AxisAbs {

    /**
     *
     * @param left
     * @param bottom
     * @param maxWidth
     * @param maxHeight
     */
    public Axis(float left, float bottom, float maxWidth, float maxHeight) {
        this.left = left - 1;
        this.bottom = bottom + 1;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    /**
     * Init Params
     */
    private void init(Paint paint) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
    }

    /**
     *
     * @param canvas
     * @param paint
     */
    public void drawAxisX(Canvas canvas, Paint paint) {
        init(paint);
        canvas.drawLine(left, bottom, maxWidth + left + 1, bottom, paint);
    }

    /**
     *
     * @param canvas
     * @param paint
     */
    public void drawAxisY(Canvas canvas, Paint paint) {
        init(paint);
        canvas.drawLine(left, bottom, left, bottom - maxHeight, paint);
    }

}
