package com.example.android.whatsnext;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by vishaal on 19/8/17.
 */

public class ViewTimetableCustomAdapter extends RecyclerView.Adapter<ViewTimetableCustomAdapter.NumberViewHolder>
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

    public ViewTimetableCustomAdapter(int numberOfItems, ListItemClickListener listener)
    {
        mNumberItems=numberOfItems;
        mOnClickListener=listener;
        viewHolderCount=0;
    }




    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        int layoutIdForListItem=R.layout.list_item_view_timetable;
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(layoutIdForListItem,parent,false);
        NumberViewHolder viewHolder=new NumberViewHolder(view);
        viewHolderCount++;
        Log.d("thug", "onCreateViewHolder: number of ViewHolders created: "
                + viewHolderCount);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        String color;

        Log.d(TAG,"#"+position);

//        Calendar calendar = Calendar.getInstance();
//        int day = calendar.get(Calendar.DAY_OF_WEEK);

        //switch (day)
        //{
            //case Calendar.MONDAY: holder.bind(MainActivity.mondayBaseItems.get(position).eventName, MainActivity.mondayBaseItems.get(position).timeFrom, MainActivity.mondayBaseItems.get(position).timeTo);break;

            //case Calendar.TUESDAY:  holder.bind(MainActivity.tuesdayBaseItems.get(position).eventName, MainActivity.tuesdayBaseItems.get(position).timeFrom, MainActivity.tuesdayBaseItems.get(position).timeTo);break;

            //case Calendar.WEDNESDAY:  holder.bind(MainActivity.wednesdayBaseItems.get(position).eventName, MainActivity.wednesdayBaseItems.get(position).timeFrom, MainActivity.wednesdayBaseItems.get(position).timeTo);break;

            //case Calendar.THURSDAY:  holder.bind(MainActivity.thursdayBaseItems.get(position).eventName, MainActivity.thursdayBaseItems.get(position).timeFrom, MainActivity.thursdayBaseItems.get(position).timeTo);break;

            //case Calendar.FRIDAY:  holder.bind(MainActivity.fridayBaseItems.get(position).eventName, MainActivity.fridayBaseItems.get(position).timeFrom, MainActivity.fridayBaseItems.get(position).timeTo);break;

            //case Calendar.SATURDAY:  holder.bind(MainActivity.saturdayBaseItems.get(position).eventName, MainActivity.saturdayBaseItems.get(position).timeFrom, MainActivity.saturdayBaseItems.get(position).timeTo);break;

            //case Calendar.SUNDAY:  holder.bind(MainActivity.sundayBaseItems.get(position).eventName, MainActivity.sundayBaseItems.get(position).timeFrom, MainActivity.sundayBaseItems.get(position).timeTo);break;
        //}
//        TextView im=(TextView) holder.itemView.findViewById(R.id.right_button);

        List<BaseItem> items= new ArrayList<BaseItem>();

        for(BaseItem x: MainActivity.mondayBaseItems)
            items.add(x);

        for(BaseItem x: MainActivity.tuesdayBaseItems)
            items.add(x);

        for(BaseItem x: MainActivity.wednesdayBaseItems)
            items.add(x);

        for(BaseItem x: MainActivity.thursdayBaseItems)
            items.add(x);

        for(BaseItem x: MainActivity.fridayBaseItems)
            items.add(x);

        for(BaseItem x: MainActivity.saturdayBaseItems)
            items.add(x);

        for(BaseItem x: MainActivity.sundayBaseItems)
            items.add(x);


        for(BaseItem x: items)
            Log.d("TAG", x.eventName+" "+x.timeTo);

        holder.bind(items.get(position).eventName, items.get(position).timeFrom, items.get(position).timeTo);
//holder.bind("1", "2", "3");

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
            displayString=(TextView) itemView.findViewById(R.id.ffs1);
            displayTime=(TextView) itemView.findViewById(R.id.ffs2);
            itemView.setOnClickListener(this);
        }

        void bind(String textForView, String timeFrom, String timeTo)
        {
            //DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            //Calendar calobj = Calendar.getInstance();

            if(displayTime!=null)
                displayTime.setText(timeFrom+"-"+timeTo);
            if(displayString!=null)
                displayString.setText(textForView);
            //displayTime.setText(df.format(calobj.getTime()));

//            displayString.setText("1");
//            displayTime.setText("2");

//            displayTime.setText(textForView);
//            displayString.setText(timeFrom);
        }

        @Override
        public void onClick(View v)
        {
            int clickedPosition=getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
