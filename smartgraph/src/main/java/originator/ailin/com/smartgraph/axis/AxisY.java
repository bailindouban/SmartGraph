package originator.ailin.com.smartgraph.axis;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 2/15/2015.
 */
public class AxisY extends AxisAbs {

    /**
     * @param left
     * @param bottom
     * @param maxWidth
     * @param maxHeight
     */
    public AxisY(float left, float bottom, float maxWidth, float maxHeight) {
        super(left, bottom, maxWidth, maxHeight);
    }

    /**
     *
     * @param canvas
     * @param paint
     */
    @Override
    public void drawAxis(Canvas canvas, Paint paint) {
        init(paint);
        canvas.drawLine(left, bottom, left, bottom - maxHeight, paint);
    }

}
