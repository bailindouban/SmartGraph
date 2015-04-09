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
    protected int unitX, unitY;
    protected String[] polarsTextX;
    protected int polarTextColorX, polarTextColorY;
    protected int polarTextSizeX, polarTextSizeY;
    protected float polarMarginX, polarMarginY;

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
        polarTextSizeX = 34;
        polarTextSizeY = 34;
        polarMarginX = resources.getDimension(R.dimen.polar_margin_x);
        polarMarginY = resources.getDimension(R.dimen.polar_margin_y);
    }
}