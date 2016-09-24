package jp.study.ndktest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

import jp.study.ndktest.Enemy.Enemy03;
import jp.study.ndktest.Enemy.EnemyManager;

/**
 * Created by ishitaku on 2016/09/15.
 */
public class Stage {
    //コンテキスト
    Context mContext = null;
    //プレイヤー
    private Player mPlayer = null;
    //背景
    private Background mBackgrounds[];
    private int VIEW_HEIGHT = 0;

    //弾
    private List<PlayerBullet> mPlayerBulletList;
    private final int BULLET_DUR = 8;  //発射間隔
    private int mBulletDurCount = 0;    //発射間隔カウント
    private boolean mBulletFlg = true;  //発射フラグ

    //敵の管理
    private EnemyManager mEnemyManager = null;

    /**
     * コンストラクタ
     */
    Stage(Context context) {
        mContext = context;
        //初期化処理
        stageInit();
    }

    /**
     * 初期化
     */
    private void stageInit() {
        VIEW_HEIGHT = mContext.getResources().getInteger(R.integer.view_height);
        mPlayer = new Player(mContext);
        //mBackground = new Background(mContext, R.drawable.background_01);
        mBackgrounds = new Background[2];
        mBackgrounds[0] = new Background(mContext, R.drawable.background_01, 0, 0);
        mBackgrounds[1] = new Background(mContext, R.drawable.background_02, 0, -(float)VIEW_HEIGHT);
        //Bulletリスト
        mPlayerBulletList = new ArrayList<>();
        mEnemyManager = new EnemyManager(mContext);
    }

    /**
     * 更新
     */
    public void stageUpdate(int inputx, int inputy, boolean ontouch) {
        //背景の更新
        updateBackground();

        mPlayer.playerUpdate(inputx, inputy, ontouch);

        //弾
        for(int i = 0; i < mPlayerBulletList.size(); i++) {
            mPlayerBulletList.get(i).bulletUpdate();
            if(mPlayerBulletList.get(i).getY() < 0) {

            }
        }

        //弾の発射
        if(ontouch && mBulletFlg) {
            mBulletFlg = false;
            mBulletDurCount = 0;
            mPlayerBulletList.add(new PlayerBullet(mContext, mPlayer.getX(), mPlayer.getY()));
        }

        mBulletDurCount++;
        //一定の間隔を超えたか
        if(mBulletDurCount > BULLET_DUR) {
            mBulletFlg = true;
            mBulletDurCount = 0;
        }

        //弾の削除
        if(mPlayerBulletList.size() > 0) {
            for(int i = mPlayerBulletList.size() - 1; i >= 0; i--) {
                if(mPlayerBulletList.get(i).getY() < 0) {
                    mPlayerBulletList.get(i).bulletEnd();
                    mPlayerBulletList.remove(i);
                }
            }
        }

        mEnemyManager.enemyManagerUpdate();
    }

    /**
     * 描画
     */
    public void stageDraw(Canvas canvas, Paint paint) {
        //背景
        for(int i = 0; i < mBackgrounds.length; i++) {
            mBackgrounds[i].backgroundDraw(canvas, paint);
        }
        //弾
        for(int i = 0; i < mPlayerBulletList.size(); i++) {
            mPlayerBulletList.get(i).bulletDraw(canvas, paint);
        }
        //プレイヤー
        mPlayer.playerDraw(canvas, paint);
        mEnemyManager.enemyManagerDraw(canvas, paint);
    }

    /**
     * 背景更新
     */
    private void updateBackground() {
        //背景の更新
        for(int i = 0; i < mBackgrounds.length; i++) {
            mBackgrounds[i].backgroundUpdate();
            //Log.d("Back"+i, ":"+mBackgrounds[i].getY());
            if(mBackgrounds[i].getY() > VIEW_HEIGHT) {
                mBackgrounds[i].setY(-(float)VIEW_HEIGHT);
            }
        }
    }

}
