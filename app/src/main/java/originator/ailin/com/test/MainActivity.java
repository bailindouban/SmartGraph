package originator.ailin.com.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import originator.ailin.com.smartgraph.barchart.BarChart;
import originator.ailin.com.smartgraph.barchart.SimpleBarChart;
import originator.ailin.com.smartgraph.linechart.LineChart;
import originator.ailin.com.smartgraph.linechart.SimpleLineChart;
import originator.ailin.com.test.TestCase.TestBarChart;
import originator.ailin.com.test.TestCase.TestLineChart;
import originator.ailin.com.test.Utils.Constant;


public class MainActivity extends ActionBarActivity {
    private Context mContext;
    private TestBarChart mTestBarChart;
    private TestLineChart mTestLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mContext = getApplicationContext();
        mTestBarChart = new TestBarChart(mContext.getResources());
        mTestLineChart = new TestLineChart(mContext.getResources());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SubMenu barChart = menu.addSubMenu(R.string.bar_chart);
        SubMenu pieChart = menu.addSubMenu(R.string.pie_chart);
        SubMenu lineChart = menu.addSubMenu(R.string.line_chart);

        // BAR CHART
        barChart.add(Constant.GROUP_ID_BAR_CHART, Constant.ITEM_ID_SIMPLE_BAR_CHART, 0, R.string.bar_chart_simple);
        barChart.add(Constant.GROUP_ID_BAR_CHART, Constant.ITEM_ID_BAR_CHART, 0, R.string.bar_chart);

        // PIE CHART
        pieChart.add(Constant.GROUP_ID_PIE_CHART, Constant.ITEM_ID_SIMPLE_PIE_CHART, 0, R.string.pie_chart_simple);
        pieChart.add(Constant.GROUP_ID_PIE_CHART, Constant.ITEM_ID_PIE_CHART, 0, R.string.pie_chart);

        // LINE CHART
        lineChart.add(Constant.GROUP_ID_LINE_CHART, Constant.ITEM_ID_SIMPLE_LINE_CHART, 0, R.string.line_chart_simple);
        lineChart.add(Constant.GROUP_ID_LINE_CHART, Constant.ITEM_ID_LINE_CHART, 0, R.string.line_chart);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case Constant.ITEM_ID_SIMPLE_BAR_CHART:
                setContentView(mTestBarChart.drawSimpleChart(new SimpleBarChart(mContext)));
                return true;
            case Constant.ITEM_ID_BAR_CHART:
                setContentView(mTestBarChart.drawChart(new BarChart(mContext)));
                return true;
            case Constant.ITEM_ID_SIMPLE_LINE_CHART:
                setContentView(mTestLineChart.drawSimpleChart(new SimpleLineChart(mContext)));
                return true;
            case Constant.ITEM_ID_LINE_CHART:
                setContentView(mTestLineChart.drawChart(new LineChart(mContext)));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
