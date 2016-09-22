package jp.study.ndktest;

import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by ishitaku on 2016/09/14.
 */
public class MainGame {
    //コンテキスト
    Context mContext = null;

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
    MainGame(Context context) {
        //mGameState = GameState.TITLE;
        mGameState = GameState.GAMEPLAY;
        mContext = context;
    }

    public void gameUpdate(int inputx, int inputy, boolean ontouch) {
        switch (mGameState) {
            case TITLE:
                if(mTitleCtrl == null) {
                    mTitleCtrl = new TitleCtrl(mContext);
                }
                break;
            case GAMEPLAY:
                if(mGamePlayCtrl == null) {
                    mGamePlayCtrl = new GamePlayCtrl(mContext);
                }
                //更新処理
                mGamePlayCtrl.gamePlayUpdate(inputx, inputy, ontouch);
                break;
            default:
                break;
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
