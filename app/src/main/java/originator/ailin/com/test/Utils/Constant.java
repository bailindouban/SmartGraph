package originator.ailin.com.test.Utils;

import android.content.res.Resources;

import originator.ailin.com.test.R;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class Constant {
    private Constant() {}

    public final static int GROUP_ID_BAR_CHART = 1;
    public final static int GROUP_ID_PIE_CHART = 2;
    public final static int GROUP_ID_LINE_CHART = 3;

    // BAR CHART
    public final static int ITEM_ID_SIMPLE_BAR_CHART = 11;
    public final static int ITEM_ID_BAR_CHART = 12;

    // PIE CHART
    public final static int ITEM_ID_SIMPLE_PIE_CHART = 21;
    public final static int ITEM_ID_PIE_CHART = 22;

    // LINE CHART
    public final static int ITEM_ID_SIMPLE_LINE_CHART = 31;
    public final static int ITEM_ID_LINE_CHART = 32;

    public static int COLOR_PINK, COLOR_YELLOW, COLOR_GREEN, COLOR_BLUE;

    public static void putColorValues(Resources resources) {
        COLOR_PINK = resources.getColor(R.color.pink);
        COLOR_YELLOW = resources.getColor(R.color.yellow);
        COLOR_GREEN = resources.getColor(R.color.green);
        COLOR_BLUE = resources.getColor(R.color.blue);
    }
}
