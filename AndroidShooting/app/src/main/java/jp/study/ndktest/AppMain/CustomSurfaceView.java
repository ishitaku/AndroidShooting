package jp.study.ndktest.AppMain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import jp.study.ndktest.MainGame;

/**
 * Created by ishitaku on 2016/09/06.
 */
public class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    final float VIEW_WIDTH = 720;
    final float VIEW_HEIGHT = 1280;
    private float mScale = 1.0f;

    private Thread mThread = null;
    private SurfaceHolder mSurfaceHolder = null;
    private boolean mLoop = true;
    private Bitmap mBitmap = null;
    private long t1 = 0, t2 = 0; // スリープ用変数

    private int mOldTouchX = 0; //前回タッチX
    private int mOldTouchY = 0; //前回タッチY
    private int mMoveX = 0;     //移動量X
    private int mMoveY = 0;     //移動量Y
    private boolean mOnTouch = false;

    //ゲームクラス
    private MainGame mMainGame = null;

    CustomSurfaceView(Context context) {
        super(context);
        mSurfaceHolder = getHolder();
        //SurfaceHolder surfaceHolder = getHolder();
        //surfaceHolder.addCallback(this);
        mSurfaceHolder.addCallback(this);
        //mSurfaceHolder
        //ゲーム生成
        mMainGame = new MainGame(context);
    }

    CustomSurfaceView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        float scaleX = getWidth() / VIEW_WIDTH;
        float scaleY = getHeight() /  VIEW_HEIGHT;
        mScale = scaleX > scaleY ? scaleY : scaleX;

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

            //更新
            mMainGame.gameUpdate(mMoveX, mMoveY, mOnTouch);
            //描画処理を開始
            Canvas canvas = mSurfaceHolder.lockCanvas();
            canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            // 画面の中央になるように移動させる
            canvas.translate((getWidth() - VIEW_WIDTH) / 2 * mScale, (getHeight() - VIEW_HEIGHT) / 2 * mScale);
            // 端末の画面に合わせて拡大・縮小する
            canvas.scale(mScale, mScale);

            mMainGame.gameDraw(canvas);

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

    /**
     * タッチ
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // タッチしている位置取得
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            //タッチ時
            case MotionEvent.ACTION_DOWN:
                mOnTouch = true;
                break;
            //移動
            case MotionEvent.ACTION_MOVE:
                mMoveX = x - mOldTouchX;
                mMoveY = y - mOldTouchY;
                break;
            //離したとき
            case MotionEvent.ACTION_UP:
                mOnTouch = false;
                //移動量をリセット
                mMoveX = 0;
                mMoveY = 0;
                break;
            default:
                //移動量をリセット
                mMoveX = 0;
                mMoveY = 0;
                //タッチをリセット
                //mOnTouch = false;
                break;
        }
        //Log.d("MoveX", ""+mMoveX);
        //Log.d("MoveY", ""+mMoveY);
        // 今回のタッチ位置を保持
        mOldTouchX = x;
        mOldTouchY = y;
        // イベント処理完了
        return true;
    }
}
