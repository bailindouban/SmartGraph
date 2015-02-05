package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;

import originator.ailin.com.smartgraph.barchart.BarChart;
import originator.ailin.com.smartgraph.barchart.SimpleBarChart;
import originator.ailin.com.test.Utils.Constant;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class TestBarChart {
    private Context mContext;
    private Resources mResources;

    /**
     * Constructor
     * @param mContext
     */
    public TestBarChart(Context mContext) {
        this.mContext = mContext;
        mResources = mContext.getResources();
        Constant.putColorValues(mResources);
    }

    /**
     * Draw Simple Bar Chart
     * @return
     */
    public View drawSimpleBarChart() {
        int[] data = {10, 50, 32, 59, 200, 63};
        SimpleBarChart simpleBarChart = new SimpleBarChart(mContext);
        simpleBarChart.data = data;
        simpleBarChart.color = Constant.COLOR_BLUE;
        return simpleBarChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    public View drawBarChart() {
        int[][] data = {{10, 50, 32}, {47, 120, 67}, {421, 63, 74}, {22, 23, 24}, {342,321,358}};
        int[] color = {Constant.COLOR_BLUE, Constant.COLOR_PINK, Constant.COLOR_YELLOW};
        BarChart barChart = new BarChart(mContext);
        barChart.data = data;
        barChart.color = color;
        return barChart;
    }
}
