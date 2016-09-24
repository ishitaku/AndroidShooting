package jp.study.ndktest.Enemy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import jp.study.ndktest.R;

/**
 * Created by ishitaku on 2016/09/24.
 */
public class Enemy03 extends Enemy_base {

    //ビットマップ
    private Bitmap mEnemyBitmap = null;
    private float mDy = 5;
    private float rad = 0;
    private float mBaseX = 0;

    //コンストラクタ
    public Enemy03(Context context, float x, float y) {
        super(context, x, y);
        enemyInit();
    }

    private void enemyInit() {
        mBitmapWidth = mContext.getResources().getInteger(R.integer.enemy03_width);
        mBitmapHeight = mContext.getResources().getInteger(R.integer.enemy03_height);
        mEnemyBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.enemy03);
        mBaseX = mX;
    }

    @Override
    public void enemyUpdate() {
        mY += mDy;
        rad += 0.05;
        if(rad > 360) {
            rad -= 360;
        }
        mX = mBaseX + (float)Math.sin(rad)*150;
    }

    @Override
    public void enemyDraw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(mEnemyBitmap, mX - mWidth/2, mY - mHeight/2, paint);
    }

    @Override
    public void enemyEnd() {
        mEnemyBitmap.recycle();
        mContext = null;
    }
}
