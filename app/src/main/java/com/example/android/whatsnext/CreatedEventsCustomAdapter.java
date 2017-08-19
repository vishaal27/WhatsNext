package com.example.android.whatsnext;

/**
 * Created by vishaal on 19/8/17.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by vishaal on 12/7/17.
 */

public class CreatedEventsCustomAdapter extends RecyclerView.Adapter<CreatedEventsCustomAdapter.NumberViewHolder>
{

    private static final String TAG= CreatedEventsCustomAdapter.class.getSimpleName();

    final private ListItemClickListener mOnClickListener;
    private static int viewHolderCount;
    private int mNumberItems;


    public CreatedEventsCustomAdapter(int numberOfItems, ListItemClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
        mNumberItems=numberOfItems;
        viewHolderCount=0;
    }

    public interface ListItemClickListener
    {
        void onListItemClick1(int clickedItemIndex);
    }


    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        int layoutIdForListItem=R.layout.list_item_add_events;
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(layoutIdForListItem,parent,false);
        NumberViewHolder viewHolder= new NumberViewHolder(view);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Calendar calobj = Calendar.getInstance();
        //System.out.println(df.format(calobj.getTime()));
        holder.bind(MainActivity.createItemList.get(position).timeFrom, MainActivity.createItemList.get(position).timeTo, MainActivity.createItemList.get(position).date,MainActivity.createItemList.get(position).eventName );
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView displayTime;
        TextView displayEvent;
        ImageButton displayButton;

        public NumberViewHolder(final View itemView) {
            super(itemView);
            displayTime=(TextView) itemView.findViewById(R.id.time_add_events);
            displayEvent=(TextView) itemView.findViewById(R.id.event_add_events);
            displayButton=(ImageButton) itemView.findViewById(R.id.button_add);

            displayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "clicked add", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnClickListener(this);
        }

        void bind(String timeFrom, String timeTo, String Date, String eventName)
        {
            displayTime.setText(timeFrom+"-"+timeTo+"-"+Date);
            displayEvent.setText(eventName);
            //displayEvent.setText("11");
        }

        @Override
        public void onClick(View v) {
            int clickedPosition=getAdapterPosition();
            mOnClickListener.onListItemClick1(clickedPosition);
        }
    }
}
