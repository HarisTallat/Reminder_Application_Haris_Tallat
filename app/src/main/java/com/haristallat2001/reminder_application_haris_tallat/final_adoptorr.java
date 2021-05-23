package com.haristallat2001.reminder_application_haris_tallat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class final_adoptorr extends RecyclerView.Adapter<final_adoptorr.ViewHolder>{
    private ArrayList<class_main> final_class;
    public interface clicked{
        void clickedItem(int index);
    }
    clicked my_activity;

    public final_adoptorr (Context context, ArrayList<class_main>List )
    {

        my_activity= (clicked) context;
        final_class =List;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{
TextView list_name_main,list_data_main,datee;
ImageView ribbon,iv_deletet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            list_name_main=itemView.findViewById(R.id.list_name_main);
            list_data_main=itemView.findViewById(R.id.list_data_main);
            datee=itemView.findViewById(R.id.datee);
            ribbon=itemView.findViewById(R.id.ribbon);
            iv_deletet=itemView.findViewById(R.id.iv_deletet);
            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    my_activity.clickedItem(final_class.indexOf((class_main) itemView.getTag()));
                }
            });



        }

        @Override
        public boolean onLongClick(View v) {
            iv_deletet.setVisibility(View.VISIBLE);
            iv_deletet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    final_class.remove(position);
                    notifyItemRemoved(position);

                }
            });
            return true;
        }

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.final_rc   ,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder. list_name_main.setText(final_class.get(position).getList_nam());
        holder.   list_data_main.setText(final_class.get(position).getData());
        holder.   datee.setText(final_class.get(position).getTime());
       if(final_class.get(position).getList_nam().equals("Cricket"))
       holder.ribbon.setImageResource(R.drawable.low);
        else if(final_class.get(position).getList_nam().equals("School"))
            holder.ribbon.setImageResource(R.drawable.high);
       else  if(final_class.get(position).getList_nam().equals("Computer"))
            holder.ribbon.setImageResource(R.drawable.normal);
       else
           holder.ribbon.setImageResource(R.drawable.normal);




    }

    @Override
    public int getItemCount() {
        return final_class.size();
    }
}
