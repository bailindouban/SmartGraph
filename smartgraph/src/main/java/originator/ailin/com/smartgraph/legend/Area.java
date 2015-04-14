package originator.ailin.com.smartgraph.legend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import originator.ailin.com.smartgraph.obj.BarObj;

/**
 * Created by Kim_Bai on 4/8/2015.
 */
public class Area extends LegendAbs {
    public Area(float leftInit, float bottom, BarObj barObj, float[][] datas, int[] colors, float ratio) {
        initBarParams(leftInit, bottom, barObj, datas, colors, ratio);
    }

    int size, size_sub;

    @Override
    public void drawLegend(Canvas canvas, Paint paint) {
        Float[][] dataArray = getDataArray(datas);
        for(int i = 0; i < size; i++) {
            float left = leftInit;
            paint.setColor(colors[size - i - 1]);
            Path path = new Path();
            path.moveTo(left, bottom - dataArray[i][0]);
            for(int j = 1; j < size_sub; j++) {
                left += barObj.interval;
                path.lineTo(left, bottom - dataArray[i][j] * ratio);
            }
            path.lineTo(left, bottom);
            path.lineTo(leftInit, bottom);
            path.close();
            canvas.drawPath(path, paint);
        }
    }

    /**
     * 要用迭代算法？
     * @return
     */
    private Float[][] getDataArray(float[][] datas) {
        size = datas.length;
        size_sub = datas[0].length;

        Float[][] dataArray = new Float[size][size_sub];
        Float[] totalArray = new Float[size_sub];

        for(int j = 0; j < size_sub; j++) {
            float total = 0;
            for(int i = 0; i < size; i++) {
                total += datas[i][j];
            }
            totalArray[j] = total;
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size_sub; j++) {
                dataArray[i][j] = totalArray[j];
                totalArray[j] -= datas[size - i - 1][j];
            }
        }

        return dataArray;
    }
}
