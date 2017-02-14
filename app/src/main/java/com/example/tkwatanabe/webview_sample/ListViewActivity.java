package com.example.tkwatanabe.webview_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tkwatanabe on 2017/02/14.
 */

public class ListViewActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        //リスト項目をArrayListとして準備
        final ArrayList<String> data = new ArrayList<>();
        data.add("aaa");
        data.add("bbb");
        data.add("ccc");
        data.add("ddd");
        data.add("eee");
        data.add("fff");
        data.add("ggg");

        //配列アダプターを作成&ListViewに登録
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        ListView list = (ListView)findViewById(R.id.lst_view);
        list.setAdapter(adapter);

        //リスト項目をクリックした時の処理を定義
//        list.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        adapter.remove((String)((TextView)view).getText());
//                    }
//                }
//        );
        //リスト項目を長押しした時の処理を定義
        list.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    public boolean onItemLongClick(
                            AdapterView<?> av,
                            View view,
                            int position,
                            long id) {
                        adapter.remove((String)((TextView)view).getText());
                        return false;
                    }
                }
        );
    }

}
