package originator.ailin.com.smartgraph.polar;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import originator.ailin.com.smartgraph.R;

/**
 * Created by Kim_Bai on 3/2/2015.
 */
public abstract class PolarAbs {
    protected float left, bottom;
    protected int num;
    protected float width;
    protected float maxWidth, maxHeight;
    protected float interval;
    protected String[] polarsText;
    protected int polarTextColor;
    protected int polarTextSize;
    protected float polarMargin;

    /**
     *
     * @param canvas
     * @param paint
     */
    public abstract void drawPolar(Resources resources, Canvas canvas, Paint paint);

    /**
     * Init Params
     */
    protected void init(Resources resources, Paint paint) {
        paint.setColor(Color.BLUE);
        polarTextSize = 34;
        polarMargin = resources.getDimension(R.dimen.polar_margin_x);
    }
}