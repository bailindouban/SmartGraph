package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.graphics.Point;
import android.view.View;

import originator.ailin.com.smartgraph.legend.doughnutchart.DoughnutChart;
import originator.ailin.com.smartgraph.legend.doughnutchart.RoseChart;
import originator.ailin.com.smartgraph.legend.doughnutchart.SimpleDoughnutChart;
import originator.ailin.com.test.TestCase.base.TestChart;
import originator.ailin.com.test.Utils.Constant;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class TestDoughnutChart extends TestChart {

    /**
     * Constructor
     *
     * @param context
     */
    public TestDoughnutChart(Context context) {
        super(context);
    }

    /**
     * Draw Simple Bar Chart
     * @return
     */
    @Override
    public View drawSimpleChart() {
        baseChart = new SimpleDoughnutChart(context);
        float[] data = {8.2f, 3.2f, 1.4f, 1.2f};
        int[] colors = {Constant.COLOR_BLUE, Constant.COLOR_GREEN, Constant.COLOR_YELLOW, Constant.COLOR_PINK};
        baseChart.data = data;
        baseChart.colors = colors;
        baseChart.doughnutObj.center = new Point(600, 800);
        baseChart.doughnutObj.radiusOuter = 300;
        baseChart.doughnutObj.radiusInner = 180;
        baseChart.doughnutObj.startAngle = 0;
        return baseChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    @Override
   public View drawChart() {
        baseChart = new DoughnutChart(context);
        float[] data = {8.2f, 3.2f, 1.4f, 1.2f};
        float[] bias = {50, 50, 50, 50};
        int[] colors = {Constant.COLOR_BLUE, Constant.COLOR_GREEN, Constant.COLOR_YELLOW, Constant.COLOR_PINK};
        baseChart.data = data;
        baseChart.colors = colors;
        baseChart.doughnutObj.bias = bias;
        baseChart.doughnutObj.center = new Point(600, 800);
        baseChart.doughnutObj.radiusOuter = 300;
        baseChart.doughnutObj.radiusInner = 180;
        baseChart.doughnutObj.startAngle = 0;
        return baseChart;
    }

    @Override
    public View drawSpecialChart() {
        baseChart = new RoseChart(context);
        float[] data = {10f, 5f, 15f, 25f, 20f, 35f, 30f, 40f};
        int[] colors = {Constant.COLOR_BLUE, Constant.COLOR_GREEN, Constant.COLOR_YELLOW, Constant.COLOR_PINK, Constant.COLOR_BLUE, Constant.COLOR_GREEN, Constant.COLOR_YELLOW, Constant.COLOR_PINK};
        baseChart.data = data;
        baseChart.colors = colors;
        baseChart.doughnutObj.center = new Point(600, 800);
        baseChart.doughnutObj.radiusOuter = 200;
        baseChart.doughnutObj.radiusInner = 50;
        baseChart.doughnutObj.startAngle = 0;
        return baseChart;
    }
}
