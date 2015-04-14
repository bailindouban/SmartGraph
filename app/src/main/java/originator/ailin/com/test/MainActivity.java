package originator.ailin.com.test;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import originator.ailin.com.test.TestCase.TestAreaChart;
import originator.ailin.com.test.TestCase.TestBarChart;
import originator.ailin.com.test.TestCase.TestBubbleChart;
import originator.ailin.com.test.TestCase.TestDoughnutChart;
import originator.ailin.com.test.TestCase.TestLineChart;
import originator.ailin.com.test.TestCase.TestPieChart;
import originator.ailin.com.test.TestCase.TestScatterChart;
import originator.ailin.com.test.TestCase.base.TestChart;

public class MainActivity extends ActionBarActivity {
    private Context mContext;
    private Resources mResources;
    private TestChart[] mTestChart;
    private String[][] mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mContext = getApplicationContext();
        mResources = mContext.getResources();

        mTestChart = new TestChart[] {
                new TestBarChart(mContext),
                new TestLineChart(mContext),
                new TestAreaChart(mContext),
                new TestBubbleChart(mContext),
                new TestScatterChart(mContext),
                new TestPieChart(mContext),
                new TestDoughnutChart(mContext)
        };
        mChart = new String[][]{
                mResources.getStringArray(R.array.bar_chart),
                mResources.getStringArray(R.array.line_chart),
                mResources.getStringArray(R.array.area_chart),
                mResources.getStringArray(R.array.bubble_chart),
                mResources.getStringArray(R.array.scatter_plot),
                mResources.getStringArray(R.array.pie_chart),
                mResources.getStringArray(R.array.doughnut_chart)
        };

        // Default
        View mView = mTestChart[0].drawSimpleChart();

        setContentView(mView);

/*        Animation animation_alpha = new AlphaAnimation(0.1f, 1f);
        animation_alpha.setDuration(5000);
        mView.startAnimation(animation_alpha);
        Animation animation_scale = new ScaleAnimation(0f, 1.4f, 0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        for (int i = 0; i < mChart.length; i++) {
            SubMenu subMenu = menu.addSubMenu(mChart[i][1]);
            for (int j = 0; j < mChart[i].length; j++) {
                subMenu.add(i + 1, (i + 1) * 10 + j + 1, 0, mChart[i][j]);
            }
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        int groupId = item.getGroupId() - 1;
        int itemId = item.getItemId();

        switch (itemId % 10) {
            case 1:
                setContentView(mTestChart[groupId].drawSimpleChart());
                return true;
            case 2:
                setContentView(mTestChart[groupId].drawChart());
                return true;
            case 3:
                setContentView(mTestChart[groupId].drawSpecialChart());
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
