package jp.study.ndktest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import jp.study.ndktest.SceneCtrl.GamePlayCtrl;
import jp.study.ndktest.SceneCtrl.TitleCtrl;

/**
 * Created by ishitaku on 2016/09/14.
 */
public class MainGame {
    //コンテキスト
    private Context mContext = null;
    //ペイント
    private Paint mPaint = null;
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
    public MainGame(Context context) {
        //mGameState = GameState.TITLE;
        mGameState = GameState.GAMEPLAY;
        mContext = context;
        mPaint = new Paint();
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
                    mTitleCtrl.titleDraw(canvas, mPaint);
                }
                break;
            case GAMEPLAY:
                if (mGamePlayCtrl != null){
                    mGamePlayCtrl.gamePlayDraw(canvas, mPaint);
                }
                break;
            default:
                break;
        }
    }

}
