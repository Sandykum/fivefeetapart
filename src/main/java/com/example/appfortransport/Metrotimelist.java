package com.example.appfortransport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Metrotimelist extends ArrayAdapter<Metrotime> {
    private Activity context;
    List<Metrotime> metrostime;

    public Metrotimelist(Activity context, List<Metrotime> metrostime) {
        super(context, R.layout.layout_bustime_list, metrostime);
        this.context = context;
        this.metrostime = metrostime;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_bustime_list, null, true);

        TextView textViewmetrostop1 = (TextView) listViewItem.findViewById(R.id.textViewbusstop1);
        TextView textViewmetrostoptime1 = (TextView) listViewItem.findViewById(R.id.textViewbusstoptime1);
        TextView textViewmetrostop2 = (TextView) listViewItem.findViewById(R.id.textViewbusstop2);
        TextView textViewmetrostoptime2 = (TextView) listViewItem.findViewById(R.id.textViewbusstoptime2);
        TextView textViewmetrostop3 = (TextView) listViewItem.findViewById(R.id.textViewbusstop3);
        TextView textViewmetrostoptime3 = (TextView) listViewItem.findViewById(R.id.textViewbusstoptime3);

        Metrotime metrotime = metrostime.get(position);
        textViewmetrostop1.setText(metrotime.getMetrostop1());
        textViewmetrostoptime1.setText(metrotime.getMetrostoptime1());
        textViewmetrostop2.setText(metrotime.getMetrostop2());
        textViewmetrostoptime2.setText(metrotime.getMetrostoptime2());
        textViewmetrostop3.setText(metrotime.getMetrostop3());
        textViewmetrostoptime3.setText(metrotime.getMetrostoptime3());

        return listViewItem;
    }
}
