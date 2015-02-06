package originator.ailin.com.test.Utils;

import android.content.res.Resources;

import originator.ailin.com.test.R;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class Constant {
    private Constant() {}

    public static int COLOR_PINK, COLOR_YELLOW, COLOR_GREEN, COLOR_BLUE;

    public static void putColorValues(Resources resources) {
        COLOR_PINK = resources.getColor(R.color.pink);
        COLOR_YELLOW = resources.getColor(R.color.yellow);
        COLOR_GREEN = resources.getColor(R.color.green);
        COLOR_BLUE = resources.getColor(R.color.blue);
    }
}
