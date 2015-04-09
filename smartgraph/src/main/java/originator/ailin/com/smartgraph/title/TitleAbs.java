package originator.ailin.com.smartgraph.title;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 3/2/2015.
 */
public abstract class TitleAbs {
    protected float left, bottom;
    protected String titleText;
    protected int titleSize;
    protected int titleColor;
    protected float maxWidth, maxHeight;

    /**
     *
     * @param canvas
     * @param paint
     */
    public abstract void drawTitle(Canvas canvas, Paint paint);
}
