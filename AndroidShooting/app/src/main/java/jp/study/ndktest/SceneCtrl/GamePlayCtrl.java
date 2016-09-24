package jp.study.ndktest.SceneCtrl;

/**
 * Created by ishitaku on 2016/09/14.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import jp.study.ndktest.StageManager;

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
    public GamePlayCtrl(Context context) {
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
    public void gamePlayUpdate(int inputx, int inputy, boolean ontouch) {
        mStageManager.stageManagerUpdate(inputx, inputy, ontouch);
    }
    /**
     * 描画処理
     */
    public void gamePlayDraw(Canvas canvas, Paint paint) {
        mStageManager.stageManagerDraw(canvas, paint);

    }

    /**
     * 終了処理
     */
    public void gamePlayEnd() {

    }
}
