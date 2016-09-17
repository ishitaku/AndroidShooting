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

    }

    /**
     * 更新
     */
    public void playerUpdate (int inputx, int inputy) {
        mX += inputx;
        mY += inputy;
    }

    /**
     * 描画
     */
    public void playerDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmapPlayer, mX, mY, new Paint());
    }

}
