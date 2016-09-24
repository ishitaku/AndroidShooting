package jp.study.ndktest;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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
    private List<Bullet> mBulletList;
    private final int BULLET_DUR = 8;  //発射間隔
    private int mBulletDurCount = 0;    //発射間隔カウント
    private boolean mBulletFlg = true;  //発射フラグ

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
        mBulletList = new ArrayList<>();
    }

    /**
     * 更新
     */
    public void stageUpdate(int inputx, int inputy, boolean ontouch) {
        //背景の更新
        updateBackground();

        mPlayer.playerUpdate(inputx, inputy, ontouch);

        //弾
        for(int i = 0; i < mBulletList.size(); i++) {
            mBulletList.get(i).bulletUpdate();
            if(mBulletList.get(i).getY() < 0) {

            }
        }

        //弾の発射
        if(ontouch && mBulletFlg) {
            mBulletFlg = false;
            mBulletDurCount = 0;
            mBulletList.add(new Bullet(mContext, mPlayer.getX(), mPlayer.getY()));
        }

        mBulletDurCount++;
        //一定の間隔を超えたか
        if(mBulletDurCount > BULLET_DUR) {
            mBulletFlg = true;
            mBulletDurCount = 0;
        }

        //弾の削除
        if(mBulletList.size() > 0) {
            for(int i = mBulletList.size() - 1; i >= 0; i--) {
                if(mBulletList.get(i).getY() < 0) {
                    mBulletList.get(i).bulletEnd();
                    mBulletList.remove(i);
                }
            }
        }
    }

    /**
     * 描画
     */
    public void stageDraw(Canvas canvas) {
        //背景
        for(int i = 0; i < mBackgrounds.length; i++) {
            mBackgrounds[i].backgroundDraw(canvas);
        }
        //弾
        for(int i = 0; i < mBulletList.size(); i++) {
            mBulletList.get(i).bulletDraw(canvas);
        }
        //プレイヤー
        mPlayer.playerDraw(canvas);

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
