package jp.study.ndktest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.wifi.WifiManager;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by ishitaku on 2016/09/17.
 */
public class Background {
    //コンテキスト
    Context mContext = null;
    //Bitmap
    private Bitmap mBitmapBackground = null;
    //
    private float mX = 0.0f;    //x座標
    private float mY = 0.0f;    //y座標
    private float mDY = 5.0f;   //移動量
    private int VIEW_HEIGHT = 0;

    private int mResource;

    /**
     * コンストラクタ
     */
    Background(Context context, int resource, float x, float y) {
        mContext = context;
        mResource = resource;
        mX = x;
        mY = y;
        //初期化処理
        backgroundInit();
    }

    /**
     * 初期化処理
     */
    private void backgroundInit() {
        //Bitmapを取得
        mBitmapBackground = BitmapFactory.decodeResource(mContext.getResources(), mResource);
        //VIEW_HEIGHT = mContext.getResources().getInteger(R.integer.view_height);
    }

    /**
     * 更新
     */
    public void backgroundUpdate () {

        mY += mDY;
        /*
        if(mY > VIEW_HEIGHT) {
            mY = 0.0f;
        }*/
    }

    /**
     * 描画
     */
    public void backgroundDraw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(mBitmapBackground, mX, mY, paint);
    }

    /**
     * x座標を取得
     */
    public float getX() {
        return  mX;
    }

    /**
     * y座標を取得
     */
    public float getY() {
        return mY;
    }

    /**
     * x座標を設定
     */
    public void setX(float x) {
        mX = x;
    }

    /**
     * y座標を設定
     */
    public void setY(float y) {
        mY = y;
    }

}
