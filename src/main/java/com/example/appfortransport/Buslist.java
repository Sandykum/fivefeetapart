package com.example.appfortransport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Buslist extends ArrayAdapter<Bus> {
    private Activity context;
    List<Bus> buses;

    public Buslist(Activity context, List<Bus> buses) {
        super(context, R.layout.layout_bus_list, buses);
        this.context = context;
        this.buses = buses;
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


        Bus bus = buses.get(position);
        textViewName.setText(bus.getBusName());
        textViewphone.setText(bus.getBusphone());
        textViewnumber.setText(bus.getBusno());
        textViewFrom.setText(bus.getBusFrom());
        textViewTo.setText(bus.getBusTo());



        return listViewItem;
    }
}