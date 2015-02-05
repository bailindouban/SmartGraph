package originator.ailin.com.test.TestCase;

import android.content.res.Resources;
import android.view.View;

import originator.ailin.com.smartgraph.base.Chart;
import originator.ailin.com.smartgraph.base.SimpleChart;
import originator.ailin.com.test.Utils.Constant;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class TestBarChart {
    private Resources mResources;

    /**
     * Constructor
     * @param resources
     */
    public TestBarChart(Resources resources) {
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
        return simpleChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    public View drawChart(Chart chart) {
        int[][] data = {{10, 50, 32}, {47, 120, 67}, {421, 63, 74}, {22, 23, 24}, {342,321,358}};
        int[] color = {Constant.COLOR_BLUE, Constant.COLOR_PINK, Constant.COLOR_YELLOW};
        chart.data = data;
        chart.color = color;
        return chart;
    }
}
