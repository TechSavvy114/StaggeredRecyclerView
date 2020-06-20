package com.example.searchstaggeredrecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder>  {

    private String[] mDataSet;
    private Context mContext;
    private Random mRandom = new Random();





    public ColorAdapter(Context context, String[] DataSet)
    {
        mDataSet = DataSet;
       mContext = context;

    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ViewHolder(View v){
            super(v);
            mTextView = (TextView)v.findViewById(R.id.tv);
        }
    }



    @NonNull
    @Override
    public ColorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_view,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ColorAdapter.ViewHolder holder, int position) {

        holder.mTextView.setText(mDataSet[position]);
        // Set a random height for TextView
        holder.mTextView.getLayoutParams().height = getRandomIntInRange(250,75);
        // Set a random color for TextView background
        holder.mTextView.setBackgroundColor(getRandomHSVColor());

    }

    private int getRandomHSVColor() {

        int hue = mRandom.nextInt(361);
        float saturation = 1.0f;
        float value = 1.0f;
        int alpha = 255;
        int color = Color.HSVToColor(alpha, new float[]{hue, saturation, value});
        // Return the color
        return color;
    }

    private int getRandomIntInRange(int i, int i1) {
        return mRandom.nextInt((i-i1)+i1)+i1;
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
