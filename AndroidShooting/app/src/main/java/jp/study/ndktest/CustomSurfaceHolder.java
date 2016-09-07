package jp.study.ndktest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.SurfaceHolder;

/**
 * Created by ishitaku on 2016/09/06.
 */
public class CustomSurfaceHolder implements SurfaceHolder.Callback, Runnable {

    private Thread mThread = null;
    private SurfaceHolder mSurfaceHolder = null;
    private boolean mLoop = true;

    private float dx = 10, dy = 10;
    private float width, height;
    private int   circle_x, circle_y;


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //
        mSurfaceHolder = holder;
        //スレッドを生成
        mThread = new Thread(this);
        //スレッドを開始
        mThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.width = width;
        this.height = height;

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mLoop = false;
        //スレッドを停止
        mThread = null;
    }

    @Override
    public void run() {
        while (mLoop) {
            //丸の表示位置を動かす
            if( circle_x < 0 || circle_x > this.width ){
                dx = -dx;
            }
            if( circle_y < 0 || circle_y > this.height ){
                dy = -dy;
            }
            circle_x += dx;
            circle_y += dy;
            //描画処理を開始
            Canvas canvas = mSurfaceHolder.lockCanvas();
            canvas.drawColor(0, PorterDuff.Mode.CLEAR );
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            canvas.drawCircle( circle_x, circle_y, 50, paint);
            //描画処理を終了
            mSurfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}
