package originator.ailin.com.smartgraph.axis;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 2/15/2015.
 */
public abstract class AxisAbs {
    protected float left, bottom, maxWidth, maxHeight;

    /**
     *
     * @param canvas
     * @param paint
     */
    abstract public void drawAxisX(Canvas canvas, Paint paint);

    /**
     *
     * @param canvas
     * @param paint
     */
    abstract public void drawAxisY(Canvas canvas, Paint paint);

}
