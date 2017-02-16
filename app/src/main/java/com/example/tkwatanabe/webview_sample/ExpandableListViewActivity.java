package com.example.tkwatanabe.webview_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tkwatanabe on 2017/02/16.
 */

public class ExpandableListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.expandablelist_main);
        //親項目、子項目を準備
        String[] g_titles = {"金管", "木管", "弦"};
        String[][][] c_titles = {
                {
                        {"トランペット", "高音域の出る金管楽器"},
                        {"トロンボーン", "長いU字型の菅をつなぎ合わせた形の金管楽器"},
                        {"チューバ", "大型で低音域の出る金管楽器"}
                },
                {
                        {"クラリネット", "音域の広い木管楽器"},
                        {"ファゴット", "低音域の木管楽器"},
                        {"オーボエ", "2枚リードで高音域の木管楽器"}
                },
                {
                        {"バイオリン", "高音域の絃楽器"},
                        {"ビオラ", "中音域の絃楽器"},
                        {"チェロ", "大型の低音域の絃楽器"}
                }
        };
        ExpandableListView elv = (ExpandableListView)findViewById(R.id.elv);
        //(1)アダプターに渡すためのリストを準備
        List<Map<String, String>> g_list = new ArrayList<>();
        List<List<Map<String, String>>> c_list = new ArrayList<>();
        //配列g_titlesをHashMapに詰め替え(キーはgroup_title)
        for(int i = 0; i < g_titles.length; i++) {
            HashMap<String, String> group = new HashMap<>();
            group.put("group_title", g_titles[i]);
            g_list.add(group);

            List<Map<String, String>> childs = new ArrayList<>();
            //配列c_titlesの内容をHashMap(child)に詰め替え&リストchildsに追加
            for(int j = 0; j < c_titles.length; j++) {
                HashMap<String, String> child = new HashMap<>();
                child.put("child_title", c_titles[i][j][0]);
                child.put("child_text", c_titles[i][j][1]);
                childs.add(child);
            }
            //リストc_listに追加
            c_list.add(childs);
        }
        //(2)アダプターを準備&設定
        //ToはFromで指定したキーの値をレイアウトのどのTextViewで表示するのかを表す
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, //コンテキスト
                g_list, //親項目のリスト
                android.R.layout.simple_expandable_list_item_1, //親項目を表示するためのリスト
                new String[]{"group_title"}, //親項目で表示するHashMapのキー
                new int[]{android.R.id.text1}, //値を表示するためのTextViewのidの値
                c_list,
                R.layout.list_sub,
                new String[]{"child_title", "child_text"},
                new int[]{R.id.text1,R.id.text2}
        );
        elv.setAdapter(adapter);
        //(3)子項目をクリックした際の処理
        elv.setOnChildClickListener(
                new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        //クリックされた子項目を取得&トースト
                        TextView txt = (TextView)findViewById(R.id.text1);
                        Toast.makeText(getApplicationContext(), txt.getText(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
        );
    }
}
