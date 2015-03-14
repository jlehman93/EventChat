package com.eventchat;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Jacob on 3/14/2015.
 */
public class EventCategoriesFragment extends DialogFragment {

    Activity mActivity;
    ListView categoryListView;
    ArrayAdapter<String> aa;
    EventCategoriesModel ecm = new EventCategoriesModel();


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        categoryListView = (ListView)getView().findViewById(R.id.categories_listView);
        aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, ecm.getCategories());
        categoryListView.setAdapter(aa);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.event_categories_fragment, container, false);
    }


}
