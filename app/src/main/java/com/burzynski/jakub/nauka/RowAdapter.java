package com.burzynski.jakub.nauka;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by student on 25.04.2017.
 */

public class RowAdapter extends ArrayAdapter<TelefonRow> {

    Context context;
    int layoutResourceId;
    TelefonRow data[] = null;

    public RowAdapter(Context context, int layoutResourceId, TelefonRow[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RowBeanHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RowBeanHolder();
            holder.txtTitle = (TextView)row.findViewById(R.id.textView6);
            holder.txtTitle = (TextView)row.findViewById(R.id.textView35);

            row.setTag(holder);
        }
        else
        {
            holder = (RowBeanHolder)row.getTag();
        }

        TelefonRow object = data[position];
        holder.txtTitle.setText(object.imie);
        holder.txtTitle.setText(object.telefon);

        return row;
    }

    static class RowBeanHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
}