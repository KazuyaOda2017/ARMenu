package com.example.kazuya.armenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //上部TableLayoutを設定
        ViewGroup vg = (ViewGroup)findViewById(R.id.table_menu_top);

        MenuIconInfo menuIconInfo = new MenuIconInfo(this);

       //行をicon分追加する
        int row = 0;
        for (int i = 0; i < menuIconInfo.getCountIcon(); i++) {
            //TableRowを取得
            getLayoutInflater().inflate(R.layout.tablerow_layout,vg);
            //row行目を取得
            TableRow trindex = (TableRow)vg.getChildAt(row);
            //Viewを取得
            LinearLayout layout = (LinearLayout)trindex.getChildAt(i);
            //TextView(アイコン名)を設定
            TextView textView = (TextView)(layout.findViewById(R.id.text_icon_name));
            textView.setText(menuIconInfo.getIconName(i));
            //ImageButtonを設定
            ImageButton imageButton = (ImageButton)(layout.findViewById(R.id.icon_image));
            imageButton.setImageResource((Integer)menuIconInfo.getItem(i));
            //遷移先クラスを設定
            Intent intent = new Intent(getApplication(), (Class<?>) menuIconInfo.getNextActivity(i));
            imageButton.setTag(intent);
            //ボタンを可視化する
            trindex.getChildAt(i).setVisibility(View.VISIBLE);

            //リスナーに登録
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Tagに設定された遷移先を取得して画面遷移をする
                    Intent intent_new = (Intent)v.getTag();
                    startActivity(intent_new);
                }
            });
        }



    }
}
