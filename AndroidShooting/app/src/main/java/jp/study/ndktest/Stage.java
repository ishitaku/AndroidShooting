package jp.study.ndktest;

import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by ishitaku on 2016/09/15.
 */
public class Stage {
    //コンテキスト
    Context mContext = null;
    //プレイヤー
    private Player mPlayer = null;

    /**
     * コンストラクタ
     */
    Stage(Context context) {
        mContext = context;
        stageInit();
    }

    /**
     * 初期化
     */
    private void stageInit() {
        mPlayer = new Player(mContext);
    }

    /**
     * 更新
     */
    private void stageUpdate() {

    }

    /**
     * 描画
     */
    public void stageDraw(Canvas canvas) {
        mPlayer.playerDraw(canvas);
    }
}
