package com.example.appfortransport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Metrolist extends ArrayAdapter<Metro> {
    private Activity context;
    List<Metro> metros;

    public Metrolist(Activity context, List<Metro> metros) {
        super(context, R.layout.layout_metro_list, metros);
        this.context = context;
        this.metros = metros;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_bus_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewphone = (TextView) listViewItem.findViewById(R.id.textViewphone);
        TextView textViewnumber = (TextView) listViewItem.findViewById(R.id.textViewnumber);
        TextView textViewFrom = (TextView) listViewItem.findViewById(R.id.textViewFrom);
        TextView textViewTo = (TextView) listViewItem.findViewById(R.id.textViewTo);

        Metro metro = metros.get(position);
        textViewName.setText(metro.getMetroName());
        textViewphone.setText(metro.getMetrophone());
        textViewnumber.setText(metro.getMetrono());
        textViewFrom.setText(metro.getMetroFrom());
        textViewTo.setText(metro.getMetroTo());

        return listViewItem;
    }
}