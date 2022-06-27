package com.example.rvcards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<ExampleItem> mExampleList;
    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;

//    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
//        public TextView mTextView1;
//        public TextView mTextView2;
//
//        public ExampleViewHolder(View itemView) {
//            super(itemView);
//            mTextView1 = itemView.findViewById(R.id.textView01);
//            mTextView2 = itemView.findViewById(R.id.textView02);
//        }
//    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList) {
        mExampleList = exampleList;
    }

    // determine which layout to use for the row
    @Override
    public int getItemViewType(int position) {
        ExampleItem exampleItem = mExampleList.get(position);
        if (exampleItem.getType() == ExampleItem.ItemType.ONE_ITEM) {
            return TYPE_ONE;
        } else if (exampleItem.getType() == ExampleItem.ItemType.TWO_ITEM) {
            return TYPE_TWO;
        } else {
            return -1;
        }
    }

//    @Override
//    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
//        ExampleViewHolder evh = new ExampleViewHolder(v);
//        return evh;
//    }

    // specify the row layout file and click for each row
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
            return new ViewHolderOne(view);
        } else if (viewType == TYPE_TWO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item2, parent, false);
            return new ViewHolderTwo(view);
        } else {
            throw new RuntimeException("The type has to be ONE or TWO");
        }
    }

//    @Override
//    public void onBindViewHolder(ExampleViewHolder holder, int position) {
//        ExampleItem currentItem = mExampleList.get(position);
//
//        holder.mTextView1.setText(currentItem.getText1());
//        holder.mTextView2.setText(currentItem.getText2());
//    }

    // load data in each row element
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_ONE:
                initLayoutOne((ViewHolderOne)holder, position);
                break;
            case TYPE_TWO:
                initLayoutTwo((ViewHolderTwo) holder, position);
                break;
            default:
                break;
        }
    }

    private void initLayoutOne(ViewHolderOne holder, int pos) {
        holder.ittem.setText(mExampleList.get(pos).getText1());
        holder.ittem2.setText(mExampleList.get(pos).getText2());
    }

    private void initLayoutTwo(ViewHolderTwo holder, int pos) {
        holder.mitem1.setText(mExampleList.get(pos).getText1());
        holder.mitem2.setText(mExampleList.get(pos).getText2());
        holder.mitem3.setText(mExampleList.get(pos).getText3());
    }

    // Static inner class to initialize the views of rows
    static class ViewHolderOne extends RecyclerView.ViewHolder {
        public TextView ittem, ittem2;
        public ViewHolderOne(View itemView) {
            super(itemView);
            ittem = (TextView) itemView.findViewById(R.id.textView01);
            ittem2 = (TextView) itemView.findViewById(R.id.textView02);
        }
    }
//potato
    static class ViewHolderTwo extends RecyclerView.ViewHolder {
        public TextView mitem1, mitem2, mitem3;
        public ViewHolderTwo(View itemView) {
            super(itemView);
            mitem1 = (TextView) itemView.findViewById(R.id.textView01);
            mitem2 = (TextView) itemView.findViewById(R.id.textView02);
            mitem3 = (TextView) itemView.findViewById(R.id.textView03);
        }
    }


    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
