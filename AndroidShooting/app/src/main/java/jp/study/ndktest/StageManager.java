package jp.study.ndktest;

import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by ishitaku on 2016/09/15.
 */
/**
 * ステージを管理するクラス
 */
public class StageManager {
    //コンテキスト
    Context mContext = null;
    //ステージ
    Stage mStage = null;

    /**
     * コンストラクタ
     */
    StageManager(Context context) {
        mContext = context;
        stageManagerInit();
    }

    /**
     * 初期化
     */
    private void stageManagerInit() {
        //ステージの生成
        mStage = new Stage(mContext);
    }

    /**
     * 更新
     */
    public void stageManagerUpdate(int inputx, int inputy) {
        mStage.stageUpdate(inputx, inputy);
    }

    /**
     * 描画処理
     */
    public void stageManagerDraw(Canvas canvas) {
        mStage.stageDraw(canvas);
    }
}
