package originator.ailin.com.smartgraph.grid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 2/15/2015.
 */
public abstract class GridAbs {
    public float left, bottom, maxWidth, maxHeight;
    public int unitY;

    /**
     * Init Params
     */
    protected void init(Paint paint) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
    }

    public abstract void drawGrid(Canvas canvas, Paint paint);
}
