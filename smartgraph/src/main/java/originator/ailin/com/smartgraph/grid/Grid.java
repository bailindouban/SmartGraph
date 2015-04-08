package originator.ailin.com.smartgraph.grid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 2/15/2015.
 */
public class Grid extends GridAbs {
    /**
     *
     * @param left
     * @param bottom
     * @param maxWidth
     * @param maxHeight
     * @param unitY
     */
    public Grid(float left, float bottom, float maxWidth, float maxHeight, int unitY) {
        this.left = left;
        this.bottom = bottom;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.unitY = unitY;
    }

    /**
     * Init Params
     */
    private void init(Paint paint) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
    }

    @Override
    public void drawGridY(Canvas canvas, Paint paint) {
        init(paint);

        int num = (int) (maxHeight / unitY + 1);
        for(int i = 1; i < num; i++) {
            canvas.drawLine(left, bottom - unitY * i, maxWidth + left, bottom - unitY * i, paint);    // X lines
        }
    }

}
