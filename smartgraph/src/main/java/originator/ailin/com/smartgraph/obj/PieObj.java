package originator.ailin.com.smartgraph.obj;

import android.graphics.Point;

/**
 * Created by Kim_Bai on 2/13/2015.
 */
public class PieObj {
    public Point center = new Point(500, 400);
    public float startAngle = 0;
    public float bias[] = new float[10];

    // For Pie Chart
    public int radius = 150;

    // For Doughnut Chart
    public int radiusInner = 150, radiusOuter = 400;
}
