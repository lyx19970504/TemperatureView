package com.example.temperatureview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hour_Adapter extends RecyclerView.Adapter<Hour_Adapter.Hour_Holder> {

    private static final String TAG = "Hour_Adapter";
    private Context mContext;
    private List<Integer> data = new ArrayList<>();
    private int minValue;
    private int maxValue;

    public Hour_Adapter(Context context,List<Integer> data){
        this.data.addAll(data);
        //将不规则的数据组从小到大排序
        Collections.sort(this.data);
        minValue = this.data.get(0);
        maxValue = this.data.get(data.size()-1);
        mContext = context;
    }

    @NonNull
    @Override
    public Hour_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.hour_item, viewGroup,false);
        return new Hour_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Hour_Holder hour_holder, int i) {

        //如果是第一个
        if(i==0){
            hour_holder.mTemperatureView.setDrawLeftLine(false);
        }
        //除第一个以外
        else{
            hour_holder.mTemperatureView.setDrawLeftLine(true);
            hour_holder.mTemperatureView.setLastValue(data.get(i-1));
        }

        //如果是最后一个
        if(i == data.size()-1){
            hour_holder.mTemperatureView.setDrawRightLine(false);
        }
        //除最后一个以外
        else{
            hour_holder.mTemperatureView.setDrawRightLine(true);
            hour_holder.mTemperatureView.setNextValue(data.get(i+1));
        }

        hour_holder.mTemperatureView.setCurrentValue(data.get(i));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Hour_Holder extends RecyclerView.ViewHolder{

        private TemperatureView mTemperatureView;

        public Hour_Holder(@NonNull View itemView) {
            super(itemView);
            mTemperatureView = itemView.findViewById(R.id.temp_view);
            mTemperatureView.setMinValue(minValue);
            mTemperatureView.setMaxValue(maxValue);
        }
    }

}