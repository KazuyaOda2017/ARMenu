package com.example.kazuya.armenu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Created by Kazuya on 2017/08/21.
 */

public class MenuIconInfo {

    //region 変数
    private  Context mContext;
    private LayoutInflater mLayoutInflater;
    private Intent intent;
    //endregion

    //region icon名
    private String[] iconName = {
      "ARCamera",
            "TEST"
    };
    //endregion

    //region icon画像
    private Integer[] iconImage ={
      R.drawable.icon_arcamera,
            R.drawable.icon_arcamera
    };

    //endregion

    private  Object[] nextActivityClass ={
            Next.class,
            Next2.class
    };

    //region コンストラクター
    public MenuIconInfo(){

    }

    public MenuIconInfo(Context contect){
        mContext = contect;
        mLayoutInflater = LayoutInflater.from(contect);
    }
    //endregion

    public Object getNextActivity(int position){
        return nextActivityClass[position];
    }

    //region Overrid
    public int getCountIcon() {
        return iconImage.length;
    }

    //アイコン画像取得
    public Object getItem(int position) {
        return iconImage[position];
    }

    //アイコン名取得
    public String getIconName(int position){
        return iconName[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
    //endregion

    //region icon名とicon画像のHashMapを取得

    public static class ViewHolder{
        public ImageView hueImageView;

    }

    public void getIconView(){
        ViewHolder holder;
        View convertView;
        for(int i = 0; i < iconImage.length; i++){
            try{
                convertView = mLayoutInflater.inflate(R.layout.menuicon_layout, null);
                holder = new ViewHolder();
                holder.hueImageView = (ImageView)convertView.findViewById(R.id.icon_image);
                convertView.setTag(holder);
            }catch (Exception e){

            }
        }
    }


    //endregion
}
