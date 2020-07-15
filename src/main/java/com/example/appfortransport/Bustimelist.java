package com.example.appfortransport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Bustimelist extends ArrayAdapter<Bustime> {
    private Activity context;
    List<Bustime> busestime;

    public Bustimelist(Activity context, List<Bustime> busestime) {
        super(context, R.layout.layout_bustime_list, busestime);
        this.context = context;
        this.busestime = busestime;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_bustime_list, null, true);

        TextView textViewbusstop1 = (TextView) listViewItem.findViewById(R.id.textViewbusstop1);
        TextView textViewbusstoptime1 = (TextView) listViewItem.findViewById(R.id.textViewbusstoptime1);
        TextView textViewbusstop2 = (TextView) listViewItem.findViewById(R.id.textViewbusstop2);
        TextView textViewbusstoptime2 = (TextView) listViewItem.findViewById(R.id.textViewbusstoptime2);
        TextView textViewbusstop3 = (TextView) listViewItem.findViewById(R.id.textViewbusstop3);
        TextView textViewbusstoptime3 = (TextView) listViewItem.findViewById(R.id.textViewbusstoptime3);

        Bustime bustime = busestime.get(position);
        textViewbusstop1.setText(bustime.getBusstop1());
        textViewbusstoptime1.setText(bustime.getBusstoptime1());
        textViewbusstop2.setText(bustime.getBusstop2());
        textViewbusstoptime2.setText(bustime.getBusstoptime2());
        textViewbusstop3.setText(bustime.getBusstop3());
        textViewbusstoptime3.setText(bustime.getBusstoptime3());

        return listViewItem;
    }
}
