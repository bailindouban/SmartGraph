package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.view.View;

import originator.ailin.com.smartgraph.chart.areachart.AreaChart;
import originator.ailin.com.smartgraph.chart.areachart.SimpleAreaChart;
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
        baseChart = new SimpleAreaChart(context);
        float[] data = {320, 320, 280, 120, 150, 335};
        baseChart.data = data;
        baseChart.color = Constant.COLOR_BLUE;
        baseChart.barObj.interval = 150;
        return baseChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    @Override
    public View drawChart() {
        baseChart = new AreaChart(context);
        float[][] datas = {{60, 140, 80, 120, 150, 120}, {120, 120, 120, 110, 180, 59}, {50, 80, 70, 110, 100, 59}, {220, 120, 150, 210, 96, 147}};
        int[] colors = {Constant.COLOR_BLUE, Constant.COLOR_PINK, Constant.COLOR_YELLOW, Constant.COLOR_GREEN};
        baseChart.datas = datas;
        baseChart.colors = colors;
        baseChart.barObj.interval = 150;
        return baseChart;
    }

}
