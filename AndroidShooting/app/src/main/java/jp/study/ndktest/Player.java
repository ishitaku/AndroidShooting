package jp.study.ndktest;

/**
 * Created by ishitaku on 2016/09/15.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

/**
 * プレイヤークラス
 */
public class Player {
    //コンテキスト
    Context mContext = null;
    private Bitmap mBitmapPlayer = null;
    private float mX = 0.0f;    //x座標
    private float mY = 0.0f;    //y座標
    private float mWidth = 0.0f;    //横幅
    private float mHeight = 0.0f;   //高さ
    private int VIEW_HEIGHT = 0;
    private int VIEW_WIDTH = 0;

    /**
     * コンストラクタ
     * @param context
     */
    Player(Context context) {
        mContext = context;
        playerInit();
    }

    /**
     * 初期化処理
     */
    private void playerInit() {
        mBitmapPlayer = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.player);
        //高さを設定
        VIEW_HEIGHT = mContext.getResources().getInteger(R.integer.view_height);
        //幅を設定
        VIEW_WIDTH = mContext.getResources().getInteger(R.integer.view_width);
        mWidth = mContext.getResources().getInteger(R.integer.player_width);
        mHeight = mContext.getResources().getInteger(R.integer.player_height);

    }

    /**
     * 更新
     */
    public void playerUpdate (int inputx, int inputy, boolean ontouch) {
        mX += inputx;
        mY += inputy;
        if(mX + mWidth/2 > VIEW_WIDTH) {
            mX = VIEW_WIDTH - mWidth/2;
        }
        if(mX - mWidth/2 < 0) {
            mX = mWidth/2;
        }
        if(mY + mHeight/2 > VIEW_HEIGHT){
            mY = VIEW_HEIGHT - mHeight/2;
        }
        if(mY - mHeight/2 < 0) {
            mY = mHeight / 2;
        }

    }

    /**
     * 描画
     */
    public void playerDraw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(mBitmapPlayer, mX - mWidth/2, mY - mHeight/2, paint);
    }

    /**
     * x座標の取得
     */
    public float getX() {
        return mX;
    }

    /**
     * x座標の取得
     */
    public float getY() {
        return mY;
    }

}
