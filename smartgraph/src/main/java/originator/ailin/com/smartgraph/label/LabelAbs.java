package originator.ailin.com.smartgraph.label;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

import originator.ailin.com.smartgraph.R;

/**
 * Created by Kim_Bai on 3/26/2015.
 */
public abstract class LabelAbs {
    protected float left, bottom;
    protected int num;
    protected int labelTextSize;
    protected  String[] labelsText;
    protected int labelTextColor;
    protected int[] iconsColor;
    protected float maxWidth, maxHeight;
    protected float labelMarginL, labelMarginT, labelMarginR, labelMarginB;
    protected float labelIconWidth, labelIconHeight;
    protected float labelIconMargin;

    /**
     * Init Params
     * @param resources
     */
    protected void init(Resources resources) {
        labelTextSize = 34;
        labelMarginL = resources.getDimension(R.dimen.label_margin_left);
        labelMarginT = resources.getDimension(R.dimen.label_margin_top);
        labelMarginR = resources.getDimension(R.dimen.label_margin_right);
        labelMarginB = resources.getDimension(R.dimen.label_margin_bottom);
        labelIconMargin = resources.getDimension(R.dimen.label_icon_margin);

        labelIconWidth = 40;
        labelIconHeight = 40;
    }

    /**
     *
     * @param resources
     * @param canvas
     * @param paint
     */
    public abstract void drawLabel(Resources resources, Canvas canvas, Paint paint);
}
