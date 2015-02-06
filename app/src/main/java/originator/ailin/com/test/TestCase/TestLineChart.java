package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.view.View;

import originator.ailin.com.smartgraph.linechart.LineChart;
import originator.ailin.com.smartgraph.linechart.SimpleLineChart;
import originator.ailin.com.test.TestCase.base.TestChart;
import originator.ailin.com.test.Utils.Constant;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class TestLineChart extends TestChart {
    /**
     * Constructor
     *
     * @param context
     */
    public TestLineChart(Context context) {
        super(context);
    }

    /**
     * Draw Simple Bar Chart
     * @return
     */
    @Override
    public View drawSimpleChart() {
        mSimpleChart = new SimpleLineChart(mContext);
        int[] data = {10, 50, 32, 59, 200, 63};
        mSimpleChart.data = data;
        mSimpleChart.color = Constant.COLOR_BLUE;
        mSimpleChart.width = 10;
        mSimpleChart.interval = 150;
        return mSimpleChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    @Override
    public View drawChart() {
        mChart = new LineChart(mContext);
        int[][] data = {{220, 60, 132, 60, 140}, {47, 280, 24, 220, 67}, {421, 221, 320, 63, 104}};
        int[] color = {Constant.COLOR_BLUE, Constant.COLOR_PINK, Constant.COLOR_YELLOW};
        mChart.data = data;
        mChart.color = color;
        mChart.width = 10;
        mChart.interval = 200;
        return mChart;
    }
}
