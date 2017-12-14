package ch.heigvd.sym.labo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Identifier;

import java.util.Collection;

/**
 * Created by User on 13.12.2017.
 */

public class AdapterActivity extends BaseAdapter {

    Collection<Beacon> beacons;
    Context context;
    LayoutInflater inflater;


    public AdapterActivity(Context applicationContext, Collection<Beacon> beacons){
        this.beacons = beacons;
        this.context = applicationContext;
        inflater = (LayoutInflater.from(applicationContext));
    }

    public void initAll(Collection<Beacon> newBeacons) {
        this.beacons.clear();
        this.beacons.addAll(newBeacons);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_ibeaconlist, null);
        TextView txtIbeacon = (TextView) view.findViewById(R.id.text_ibeacon);
        Identifier txt = beacons.iterator().next().getId2();
        txtIbeacon.setText(txt.toString());
        return view;
    }
}
