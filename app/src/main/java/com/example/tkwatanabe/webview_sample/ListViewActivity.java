package com.example.tkwatanabe.webview_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tkwatanabe on 2017/02/14.
 */

public class ListViewActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ListView list;

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
        data.add("hhh");
        data.add("iii");
        data.add("jjj");
        data.add("kkk");
        data.add("lll");
        data.add("mmm");
        data.add("nnn");
        data.add("ooo");
        data.add("ppp");
        data.add("qqq");
        data.add("rrr");
        data.add("sss");
        data.add("ttt");
        data.add("uuu");
        data.add("vvv");
        data.add("www");
        data.add("xxx");
        data.add("yyy");
        data.add("zzz");

        //配列アダプターを作成&ListViewに登録
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, data); //単一選択可能なリスト
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, data); //複数選択可能なリスト、リスト項目にチェックボックスを追加するためのレイアウト
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, data); //専用の選択画面を持ったリスト
        list = (ListView)findViewById(R.id.lst_view);
        list.setAdapter(adapter);

        //リスト項目をクリックした時の処理を定義
//        list.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        adapter.remove((String)((TextView)view).getText());
//                        Toast.makeText(ListViewActivity.this, (String)((TextView)view).getText(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
        //リスト項目を長押しした時の処理を定義
//        list.setOnItemLongClickListener(
//                new AdapterView.OnItemLongClickListener() {
//                    public boolean onItemLongClick(
//                            AdapterView<?> av, //選択されたリストの親となるウィジット。ここではListView
//                            View view, //選択された項目
//                            int position, //選択された項目の位置
//                            long id) { //選択された項目のidの値
//                        adapter.remove((String)((TextView)view).getText());
//                        return false;
//                    }
//                }
//        );
        //リスト項目をクリックした時の処理を定義(単一選択可能)
//        list.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    public void onItemClick(AdapterView<?> av, View view, int position, long id) {
//                        CharSequence msg = ((TextView) view).getText();
//                        Toast.makeText(ListViewActivity.this,
//                                String.format("選択したのは%s", msg.toString()),
//                                Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
        //リスト項目をクリックした時の処理を定義(複数選択可能) android:choiceMode="multipleChoice"
//        list.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    public void onItemClick(AdapterView<?> av, View view, int position, long id) {
//                        String msg = "選択したのは、";
//                        for(int i = 0; i < list.getChildCount(); i++) { //ListView配下の項目数を取得「getChildCount」
//                            //複数選択可能なリストはCheckedTextViewとして表される。
//                            CheckedTextView check = (CheckedTextView) list.getChildAt(i); //ListView配下の指定の項目を取得する「getChildAt」
//                            if(check.isChecked()) {
//                                msg += check.getText() + ","; //getText()で項目テキストを取得できる。
//                            }
//                        }
//                        msg = msg.substring(0, msg.length() - 1);
//                        Toast.makeText(ListViewActivity.this, msg, Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
        //専用の選択画面を持ったリスト
//        list.setMultiChoiceModeListener(
//                new AbsListView.MultiChoiceModeListener() {
//                    @Override //選択項目のチェック状態が変化した時
//                    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
//                    }
//                    @Override //アクションモードを起動する時
//                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//                        return true;
//                    }
//                    @Override //アクションモードの準備時
//                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//                        return true;
//                    }
//                    @Override //項目をクリッルした時
//                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//                        return true;
//                    }
//                    @Override //アクションモードを終了した時
//                    public void onDestroyActionMode(ActionMode mode) {
//                        String msg = "選択したのは";
//                        //チェック状態の項目だけを追加
//                        for(int i = 0; i < list.getChildCount(); i++) {
//                            CheckedTextView check = (CheckedTextView) list.getChildAt(i);
//                            if(check.isChecked()) {
//                                msg += check.getText() + ",";
//                            }
//                        }
//                        msg = msg.substring(0, msg.length() - 1);
//                        Toast.makeText(ListViewActivity.this, msg, Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
        //リストのスクロールイベントリスナー
//        list.setOnScrollListener(
//                new AbsListView.OnScrollListener() {
//                    public void onScroll(
//                            AbsListView av, //スクロールするビュー
//                            int firstVisibleItem, //項目の先頭インデックス
//                            int visibleItemCount, //表示する項目数
//                            int totalItemCount //項目の総数
//                    ) {
//                        //「firstVisibleItem + visibleItemCount」現在表示されている項目の末尾
//                        //表示中のリストの3項目先がリストの最終項目か
//                        if(firstVisibleItem + visibleItemCount + 3 == totalItemCount) {
//                            adapter.add("AAA");
//                            adapter.add("BBB");
//                            adapter.add("CCC");
//                        }
//                    }
//                    public void onScrollStateChanged(AbsListView arg0, int arg1) {}
//                }
//        );
        /*
        リストカスタムレイアウト
         */
        //(1)リストに表示するデータ
        String titles[] = {"Java", "JavaScript", "HTML", "CSS", "Swift"};
        String tags[] = {"language", "language", "markup", "meta", "language"};
        String descs[] = {"aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"};
        // 配列の内容をHashMapに詰め替え
        ArrayList<HashMap<String, String>> cldata = new ArrayList<>();
        for(int i = 0; i < titles.length; i ++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("title", titles[i]);
            item.put("tag", tags[i]);
            item.put("desc", descs[i]);
            cldata.add(item);
        }
        //(2)HashMap配列とレイアウトの関連付け
        SimpleAdapter sadapter = new SimpleAdapter(
                this,
                cldata,
                R.layout.list_item,
                new String[] {"title", "tag", "desc"},
                new int[] {R.id.title, R.id.tag, R.id.desc}
        );
        //(3)アダプターをもとにリストを生成
        ListView customList = (ListView) findViewById(R.id.lst_view);
        customList.setAdapter(sadapter);
    }
}
