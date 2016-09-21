package jp.study.ndktest;

/**
 * Created by ishitaku on 2016/09/15.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

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
        mHeight = mContext.getResources().getInteger(R.integer.view_height);;
    }

    /**
     * 更新
     */
    public void playerUpdate (int inputx, int inputy) {
        mX += inputx;
        mY += inputy;
        if(mX + mWidth > VIEW_WIDTH) {
            mX = VIEW_WIDTH - mWidth;
        }
        if(mX < 0) {
            mX = 0;
        }
        if(mY + mHeight > VIEW_HEIGHT){
            mY = VIEW_HEIGHT - mHeight;
        }
        if(mY < 0) {
            mY = 0;
        }

    }

    /**
     * 描画
     */
    public void playerDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmapPlayer, mX, mY, new Paint());
    }

}
