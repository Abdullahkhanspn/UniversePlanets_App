package com.example.universeplanetsapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {
    //Using Custom Layouts -> MyCustomAdapter
    //Using Custom Objects -> extends ArrayAdapter<Planet>
    private ArrayList<Planet> planetsArrayList;
    Context context; // use this to know about the system level service, information about app.

    public MyCustomAdapter(ArrayList<Planet> planetsArrayList, Context context) {
        super(context,R.layout.item_list_layout,planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;
    }
    //View Holder Class -> used to cache the references to the views within an item layout
    //so that they do now need to repeatedly looked up during scrolling app ui.
    private static class MyViewHolder{
        TextView planetName;
        TextView moonsCount;
        ImageView planetImg;
    }
    //getView() -> is used to create and return a view for a specific item in the list.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       //1-get the planet object for the current position.
        Planet planet=getItem(position);
       //2-Inflate layout
        MyViewHolder myViewHolder;
        final View result;

        if(convertView==null){
            myViewHolder=new MyViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false);
        //3- is to finding a view.
            myViewHolder.planetName=(TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonsCount=(TextView) convertView.findViewById(R.id.moon_count_text);
            myViewHolder.planetImg =(ImageView) convertView.findViewById(R.id.imageView);
            result=convertView;
            convertView.setTag(myViewHolder);
        }
        else{
        //The view is recycled.
            myViewHolder=(MyViewHolder) convertView.getTag();
            result=convertView;
        }
        //Getting the data from the model class(Planet).
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonsCount.setText(planet.getMoonCount());
        myViewHolder.planetImg.setImageResource(planet.getPlanetImage());
        return result;
    }
}
