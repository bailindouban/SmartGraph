package originator.ailin.com.test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import originator.ailin.com.smartgraph.BarChart;


public class MainActivity extends ActionBarActivity {
    private BarChart mBarChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init();
    }

    /**
     * drawChart
     * @param v
     */
    public void drawChart(View v) {
        switch (v.getId()) {
            case R.id.drawBarChart:
                init();
                break;
            default:
                break;
        }
    }

    private void init() {
        int data[] = {10, 50, 32, 59, 200, 63};
        mBarChart = (BarChart) findViewById(R.id.bar_chart);
        mBarChart.setmData(data);
        mBarChart.setmColor(getResources().getColor(R.color.blue));
        mBarChart.invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
