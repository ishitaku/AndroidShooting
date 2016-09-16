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
    private Bitmap mBitmapPlayer = null;
    private float mX = 0.0f;    //x座標
    private float mY = 0.0f;    //y座標
    private float mWidth = 0.0f;    //横幅
    private float mHeight = 0.0f;   //高さ

    /**
     * コンストラクタ
     * @param context
     */
    Player(Context context) {
        mBitmapPlayer = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
    }

    /**
     * 更新
     */
    public void playerUpdate () {

    }

    /**
     * 描画
     */
    public void playerDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmapPlayer, mX, mY, new Paint());
    }

}
