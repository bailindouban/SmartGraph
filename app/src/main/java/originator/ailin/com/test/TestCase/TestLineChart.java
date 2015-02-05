package originator.ailin.com.test.TestCase;

import android.content.res.Resources;
import android.view.View;

import originator.ailin.com.smartgraph.base.Chart;
import originator.ailin.com.smartgraph.base.SimpleChart;
import originator.ailin.com.test.Utils.Constant;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class TestLineChart {
    private Resources mResources;

    /**
     * Constructor
     * @param resources
     */
    public TestLineChart(Resources resources) {
        Constant.putColorValues(resources);
    }

    /**
     * Draw Simple Bar Chart
     * @return
     */
    public View drawSimpleChart(SimpleChart simpleChart) {
        int[] data = {10, 50, 32, 59, 200, 63};
        simpleChart.data = data;
        simpleChart.color = Constant.COLOR_BLUE;
        simpleChart.width = 10;
        simpleChart.interval = 150;
        return simpleChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    public View drawChart(Chart chart) {
        int[][] data = {{220, 60, 132, 60, 140}, {47, 280, 24, 220, 67}, {421, 221, 320, 63, 104}};
        int[] color = {Constant.COLOR_BLUE, Constant.COLOR_PINK, Constant.COLOR_YELLOW};
        chart.data = data;
        chart.color = color;
        chart.width = 10;
        chart.interval = 200;
        return chart;
    }
}
