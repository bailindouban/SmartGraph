package originator.ailin.com.smartgraph.barchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class SimpleBarChart extends View {
    private Paint mPaint;
    private int[] mData;
    private int mColor;
    private int mLeft, mTop, mBottom, mWidth, mInterval;

    public SimpleBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);

        mTop = 10;
        mBottom = 1000;
        mWidth = 50;
        mInterval = 30;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("kim", "onDraw");
        if(mData != null) {
            mLeft = 10;
            for(int d : mData) {
                mPaint.setColor(mColor);
                Rect rect = new Rect(mLeft, mBottom - d, mLeft + mWidth, mBottom);
                canvas.drawRect(rect, mPaint);
                mLeft += mWidth + mInterval;
            }
        }
    }

    public void setmData(int[] mData) {
        this.mData = mData;
    }

    public void setmColor(int mColor) {
        this.mColor = mColor;
    }
}
