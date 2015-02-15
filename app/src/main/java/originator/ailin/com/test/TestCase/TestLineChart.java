package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.view.View;

import originator.ailin.com.smartgraph.legend.linechart.LineChart;
import originator.ailin.com.smartgraph.legend.linechart.SimpleLineChart;
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
        baseChart = new SimpleLineChart(context);
        float[] data = {10, 50, 32, 59, 200, 63};
        baseChart.data = data;
        baseChart.color = Constant.COLOR_BLUE;
        baseChart.barObj.width = 10;
        baseChart.barObj.interval = 150;
        return baseChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    @Override
    public View drawChart() {
        baseChart = new LineChart(context);
        float[][] datas = {{220, 60, 132, 60, 140}, {47, 280, 24, 220, 67}, {421, 221, 320, 63, 104}};
        int[] colors = {Constant.COLOR_BLUE, Constant.COLOR_PINK, Constant.COLOR_YELLOW};
        baseChart.datas = datas;
        baseChart.colors = colors;
        baseChart.barObj.width = 10;
        baseChart.barObj.interval = 200;
        return baseChart;
    }
}
