package jp.study.ndktest.AppMain;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private Bitmap mBitmap = null;

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

            //描画処理を開始
            Canvas canvas = mSurfaceHolder.lockCanvas();
            canvas.drawBitmap(mBitmap, 0, 0, new Paint());
            //描画処理を終了
            mSurfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}
