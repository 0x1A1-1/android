package com.example.practiceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cigarent on 6/11/16.
 */
public class myAdapter extends ArrayAdapter {

    public myAdapter(Context context, String[] shows) {
        super(context, R.layout.row_layout, shows);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View v = layoutInflater.inflate(R.layout.row_layout, parent, false);

        String tvShow = (String) getItem(position);

        ImageView imageView = (ImageView) v.findViewById(R.id.dotImage);

        imageView.setImageResource(R.drawable.dot);

        TextView textView = (TextView) v.findViewById(R.id.showNameText);

        textView.setText(tvShow);

        return v;
    }
}
