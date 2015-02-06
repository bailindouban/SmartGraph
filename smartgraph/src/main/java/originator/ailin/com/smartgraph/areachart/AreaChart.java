package originator.ailin.com.smartgraph.areachart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import originator.ailin.com.smartgraph.base.Chart;

public class AreaChart extends Chart {
    /**
     * Constructor 1
     * @param context
     */
    public AreaChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public AreaChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(data != null) {
            List[] dataDeal = getDataArray();
        }
    }

    /**
     * 要用迭代算法？
     * @return
     */
    private List[] getDataArray() {
        List[] dataArray = new ArrayList[3];
        for(int i = 0; i < data.length; i++) {
            int leftInit = left;
            dataArray[i] = new ArrayList();
            dataArray[i].add(new Point(leftInit, bottom - data[i][0]));
            for(int j = 1; j < data[i].length; j++) {
                leftInit += interval;
                dataArray[i].add(new Point(leftInit, bottom - data[i][j]));
            }
            dataArray[i].add(new Point(leftInit, bottom));
            dataArray[i].add(new Point(leftInit, bottom));
        }

        return dataArray;
    }
}
