package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.view.View;

import originator.ailin.com.smartgraph.areachart.AreaChart;
import originator.ailin.com.smartgraph.areachart.SimpleAreaChart;
import originator.ailin.com.test.TestCase.base.TestChart;
import originator.ailin.com.test.Utils.Constant;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class TestAreaChart extends TestChart {
    /**
     * Constructor
     *
     * @param context
     */
    public TestAreaChart(Context context) {
        super(context);
    }

    /**
     * Draw Simple Bar Chart
     * @return
     */
    @Override
    public View drawSimpleChart() {
        mSimpleChart = new SimpleAreaChart(mContext);
        int[] data = {320, 320, 280, 120, 150};
        mSimpleChart.data = data;
        mSimpleChart.color = Constant.COLOR_BLUE;
        mSimpleChart.interval = 150;
        return mSimpleChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    @Override
    public View drawChart() {
        mChart = new AreaChart(mContext);
        int[][] data = {{320, 320, 280, 120, 150}, {120, 120, 120, 210, 280}};
        int[] color = {Constant.COLOR_BLUE, Constant.COLOR_PINK};
        mChart.data = data;
        mChart.color = color;
        mChart.interval = 150;
        return mChart;
    }

}
