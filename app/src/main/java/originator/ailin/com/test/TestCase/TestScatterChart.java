package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;

import originator.ailin.com.smartgraph.chart.scatterplot.ScatterPlot;
import originator.ailin.com.smartgraph.chart.scatterplot.SimpleScatterPlot;
import originator.ailin.com.test.TestCase.base.TestChart;
import originator.ailin.com.test.Utils.Constant;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class TestScatterChart extends TestChart {
    /**
     * Constructor
     *
     * @param context
     */
    public TestScatterChart(Context context) {
        super(context);
    }

    /**
     * Draw Simple Bar Chart
     * @return
     */
    @Override
    public View drawSimpleChart() {
        baseChart = new SimpleScatterPlot(context);
        PointF[] scatterPoint = {new PointF(70, 130), new PointF(180, 120), new PointF(560, 180), new PointF(460, 290), new PointF(60, 230), new PointF(390, 250)};
        baseChart.scatterObj.scatterPoint = scatterPoint;
        baseChart.scatterObj.radius = 20;
        baseChart.color = Constant.COLOR_BLUE;
        return baseChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    @Override
    public View drawChart() {
        baseChart = new ScatterPlot(context);
        PointF[] scatterPointA = {new PointF(150, 270), new PointF(480, 350), new PointF(250, 180), new PointF(53, 69), new PointF(553, 469)};
        PointF[] scatterPointB = {new PointF(400, 160), new PointF(300, 150), new PointF(130, 370), new PointF(620, 260), new PointF(323, 89)};
        PointF[] scatterPointC = {new PointF(50, 270), new PointF(380, 320), new PointF(500, 80), new PointF(400, 60), new PointF(23, 169)};

        PointF[][] scatterPoints = {scatterPointA, scatterPointB, scatterPointC};
        baseChart.scatterObj.scatterPoints = scatterPoints;
        baseChart.scatterObj.radii = new float[] {20, 40, 30};
        baseChart.colors = new int[] {Constant.COLOR_BLUE, Constant.COLOR_PINK, Constant.COLOR_GREEN};
        return baseChart;
    }
}
