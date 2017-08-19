package com.example.android.whatsnext;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;


/**
 * Created by vishaal on 14/6/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.NumberViewHolder>
{

    private static final String TAG=CustomAdapter.class.getSimpleName();


    final private ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

    private int mNumberItems;

    //String[] arrayForRecyclerView=new String[]{"GK","Entertainment","Science","Mythology","Sports","Geography","History","Politics","Art","Celebrities","Animals","Vehicles"};

    public interface ListItemClickListener
    {
        void onListItemClick(int clickedItemIndex);
    }

    public CustomAdapter(int numberOfItems, ListItemClickListener listener)
    {
        mNumberItems=numberOfItems;
        mOnClickListener=listener;
        viewHolderCount=0;
    }




    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        int layoutIdForListItem=R.layout.list_item_base_timeline;
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(layoutIdForListItem,parent,false);
        NumberViewHolder viewHolder=new NumberViewHolder(view);
        viewHolderCount++;
        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: "
                + viewHolderCount);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        String color;
        int backgroundColor;
        int differenceInShade = 50;
        Log.d(TAG,"#"+position);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day)
        {
            case Calendar.MONDAY: holder.bind(MainActivity.mondayBaseItems.get(position).eventName, MainActivity.mondayBaseItems.get(position).timeFrom, MainActivity.mondayBaseItems.get(position).timeTo);break;

            case Calendar.TUESDAY:  holder.bind(MainActivity.tuesdayBaseItems.get(position).eventName, MainActivity.tuesdayBaseItems.get(position).timeFrom, MainActivity.tuesdayBaseItems.get(position).timeTo);break;

            case Calendar.WEDNESDAY:  holder.bind(MainActivity.wednesdayBaseItems.get(position).eventName, MainActivity.wednesdayBaseItems.get(position).timeFrom, MainActivity.wednesdayBaseItems.get(position).timeTo);break;

            case Calendar.THURSDAY:  holder.bind(MainActivity.thursdayBaseItems.get(position).eventName, MainActivity.thursdayBaseItems.get(position).timeFrom, MainActivity.thursdayBaseItems.get(position).timeTo);break;

            case Calendar.FRIDAY:  holder.bind(MainActivity.fridayBaseItems.get(position).eventName, MainActivity.fridayBaseItems.get(position).timeFrom, MainActivity.fridayBaseItems.get(position).timeTo);break;

            case Calendar.SATURDAY:  holder.bind(MainActivity.saturdayBaseItems.get(position).eventName, MainActivity.saturdayBaseItems.get(position).timeFrom, MainActivity.saturdayBaseItems.get(position).timeTo);break;

            case Calendar.SUNDAY:  holder.bind(MainActivity.sundayBaseItems.get(position).eventName, MainActivity.sundayBaseItems.get(position).timeFrom, MainActivity.sundayBaseItems.get(position).timeTo);break;
        }
//        TextView im=(TextView) holder.itemView.findViewById(R.id.right_button);



//        if(arrayForRecyclerView[position].equals("Entertainment") || arrayForRecyclerView[position].equals("Science"))
//        {
//            im.setText("›");
//            //im.setTextColor(Color.parseColor("#000"));
//            im.setVisibility(View.VISIBLE);
//        }
//
//        else
//        {
//            im.setVisibility(View.GONE);
//        }
//
//        if(arrayForRecyclerView[position].equals("GK"))
//        {
//            backgroundColor = holder.itemView.getResources().getColor(R.color.red);
//            //((TextView) holder.itemView.findViewById(R.id.item_category)).setTextColor(backgroundColor);
//            color = Integer.toHexString(backgroundColor & 0x00ffffff);
//            //holder.itemView.findViewById(R.id.category_card_view).setBackgroundColor(getDarkerShade(color, differenceInShade));
//            //holder.itemView.setBackgroundColor(backgroundColor);
//        }
//        else if(arrayForRecyclerView[position].equals("Entertainment"))
//        {
//            backgroundColor = holder.itemView.getResources().getColor(R.color.material_yellow);
//            //((TextView) holder.itemView.findViewById(R.id.item_category)).setTextColor(backgroundColor);
//            color = Integer.toHexString(backgroundColor & 0x00ffffff);
//            //holder.itemView.findViewById(R.id.category_card_view).setBackgroundColor(getDarkerShade(color, differenceInShade));
//            //holder.itemView.setBackgroundColor(backgroundColor);
//        }
//        else if(arrayForRecyclerView[position].equals("Science"))
//        {
//            backgroundColor = holder.itemView.getResources().getColor(R.color.material_purple);
//            //((TextView) holder.itemView.findViewById(R.id.item_category)).setTextColor(backgroundColor);
//            color = Integer.toHexString(backgroundColor & 0x00ffffff);
//            //holder.itemView.findViewById(R.id.category_card_view).setBackgroundColor(getDarkerShade(color, differenceInShade));
//            //holder.itemView.setBackgroundColor(backgroundColor);
//        }
//        else if(arrayForRecyclerView[position].equals("Mythology"))
//        {
//            backgroundColor = holder.itemView.getResources().getColor(R.color.material_orange);
//            //((TextView) holder.itemView.findViewById(R.id.item_category)).setTextColor(backgroundColor);
//            color = Integer.toHexString(backgroundColor & 0x00ffffff);
//            //holder.itemView.findViewById(R.id.category_card_view).setBackgroundColor(getDarkerShade(color, differenceInShade));
//            ////holder.itemView.setBackgroundColor(backgroundColor);
//        }
//        else if(arrayForRecyclerView[position].equals("Sports"))
//        {
//            backgroundColor = holder.itemView.getResources().getColor(R.color.material_green);
//            //((TextView) holder.itemView.findViewById(R.id.item_category)).setTextColor(backgroundColor);
//            color = Integer.toHexString(backgroundColor & 0x00ffffff);
//            //holder.itemView.findViewById(R.id.category_card_view).setBackgroundColor(getDarkerShade(color, differenceInShade));
//            ////holder.itemView.setBackgroundColor(backgroundColor);
//        }
//        else if(arrayForRecyclerView[position].equals("Geography"))
//        {
//            backgroundColor = holder.itemView.getResources().getColor(R.color.material_amber);
//            //((TextView) holder.itemView.findViewById(R.id.item_category)).setTextColor(backgroundColor);
//            color = Integer.toHexString(backgroundColor & 0x00ffffff);
//            //holder.itemView.findViewById(R.id.category_card_view).setBackgroundColor(getDarkerShade(color, differenceInShade));
//            //holder.itemView.setBackgroundColor(backgroundColor);
//        }
//        else if(arrayForRecyclerView[position].equals("History"))
//        {
//            backgroundColor = holder.itemView.getResources().getColor(R.color.red);
//            //((TextView) holder.itemView.findViewById(R.id.item_category)).setTextColor(backgroundColor);
//            color = Integer.toHexString(holder.itemView.getResources().getColor(R.color.red) & 0x00ffffff);
//            //holder.itemView.findViewById(R.id.category_card_view).setBackgroundColor(getDarkerShade(color, differenceInShade));
//            //holder.itemView.setBackgroundColor(holder.itemView.getResources().getColor(R.color.red));
//        }
//        else if(arrayForRecyclerView[position].equals("Politics"))
//        {
//            backgroundColor = holder.itemView.getResources().getColor(R.color.red);
//            //((TextView) holder.itemView.findViewById(R.id.item_category)).setTextColor(backgroundColor);
//            color = Integer.toHexString(holder.itemView.getResources().getColor(R.color.material_yellow) & 0x00ffffff);
//            //holder.itemView.findViewById(R.id.category_card_view).setBackgroundColor(getDarkerShade(color, differenceInShade));
//            //holder.itemView.setBackgroundColor(holder.itemView.getResources().getColor(R.color.material_yellow));
//        }
//        else if(arrayForRecyclerView[position].equals("Art"))
//        {
//            backgroundColor = holder.itemView.getResources().getColor(R.color.red);
//            //((TextView) holder.itemView.findViewById(R.id.item_category)).setTextColor(backgroundColor);
//            color = Integer.toHexString(holder.itemView.getResources().getColor(R.color.material_purple) & 0x00ffffff);
//            //holder.itemView.findViewById(R.id.category_card_view).setBackgroundColor(getDarkerShade(color, differenceInShade));
//            //holder.itemView.setBackgroundColor(holder.itemView.getResources().getColor(R.color.material_purple));
//        }
//        else if(arrayForRecyclerView[position].equals("Celebrities"))
//        {
//            backgroundColor = holder.itemView.getResources().getColor(R.color.red);
//            //((TextView) holder.itemView.findViewById(R.id.item_category)).setTextColor(backgroundColor);
//            color = Integer.toHexString(holder.itemView.getResources().getColor(R.color.material_orange) & 0x00ffffff);
//            //holder.itemView.findViewById(R.id.category_card_view).setBackgroundColor(getDarkerShade(color, differenceInShade));
//            //holder.itemView.setBackgroundColor(holder.itemView.getResources().getColor(R.color.material_orange));
//        }
//        else if(arrayForRecyclerView[position].equals("Animals"))
//        {
//            backgroundColor = holder.itemView.getResources().getColor(R.color.red);
//            //((TextView) holder.itemView.findViewById(R.id.item_category)).setTextColor(backgroundColor);
//            color = Integer.toHexString(holder.itemView.getResources().getColor(R.color.material_green) & 0x00ffffff);
//            //holder.itemView.findViewById(R.id.category_card_view).setBackgroundColor(getDarkerShade(color, differenceInShade));
//            //holder.itemView.setBackgroundColor(holder.itemView.getResources().getColor(R.color.material_green));
//        }
//        else if(arrayForRecyclerView[position].equals("Vehicles"))
//        {
//            backgroundColor = holder.itemView.getResources().getColor(R.color.red);
//            //((TextView) holder.itemView.findViewById(R.id.item_category)).setTextColor(backgroundColor);
//            color = Integer.toHexString(holder.itemView.getResources().getColor(R.color.material_amber) & 0x00ffffff);
//            //holder.itemView.findViewById(R.id.category_card_view).setBackgroundColor(getDarkerShade(color, differenceInShade));
//            //holder.itemView.setBackgroundColor(holder.itemView.getResources().getColor(R.color.material_amber));
//        }
//
//
//        if(arrayForRecyclerView[position].equals("GK"))
//        {
//            ((ImageView) holder.itemView.findViewById(R.id.icon_category)).setImageResource(R.drawable.ic_gk_icon);
//        }
//        else if(arrayForRecyclerView[position].equals("Entertainment"))
//        {
//            ((ImageView) holder.itemView.findViewById(R.id.icon_category)).setImageResource(R.drawable.ic_entertainment_icon);
//        }
//        else if(arrayForRecyclerView[position].equals("Science"))
//        {
//            ((ImageView) holder.itemView.findViewById(R.id.icon_category)).setImageResource(R.drawable.ic_science_icon);
//        }
//        else if(arrayForRecyclerView[position].equals("Mythology"))
//        {
//            ((ImageView) holder.itemView.findViewById(R.id.icon_category)).setImageResource(R.drawable.ic_mythology_icon);
//        }
//        else if(arrayForRecyclerView[position].equals("Sports"))
//        {
//            ((ImageView) holder.itemView.findViewById(R.id.icon_category)).setImageResource(R.drawable.ic_sports_icon);
//        }
//        else if(arrayForRecyclerView[position].equals("Geography"))
//        {
//            ((ImageView) holder.itemView.findViewById(R.id.icon_category)).setImageResource(R.drawable.ic_geography_icon);
//        }
//        else if(arrayForRecyclerView[position].equals("History"))
//        {
//            ((ImageView) holder.itemView.findViewById(R.id.icon_category)).setImageResource(R.drawable.ic_history_icon);
//        }
//        else if(arrayForRecyclerView[position].equals("Politics"))
//        {
//            ((ImageView) holder.itemView.findViewById(R.id.icon_category)).setImageResource(R.drawable.ic_politics_icon);
//        }
//        else if(arrayForRecyclerView[position].equals("Art"))
//        {
//            ((ImageView) holder.itemView.findViewById(R.id.icon_category)).setImageResource(R.drawable.ic_art_icon);
//        }
//        else if(arrayForRecyclerView[position].equals("Celebrities"))
//        {
//            ((ImageView) holder.itemView.findViewById(R.id.icon_category)).setImageResource(R.drawable.ic_celebrity_icon);
//        }
//        else if(arrayForRecyclerView[position].equals("Animals"))
//        {
//            ((ImageView) holder.itemView.findViewById(R.id.icon_category)).setImageResource(R.drawable.ic_animal_icon);
//        }
//        else if(arrayForRecyclerView[position].equals("Vehicles"))
//        {
//            ((ImageView) holder.itemView.findViewById(R.id.icon_category)).setImageResource(R.drawable.ic_vehicles_icon);
//        }


    }




    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView displayString;
        TextView displayTime;

        public NumberViewHolder(View itemView)
        {
            super(itemView);
            displayString=(TextView) itemView.findViewById(R.id.event_base_timetable);
            displayTime=(TextView) itemView.findViewById(R.id.time_base_timetable);
            itemView.setOnClickListener(this);
        }

        void bind(String textForView, String timeFrom, String timeTo)
        {
            //DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            //Calendar calobj = Calendar.getInstance();
            displayTime.setText(timeFrom+"-"+timeTo);
            displayString.setText(textForView);
            //displayTime.setText(df.format(calobj.getTime()));
        }

        @Override
        public void onClick(View v)
        {
            int clickedPosition=getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
