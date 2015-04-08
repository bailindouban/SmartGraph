package originator.ailin.com.smartgraph.grid;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Kim_Bai on 2/15/2015.
 */
public abstract class GridAbs {
    public float left, bottom, maxWidth, maxHeight;
    public int unitY;

    public abstract void drawGridY(Canvas canvas, Paint paint);
}
