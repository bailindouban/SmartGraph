package originator.ailin.com.test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import originator.ailin.com.test.TestCase.TestBarChart;
import originator.ailin.com.test.Utils.Constant;


public class MainActivity extends ActionBarActivity {
    private TestBarChart mTestBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mTestBarChart = new TestBarChart(getApplication());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SubMenu barChart = menu.addSubMenu(R.string.bar_chart);
        SubMenu pieChart = menu.addSubMenu(R.string.pie_chart);

        barChart.add(Constant.GROUP_ID_BAR_CHART, Constant.ITEM_ID_SIMPLE_BAR_CHART, 0, R.string.bar_chart_simple);
        barChart.add(Constant.GROUP_ID_BAR_CHART, Constant.ITEM_ID_BAR_CHART, 0, R.string.bar_chart);

        pieChart.add(Constant.GROUP_ID_PIE_CHART, Constant.ITEM_ID_SIMPLE_PIE_CHART, 0, R.string.pie_chart_simple);
        pieChart.add(Constant.GROUP_ID_PIE_CHART, Constant.ITEM_ID_PIE_CHART, 0, R.string.pie_chart);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case Constant.ITEM_ID_SIMPLE_BAR_CHART:
                setContentView(mTestBarChart.drawSimpleBarChart());
                return true;
            case Constant.ITEM_ID_BAR_CHART:
                setContentView(mTestBarChart.drawBarChart());
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
