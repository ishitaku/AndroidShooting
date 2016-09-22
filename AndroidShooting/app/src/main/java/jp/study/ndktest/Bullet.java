package jp.study.ndktest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by ishitaku on 2016/09/21.
 */
public class Bullet {
    //コンテキスト
    Context mContext = null;
    private Bitmap mBitmapBullet = null;
    private float mX = 0.0f;    //x座標
    private float mY = 0.0f;    //y座標
    private float mWidth = 0.0f;    //横幅
    private float mHeight = 0.0f;   //高さ
    private int VIEW_HEIGHT = 0;
    private int VIEW_WIDTH = 0;
    private float mDy = -30.0f;

    /**
     * コンストラクタ
     * @param context
     */
    Bullet(Context context, float x, float y) {
        mContext = context;
        mX = x;
        mY = y;
        bulletInit();
    }

    /**
     * 初期化処理
     */
    private void bulletInit() {
        mBitmapBullet = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.bullet);
        //高さを設定
        VIEW_HEIGHT = mContext.getResources().getInteger(R.integer.view_height);
        //幅を設定
        VIEW_WIDTH = mContext.getResources().getInteger(R.integer.view_width);
        mWidth = mContext.getResources().getInteger(R.integer.bullet_width);
        mHeight = mContext.getResources().getInteger(R.integer.bullet_height);
    }

    /**
     * 更新
     */
    public void bulletUpdate () {
        mY += mDy;
    }

    /**
     * 描画
     */
    public void bulletDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmapBullet, mX - mWidth/2, mY - mHeight/2, new Paint());
    }

    /**
     * 解放
     */
    public void bulletEnd() {
        mContext = null;
        mBitmapBullet.recycle();
    }

    /**
     * Y座標の取得
     */
    public float getY() {
        return mY;
    }

}
