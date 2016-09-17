package jp.study.ndktest;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

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
    }

    /**
     * 更新
     */
    public void stageUpdate(int inputx, int inputy) {
        for(int i = 0; i < mBackgrounds.length; i++) {
            mBackgrounds[i].backgroundUpdate();
            //Log.d("Back"+i, ":"+mBackgrounds[i].getY());
            if(mBackgrounds[i].getY() > VIEW_HEIGHT) {
                mBackgrounds[i].setY(-(float)VIEW_HEIGHT);
            }
        }

        mPlayer.playerUpdate(inputx, inputy);
    }

    /**
     * 描画
     */
    public void stageDraw(Canvas canvas) {
        for(int i = 0; i < mBackgrounds.length; i++) {
            mBackgrounds[i].backgroundDraw(canvas);
        }
        mPlayer.playerDraw(canvas);

    }
}
