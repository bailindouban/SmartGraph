package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.graphics.Point;
import android.view.View;

import originator.ailin.com.smartgraph.chart.piechart.PieChart;
import originator.ailin.com.smartgraph.chart.piechart.SimplePieChart;
import originator.ailin.com.test.TestCase.base.TestChart;
import originator.ailin.com.test.Utils.Constant;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class TestPieChart extends TestChart {

    /**
     * Constructor
     *
     * @param context
     */
    public TestPieChart(Context context) {
        super(context);
    }

    /**
     * Draw Simple Bar Chart
     * @return
     */
    @Override
    public View drawSimpleChart() {
        baseChart = new SimplePieChart(context);
        float[] data = {8.2f, 3.2f, 1.4f, 1.2f};
        int[] colors = {Constant.COLOR_BLUE, Constant.COLOR_GREEN, Constant.COLOR_YELLOW, Constant.COLOR_PINK};
        baseChart.data = data;
        baseChart.colors = colors;
        baseChart.pieObj.center = new Point(500, 800);
        baseChart.pieObj.radius = 300;
        baseChart.pieObj.startAngle = 0;
        return baseChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    @Override
   public View drawChart() {
        baseChart = new PieChart(context);
        float[] data = {8.2f, 3.2f, 1.4f, 1.2f};
        float[] bias = {50, 50, 50, 50};
        int[] colors = {Constant.COLOR_BLUE, Constant.COLOR_GREEN, Constant.COLOR_YELLOW, Constant.COLOR_PINK};
        baseChart.data = data;
        baseChart.pieObj.bias = bias;
        baseChart.colors = colors;
        baseChart.pieObj.center = new Point(500, 800);
        baseChart.pieObj.radius = 300;
        baseChart.pieObj.startAngle = 0;
        return baseChart;
    }
}
