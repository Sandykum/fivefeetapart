package com.example.appfortransport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Traintimelist extends ArrayAdapter<Traintime> {
    private Activity context;
    List<Traintime> trainstime;

    public Traintimelist(Activity context, List<Traintime> trainstime) {
        super(context, R.layout.layout_bustime_list, trainstime);
        this.context = context;
        this.trainstime = trainstime;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_bustime_list, null, true);

        TextView textViewtrainstop1 = (TextView) listViewItem.findViewById(R.id.textViewbusstop1);
        TextView textViewtrainstoptime1 = (TextView) listViewItem.findViewById(R.id.textViewbusstoptime1);
        TextView textViewtrainstop2 = (TextView) listViewItem.findViewById(R.id.textViewbusstop2);
        TextView textViewtrainstoptime2 = (TextView) listViewItem.findViewById(R.id.textViewbusstoptime2);
        TextView textViewtrainstop3 = (TextView) listViewItem.findViewById(R.id.textViewbusstop3);
        TextView textViewtrainstoptime3 = (TextView) listViewItem.findViewById(R.id.textViewbusstoptime3);

        Traintime traintime = trainstime.get(position);
        textViewtrainstop1.setText(traintime.getTrainstop1());
        textViewtrainstoptime1.setText(traintime.getTrainstoptime1());
        textViewtrainstop2.setText(traintime.getTrainstop2());
        textViewtrainstoptime2.setText(traintime.getTrainstoptime2());
        textViewtrainstop3.setText(traintime.getTrainstop3());
        textViewtrainstoptime3.setText(traintime.getTrainstoptime3());

        return listViewItem;
    }
}
