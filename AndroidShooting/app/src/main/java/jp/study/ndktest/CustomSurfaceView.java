package jp.study.ndktest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by ishitaku on 2016/09/06.
 */
public class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private Thread mThread = null;
    private SurfaceHolder mSurfaceHolder = null;
    private boolean mLoop = true;
    private Bitmap mBitmap = null;
    private long t1 = 0, t2 = 0; // スリープ用変数


    CustomSurfaceView(Context context) {
        super(context);
        mSurfaceHolder = getHolder();
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    CustomSurfaceView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.player);
        //スレッドを生成
        mThread = new Thread(this);
        //スレッドを開始
        mThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

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
            t1 = System.currentTimeMillis();

            //描画処理を開始
            Canvas canvas = mSurfaceHolder.lockCanvas();
            //更新

            canvas.drawBitmap(mBitmap, 0, 0, new Paint());


            //描画処理を終了
            mSurfaceHolder.unlockCanvasAndPost(canvas);

            // スリープ
            t2 = System.currentTimeMillis();
            if (t2 - t1 < 16) { // 1000 / 60 = 16.6666
                try {
                    Thread.sleep(16 - (t2 - t1));
                } catch (InterruptedException e) {

                }
            }

        }
    }

}
