package originator.ailin.com.smartgraph.barchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.BaseChart;

public class BarChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public BarChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public BarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(datas != null) {
            int leftInit = barObj.left;
            for(int i = 0; i < datas.length; i++) {
                for(int j = 0; j < datas[i].length; j++) {
                    paint.setColor(colors[j]);
                    RectF rectF = new RectF(leftInit, barObj.bottom - datas[i][j], leftInit + barObj.width, barObj.bottom);
                    canvas.drawRect(rectF, paint);
                    leftInit += barObj.width;
                }

                leftInit += barObj.interval;
            }
        }
    }
}
