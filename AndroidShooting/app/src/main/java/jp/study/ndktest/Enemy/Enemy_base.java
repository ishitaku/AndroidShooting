package jp.study.ndktest.Enemy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import jp.study.ndktest.Stage;

/**
 * Created by ishitaku on 2016/09/24.
 */
public abstract class Enemy_base {
    //コンテキスト
    Context mContext = null;
    //ペインｔ
    Paint mPaint = null;
    //状態
    enum State {
        MOVE,
        DESTORY
    }
    protected float mX = 0;     //x座標
    protected float mY = 0;     //y座標
    protected float mWidth = 0;     //幅
    protected float mHeight = 0;    //高さ
    protected int mBitmapWidth = 0;   //ビットマップの幅
    protected int mBitmapHeight = 0;  //ビットマップの高さ
    protected State mState = State.MOVE;


    /**
     * コンストラクタ
     */
    public Enemy_base(Context context, float x, float y) {
        mContext = context;
        mX = x;
        mY = y;
    }

    /**
     * 更新
     */
    public abstract void enemyUpdate ();

    /**
     * 描画
     */
    public abstract void enemyDraw(Canvas canvas, Paint paint);

    /**
     * 終了
     */
    public abstract void enemyEnd();

    /**
     * X座標の取得
     */
    public float getX() {
        return mX;
    }

    /**
     * Y座標の取得
     */
    public float getY() {
        return mY;
    }

    /**
     * X座標の設定
     */
    public void setX(float x) {
        mX = x;
    }

    /**
     * Y座標の設定
     */
    public void setY(float y) {
        mY = y;
    }

    /**
     * 幅の取得
     */
    public float getWidth() {
        return mWidth;
    }

    /**
     * 高さの取得
     */
    public float getHeight() {
        return mHeight;
    }

    /**
     * 画像の幅の取得
     */
    public float getBitmapWidth() {
        return mBitmapWidth;
    }

    /**
     * 画像の高さの取得
     */
    public float getBitmapHeight() {
        return mBitmapHeight;
    }

}
