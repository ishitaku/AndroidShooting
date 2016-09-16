package jp.study.ndktest;

/**
 * Created by ishitaku on 2016/09/14.
 */

import android.content.Context;
import android.graphics.Canvas;

/**
 * ゲームプレイコントロール
 */
public class GamePlayCtrl {
    //コンテキスト
    Context mContext = null;
    //ステージマネージャー
    StageManager mStageManager = null;

    /**
     * コンストラクタ
     */
    GamePlayCtrl(Context context) {
        mContext = context;
        gamePlayInit();
    }

    /**
     * 初期化処理
     */
    private void gamePlayInit() {
        //ステージマネージャーの生成
        mStageManager = new StageManager(mContext);
    }

    /**
     * 更新処理
     */
    public void gamePlayUpdate() {

    }
    /**
     * 描画処理
     */
    public void gamePlayDraw(Canvas canvas) {
        mStageManager.stageManagerDraw(canvas);
    }

    /**
     * 終了処理
     */
    public void gamePlayEnd() {

    }
}
