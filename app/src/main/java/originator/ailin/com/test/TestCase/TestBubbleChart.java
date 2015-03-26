package originator.ailin.com.test.TestCase;

import android.content.Context;
import android.view.View;

import originator.ailin.com.smartgraph.legend.base.obj.MyPoint;
import originator.ailin.com.smartgraph.legend.bubblechart.BubbleChart;
import originator.ailin.com.smartgraph.legend.bubblechart.SimpleBubbleChart;
import originator.ailin.com.test.TestCase.base.TestChart;
import originator.ailin.com.test.Utils.Constant;

/**
 * Created by Kim_Bai on 2/5/2015.
 */
public class TestBubbleChart extends TestChart {
    /**
     * Constructor
     *
     * @param context
     */
    public TestBubbleChart(Context context) {
        super(context);
    }

    /**
     * Draw Simple Bar Chart
     * @return
     */
    @Override
    public View drawSimpleChart() {
        baseChart = new SimpleBubbleChart(context);
        MyPoint[] bubblePoint = {new MyPoint(50, 270, 100), new MyPoint(380, 320, 40), new MyPoint(500, 80, 80)};
        baseChart.bubbleObj.bubblePoint = bubblePoint;
        baseChart.color = Constant.COLOR_BLUE;
        return baseChart;
    }

    /**
     * Draw Bar Chart
     * @return
     */
    @Override
    public View drawChart() {
        baseChart = new BubbleChart(context);
        MyPoint[] bubblePointA = {new MyPoint(150, 370, 100), new MyPoint(480, 350, 40), new MyPoint(250, 180, 60), new MyPoint(53, 69, 52)};
        MyPoint[] bubblePointB = {new MyPoint(400, 160, 30), new MyPoint(300, 150, 80), new MyPoint(130, 370, 60)};
        MyPoint[] bubblePointC = {new MyPoint(50, 270, 100), new MyPoint(380, 320, 40), new MyPoint(500, 80, 80), new MyPoint(400, 60, 50), new MyPoint(650, 260, 40)};

        MyPoint[][] bubblePoints = {bubblePointA, bubblePointB, bubblePointC};
        baseChart.bubbleObj.bubblePoints = bubblePoints;

        baseChart.colors = new int[] {Constant.COLOR_BLUE, Constant.COLOR_PINK, Constant.COLOR_GREEN};
        return baseChart;
    }
}
