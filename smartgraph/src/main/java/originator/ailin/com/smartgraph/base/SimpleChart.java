package originator.ailin.com.smartgraph.base;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class SimpleChart extends BaseChart {
    public int[] data;
    public int color;

    /**
     * Constructor 1
     * @param context
     */
    public SimpleChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public SimpleChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
