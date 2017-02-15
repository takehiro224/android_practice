package com.example.tkwatanabe.webview_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //ボタンクリック時の処理
    public void btn_onclick(View v) {
        WebView wv = (WebView)findViewById(R.id.wv);
        //クリックされたボタンに応じてページを読み込む
        switch (v.getId()) {
            case R.id.btnHome:
                wv.loadUrl("http://www.wings.msn.to/");
                break;
            case R.id.btnBbs:
                wv.loadUrl("http://keijiban.msn.to/top.jsp?id=gr7638");
                break;
            case R.id.btnHelp:
                wv.loadUrl("http://www.wings.msn.to/index.php/-/A-08/");
                break;
            default:
                break;
        }
    }

}
