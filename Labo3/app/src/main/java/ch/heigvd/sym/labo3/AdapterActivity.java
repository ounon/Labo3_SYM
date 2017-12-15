package ch.heigvd.sym.labo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Identifier;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by User on 13.12.2017.
 */

public class AdapterActivity extends BaseAdapter {

    private ArrayList<Beacon> beacons;
    private LayoutInflater inflater;


    public AdapterActivity(Context context){
        this.beacons = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void initAll(Collection<Beacon> newBeacons) {
        this.beacons.clear();
        this.beacons.addAll(newBeacons);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return beacons.size();
    }

    @Override
    public Beacon getItem(int position) {
        return beacons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_ibeacon, viewGroup, false);
        TextView txtIbeacon = (TextView) view.findViewById(R.id.text_ibeacon);
        Identifier id = beacons.iterator().next().getId1();
        Identifier major = beacons.iterator().next().getId2();
        Identifier minor = beacons.iterator().next().getId3();
        int rssi = beacons.iterator().next().getRssi();
        String txt = "Beacon " + id.toString() +
                     ", Major :" + major.toString() +
                     ", Minor :" + minor.toString() +
                     ", Rssi : " + rssi;
        txtIbeacon.setText(txt);
        return view;
    }
}