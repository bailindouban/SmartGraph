package originator.ailin.com.smartgraph.areachart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import originator.ailin.com.smartgraph.base.BaseChart;

public class AreaChart extends BaseChart {
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
        if(datas != null) {
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
            int leftInit = barObj.left;
            dataArray[i] = new ArrayList();
            dataArray[i].add(new PointF(leftInit, barObj.bottom - datas[i][0]));
            for(int j = 1; j < datas[i].length; j++) {
                leftInit += barObj.interval;
                dataArray[i].add(new PointF(leftInit, barObj.bottom - datas[i][j]));
            }
            dataArray[i].add(new Point(leftInit, barObj.bottom));
            dataArray[i].add(new Point(leftInit, barObj.bottom));
        }

        return dataArray;
    }
}
