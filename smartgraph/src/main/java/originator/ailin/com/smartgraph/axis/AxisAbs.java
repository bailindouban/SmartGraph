package originator.ailin.com.smartgraph.axis;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 2/15/2015.
 */
public abstract class AxisAbs {
    protected float left, bottom, maxWidth, maxHeight;

    /**
     *
     * @param left
     * @param bottom
     * @param maxWidth
     * @param maxHeight
     */
    public AxisAbs(float left, float bottom, float maxWidth, float maxHeight) {
        this.left = left - 1;
        this.bottom = bottom + 1;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    /**
     * Init Params
     */
    protected void init(Paint paint) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
    }

    /**
     *
     * @param canvas
     * @param paint
     */
    abstract public void drawAxis(Canvas canvas, Paint paint);

}
