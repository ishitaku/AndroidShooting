package jp.study.ndktest;

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
        }
    }

}
