package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.graphics.Point;
import android.view.View;

import originator.ailin.com.smartgraph.piechart.SimplePieChart;
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
        baseChart.center = new Point(600, 800);
        baseChart.radius = 250;
        baseChart.startAngle = 0;
        return baseChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    @Override
   public View drawChart() {
        /*mChart = new PieChart(mContext);
        int[][] data = {{220, 60, 132, 60, 140}, {47, 280, 24, 220, 67}, {421, 221, 320, 63, 104}};
        int[] color = {Constant.COLOR_BLUE, Constant.COLOR_PINK, Constant.COLOR_YELLOW};
        mChart.data = data;
        mChart.color = color;
        mChart.width = 10;
        mChart.interval = 200;
        return mChart;*/
        return null;
    }
}
