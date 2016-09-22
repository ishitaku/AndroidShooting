package jp.study.ndktest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends Activity {

    private CustomSurfaceView mSurfaceView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSurfaceView = new CustomSurfaceView(this);
        setContentView(mSurfaceView);
        //setContentView(R.layout.activity_main);

        //((TextView) findViewById(R.id.jni_msgView)).setText(getMsgFromJni());
    }


    static {
        System.loadLibrary("jnitest");
    }
    public native String getMsgFromJni();

}
