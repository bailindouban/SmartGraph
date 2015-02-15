package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.view.View;

import originator.ailin.com.smartgraph.legend.areachart.AreaChart;
import originator.ailin.com.smartgraph.legend.areachart.SimpleAreaChart;
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
        float[] data = {320, 320, 280, 120, 150};
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
        float[][] datas = {{320, 320, 280, 120, 150}, {120, 120, 120, 210, 280}};
        int[] colors = {Constant.COLOR_BLUE, Constant.COLOR_PINK};
        baseChart.datas = datas;
        baseChart.colors = colors;
        baseChart.barObj.interval = 150;
        return baseChart;
    }

}
