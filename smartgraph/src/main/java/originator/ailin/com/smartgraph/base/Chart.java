package originator.ailin.com.smartgraph.base;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class Chart extends BaseChart {
    public int[][] data;
    public int[] color;

    /**
     * Constructor 1
     * @param context
     */
    public Chart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public Chart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
