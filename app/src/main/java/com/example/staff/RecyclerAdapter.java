package com.example.staff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder> {
    List<NoteHelper> dataModelArrayList;

    public RecyclerAdapter(List<NoteHelper> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView sname,fname,email,tel,id,station;

        public Myholder(View itemView) {
            super(itemView);

            sname =  itemView.findViewById(R.id.sname);
            fname = itemView.findViewById(R.id.fname);
            email = itemView.findViewById(R.id.email);
            tel =  itemView.findViewById(R.id.tel);
            id = itemView.findViewById(R.id.id);
            station = itemView.findViewById(R.id.station);
        }
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,null);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        NoteHelper dataModel=dataModelArrayList.get(position);
        holder.sname.setText(dataModel.getSname());
        holder.fname.setText(dataModel.getFname());
        holder.email.setText(dataModel.getEmail());
        holder.tel.setText(dataModel.getTel());
        holder.id.setText(dataModel.getId());
        holder.station.setText(dataModel.getStation());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}