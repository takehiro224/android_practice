package com.example.tkwatanabe.webview_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by tkwatanabe on 2017/02/15.
 */

public class DialogFragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_main);
    }

    //削除ダイアログようクリックイベントリスナー
    public void btn_dialog_onClick(View v) {
        IPDialogFragment dialog = new IPDialogFragment();
        dialog.show(getFragmentManager(), "sample");
    }

    public void toastShow(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
