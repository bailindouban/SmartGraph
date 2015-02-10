package originator.ailin.com.smartgraph.piechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.BaseChart;

public class PieChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public PieChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(datas != null) {
            for(int i = 0; i < datas.length; i++) {
                int leftInit = left;
                paint.setColor(colors[i]);
                Path path = new Path();
                path.moveTo(leftInit, bottom - datas[i][0]);
                for(int j = 1; j < datas[i].length; j++) {
                    leftInit += interval;
                    path.lineTo(leftInit, bottom - datas[i][j]);
                }

                canvas.drawPath(path, paint);
            }
        }
    }
}
