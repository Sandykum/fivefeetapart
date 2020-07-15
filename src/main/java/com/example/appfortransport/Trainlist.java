package com.example.appfortransport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Trainlist extends ArrayAdapter<Train> {
    private Activity context;
    List<Train> trains;

    public Trainlist(Activity context, List<Train> trains) {
        super(context, R.layout.layout_bus_list, trains);
        this.context = context;
        this.trains = trains;
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

        Train train = trains.get(position);
        textViewName.setText(train.getTrainName());
        textViewphone.setText(train.getTrainphone());
        textViewnumber.setText(train.getTrainno());
        textViewFrom.setText(train.getTrainFrom());
        textViewTo.setText(train.getTrainTo());

        return listViewItem;
    }
}
