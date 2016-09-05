package jp.study.ndktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.jni_msgView)).setText(getMsgFromJni());
    }

    static {
        System.loadLibrary("jnitest");
    }
    public native String getMsgFromJni();

}
