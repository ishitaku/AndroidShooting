package jp.study.ndktest;

import android.graphics.Canvas;

/**
 * Created by ishitaku on 2016/09/14.
 */
public class MainGame {
    //ゲーム状態の列挙型
    private enum GameState {
        TITLE,
        GAMEPLAY,
        GAMEOVER
    }
    //ステート
    private GameState mGameState = GameState.TITLE;

    //タイトルコントロール
    private TitleCtrl mTitleCtrl = null;
    //ゲームプレイコントロール
    private GamePlayCtrl mGamePlayCtrl = null;
    /**
     * コンストラクタ
     */
    MainGame() {
        mGameState = GameState.TITLE;
    }

    public void gameUpdate() {
        switch (mGameState) {
            case TITLE:
                if(mTitleCtrl == null) {
                    mTitleCtrl = new TitleCtrl();
                }
                break;
            case GAMEPLAY:
                if(mGamePlayCtrl == null) {
                    mGamePlayCtrl = new GamePlayCtrl();
                }
        }
    }

    public void gameDraw(Canvas canvas) {
        switch (mGameState) {
            case TITLE:
                if(mTitleCtrl != null) {
                    mTitleCtrl.titleDraw(canvas);
                }
                break;
            case GAMEPLAY:
                if (mGamePlayCtrl != null){
                    mGamePlayCtrl.gamePlayDraw(canvas);
                }
                break;
            default:
                break;
        }
    }

}
