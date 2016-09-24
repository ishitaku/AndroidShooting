package jp.study.ndktest.Enemy;

/**
 * Created by ishitaku on 2016/09/24.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import jp.study.ndktest.R;

/**
 * 敵の管理
 */
public class EnemyManager {
    //コンテキスト
    private Context mContext = null;
    private int VIEW_HEIGHT;

    private Enemy03 mEnemy3 = null;

    /**
     * コンストラクタ
     */
    public EnemyManager(Context context) {
        mContext = context;
        enemyManagerInit();
    }

    /**
     * 初期化
     */
    private void enemyManagerInit() {
        VIEW_HEIGHT = mContext.getResources().getInteger(R.integer.view_height);
        mEnemy3 = new Enemy03(mContext, 300, -mContext.getResources().getInteger(R.integer.enemy03_height)/2);
    }

    /**
     * 更新
     */
    public void enemyManagerUpdate() {
        if(mEnemy3 == null) {
            return;
        }

        mEnemy3.enemyUpdate();
        if(mEnemy3.getY() > VIEW_HEIGHT) {
            mEnemy3.setY(0);
        }
    }

    /**
     * 描画
     */
    public void enemyManagerDraw(Canvas canvas, Paint paint) {
        if(mEnemy3 == null) {
            return;
        }
        mEnemy3.enemyDraw(canvas, paint);
    }

}
