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

public class item_adopter extends RecyclerView.Adapter<item_adopter.ViewHolder>
{
    private ArrayList<list_data> data;
    public item_adopter(Context context, ArrayList<list_data>List )
    {
        data=List;
    }


    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnLongClickListener{
ImageView delete;
TextView tvData;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            delete=itemView.findViewById(R.id.delete);
            tvData=itemView.findViewById(R.id.tvData);
            itemView.setOnLongClickListener(this);

        }
        @Override
        public boolean onLongClick(View v) {
            delete.setVisibility(View.VISIBLE);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    data.remove(position);
                    notifyItemRemoved(position);

                }
            });
            return true;
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view_data,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvData.setText(data.get(position).getItemsName());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
