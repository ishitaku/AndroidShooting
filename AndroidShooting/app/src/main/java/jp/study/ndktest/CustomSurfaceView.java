package jp.study.ndktest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by ishitaku on 2016/09/06.
 */
public class CustomSurfaceView extends SurfaceView {

    private CustomSurfaceHolder mCustomSurfaceHolder = null;

    CustomSurfaceView(Context context) {
        super(context);
        mCustomSurfaceHolder = new CustomSurfaceHolder();
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(mCustomSurfaceHolder);
    }

    CustomSurfaceView(Context context, AttributeSet attr) {
        super(context, attr);
    }
}
