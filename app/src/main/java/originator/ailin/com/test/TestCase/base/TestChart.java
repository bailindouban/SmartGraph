package originator.ailin.com.test.TestCase.base;

import android.content.Context;
import android.view.View;

import originator.ailin.com.smartgraph.base.Chart;
import originator.ailin.com.smartgraph.base.SimpleChart;
import originator.ailin.com.test.Utils.Constant;

/**
 * Created by Kim_Bai on 2/6/2015.
 */
public abstract class TestChart {
    public Context mContext;
    public SimpleChart mSimpleChart;
    public Chart mChart;

    /**
     * Constructor
     * @param context
     */
    public TestChart(Context context) {
        mContext = context;
        Constant.putColorValues(mContext.getResources());
    }

    /**
     * Draw Simple Bar Chart
     * @return
     */
    abstract public View drawSimpleChart();

    /**
     * Draw Bar Chart
     * @return
     */
    abstract public View drawChart();
}
