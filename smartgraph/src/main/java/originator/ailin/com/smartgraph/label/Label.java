package originator.ailin.com.smartgraph.label;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import originator.ailin.com.smartgraph.R;

/**
 * Created by Kim_Bai on 3/26/2015.
 */
public class Label extends LabelAbs {
    /**
     *
     * @param left
     * @param bottom
     * @param num
     * @param labelsText
     * @param labelTextColor
     * @param iconsColor
     * @param maxWidth
     * @param maxHeight
     */
    public Label(float left, float bottom, int num, String[] labelsText, int labelTextColor, int[] iconsColor, float maxWidth, float maxHeight) {
        this.left = left;
        this.bottom = bottom;
        this.num = num;
        this.labelsText = labelsText;
        this.labelTextColor = labelTextColor;
        this.iconsColor = iconsColor;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    /**
     * 
     * @param resources
     * @param canvas
     * @param paint
     */
    public void drawLabel(Resources resources, Canvas canvas, Paint paint) {
        init(resources);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(labelTextSize);
        Rect bounds = new Rect();
        paint.getTextBounds(labelsText[0], 0, labelsText[0].length(), bounds);

        float itemHeightMax = labelIconHeight > bounds.height() ? labelIconHeight : bounds.height();
        itemHeightMax += resources.getDimension(R.dimen.label_icon_margin);
        for(int i = 0; i < num; i++) {
            // Draw Label Icon
            float LeftInit = left + maxWidth + labelMarginL;
            float topInit = bottom - maxHeight / 2 - itemHeightMax * num / 2 + itemHeightMax * i;
            paint.setColor(iconsColor[i]);
            canvas.drawRect(LeftInit, topInit, LeftInit + labelIconWidth, topInit + labelIconHeight, paint);

            // Draw Label Text
            paint.setColor(labelTextColor);
            canvas.drawText(labelsText[i], LeftInit + labelIconWidth + labelIconMargin, topInit + labelIconHeight / 2 + bounds.height() / 2, paint);    // Labels
        }
    }

}
