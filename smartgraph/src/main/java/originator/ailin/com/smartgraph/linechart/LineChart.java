package originator.ailin.com.smartgraph.linechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;

import originator.ailin.com.smartgraph.base.BaseChart;

public class LineChart extends BaseChart {
    /**
     * Constructor 1
     * @param context
     */
    public LineChart(Context context) {
        super(context);
    }

    /**
     * Constructor 2
     * @param context
     * @param attrs
     */
    public LineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(datas != null) {
            for(int i = 0; i < datas.length; i++) {
                int leftInit = barObj.left;
                paint.setColor(colors[i]);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(barObj.width);
                Path path = new Path();
                path.moveTo(leftInit, barObj.bottom - datas[i][0]);
                for(int j = 1; j < datas[i].length; j++) {
                    leftInit += barObj.interval;
                    path.lineTo(leftInit, barObj.bottom - datas[i][j]);
                }
                canvas.drawPath(path, paint);
            }
        }
    }
}
