package com.example.tkwatanabe.webview_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by tkwatanabe on 2017/02/17.
 */

public class SearchListViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchlist_main);

        //(1)リスト項目をArrayListとして準備
        ArrayList<String> data = new ArrayList<>();
        data.add("胡椒");
        data.add("ターメリック");
        data.add("コリアンダー");
        data.add("生姜");
        data.add("ニンニク");
        data.add("サフラン");

        //(2)配列アダプターを作成 & ListViewに登録
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );
        final ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        //(3)フィルター機能を有効化
        list.setTextFilterEnabled(true);

        //(4)検索ボックスに入力された時の処理を定義
        SearchView sv = (SearchView) findViewById(R.id.search);
        sv.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override //サブミットボタンをクリックした時
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override //検索ボックスの内容が変化した時
                    public boolean onQueryTextChange(String newText) {
                        if(newText == null || newText.equals("")) {
                            list.clearTextFilter();
                        } else {
                            list.setFilterText(newText);
                        }
                        return false;
                    }
                }
        );
    }
}
