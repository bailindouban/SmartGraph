package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.view.View;

import originator.ailin.com.smartgraph.legend.barchart.BarChart;
import originator.ailin.com.smartgraph.legend.barchart.SimpleBarChart;
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
        baseChart = new SimpleBarChart(context);
        float[] data = {10, 50, 622, 59, 200, 63, 503, 43, 569, 402};
        baseChart.data = data;
        baseChart.color = Constant.COLOR_BLUE;

        baseChart.titleText = "2014年销售业绩";
        baseChart.polarsTextX = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        baseChart.labelsText = new String[] {"白白"};
        return baseChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    @Override
    public View drawChart() {
        baseChart = new BarChart(context);
        float[][] datas = {{10, 50, 32}, {47, 120, 67}, {421, 63, 74}, {342,321,358}};
        int[] colors = {Constant.COLOR_BLUE, Constant.COLOR_PINK, Constant.COLOR_YELLOW};
        baseChart.datas = datas;
        baseChart.colors = colors;

        baseChart.titleText = "2015年销售业绩";
        baseChart.titleSize = 54;
        baseChart.titleColor = Constant.COLOR_GREEN;
        baseChart.polarsTextX = new String[] {"1月份", "2月份", "3月份", "4月份"};
        baseChart.labelsText = new String[] {"小明", "白白", "小王"};
        return baseChart;
    }
}
