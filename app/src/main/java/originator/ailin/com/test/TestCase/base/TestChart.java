package originator.ailin.com.test.TestCase.base;

import android.content.Context;
import android.view.View;

import originator.ailin.com.smartgraph.base.BaseChart;
import originator.ailin.com.test.Utils.Constant;

/**
 * Created by Kim_Bai on 2/6/2015.
 */
public abstract class TestChart {
    public BaseChart baseChart;
    public Context context;
    /**
     * Constructor
     * @param context
     */
    public TestChart(Context context) {
        Constant.putColorValues(context.getResources());
        this.context = context;
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

    /**
     * Draw Special Chart
     * @return
     */
    public View drawSpecialChart() {
        return null;
    };
}
