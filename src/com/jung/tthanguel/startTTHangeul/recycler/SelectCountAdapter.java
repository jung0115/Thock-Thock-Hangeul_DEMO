package com.jung.tthanguel.startTTHangeul.recycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jung.tthanguel.R;

import java.util.ArrayList;

// 갯수 선택
public class SelectCountAdapter extends RecyclerView.Adapter<SelectCountAdapter.ViewHolder> {
    private ArrayList<SelectCountData> count;

    @NonNull
    @Override
    public SelectCountAdapter . ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {
        View view = LayoutInflater. from (parent.getContext()).inflate(
                R.layout.item_select_counts,
                parent,
                false
        );
        return new ViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectCountAdapter.ViewHolder holder, int position) {
        holder.onBind(count.get(position), position);
    }

    public void setCountList(ArrayList<SelectCountData> list) {
        this.count = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return count.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        Button selectBtn;

        public ViewHolder (@NonNull View itemView) {
            super(itemView);

            selectBtn = (Button) itemView.findViewById (R.id.btn_count);
        }

        void onBind (SelectCountData item, int position){
            selectBtn.setText(String.valueOf(item.getCount()));

            // 선택 해제
            if(item.getSelected())
                selectBtn.setBackgroundResource(R.drawable.shape_radius_btn);
            // 선택
            else
                selectBtn.setBackgroundResource(R.drawable.shape_radius_unselect_btn);

            selectBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectBtn.setBackgroundResource(R.drawable.shape_radius_btn);
                    count.get(position).setSelected(true);
                    setAll(position);
                }
            });
        }
    }

    void setAll(int position) {
        for(int i = 0; i < count.size(); i++) {
            if(i != position) {
                count.get(i).setSelected(false);
            }
        }
        notifyDataSetChanged();
    }

    public int getSelectCount() {
        for(int i = 0; i < count.size(); i++) {
            if(count.get(i).getSelected()) {
                return i;
            }
        }
        return -1;
    }

}