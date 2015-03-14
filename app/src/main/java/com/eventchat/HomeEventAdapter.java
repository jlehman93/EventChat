package com.eventchat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jacob on 3/14/2015.
 */
public class HomeEventAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> data;
    private static LayoutInflater inflater = null;
   // private pictureCategoryModel pcm = new pictureCategoryModel();
    //private HashMap<String, String> hm = new HashMap<>();
    private ArrayList<String> cat;
    private PictureGetter pg = new PictureGetter();


    public HomeEventAdapter(Context context, int resource, ArrayList<String> data) {
        // TODO Auto-generated constructor stub
        super(context, resource, data);
        this.context = context;
        this.data = data;

    }

    public void setCat(ArrayList<String> category){
        cat = category;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.home_events, null);
        }

        TextView firstLine = (TextView) vi.findViewById(R.id.firstLine);
        firstLine.setText(data.get(position));

        TextView secondLine = (TextView) vi.findViewById(R.id.secondLine);
        secondLine.setText(data.get(position));

        String uri = cat.get(position);
//

        int imageResource = context.getResources().getIdentifier(pg.getPicture(uri), null, context.getPackageName());
        try {
            ImageView imageview = (ImageView)vi.findViewById(R.id.category_icon);
            Drawable res = context.getResources().getDrawable(imageResource);
            imageview.setImageDrawable(res);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return vi;
    }

}
