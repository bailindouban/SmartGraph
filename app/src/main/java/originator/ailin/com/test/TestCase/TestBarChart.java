package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.view.View;

import originator.ailin.com.smartgraph.barchart.BarChart;
import originator.ailin.com.smartgraph.barchart.SimpleBarChart;
import originator.ailin.com.test.TestCase.base.TestChart;
import originator.ailin.com.test.Utils.Constant;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class TestBarChart extends TestChart {
    /**
     * Constructor
     *
     * @param context
     */
    public TestBarChart(Context context) {
        super(context);
    }

    /**
     * Draw Simple Bar Chart
     * @return
     */
    @Override
    public View drawSimpleChart() {
        mSimpleChart = new SimpleBarChart(mContext);
        int[] data = {10, 50, 32, 59, 200, 63};
        mSimpleChart.data = data;
        mSimpleChart.color = Constant.COLOR_BLUE;
        return mSimpleChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    @Override
    public View drawChart() {
        mChart = new BarChart(mContext);
        int[][] data = {{10, 50, 32}, {47, 120, 67}, {421, 63, 74}, {22, 23, 24}, {342,321,358}};
        int[] color = {Constant.COLOR_BLUE, Constant.COLOR_PINK, Constant.COLOR_YELLOW};
        mChart.data = data;
        mChart.color = color;
        return mChart;
    }
}
