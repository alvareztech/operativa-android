package com.danyalvarez.operationsresearch.adapters.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.danyalvarez.operationsresearch.R;
import com.danyalvarez.operationsresearch.classes.ResultItem;

import java.util.ArrayList;

public class ResultsListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<ResultItem> mData;

    public ResultsListAdapter(Context mContext) {
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mData = new ArrayList<ResultItem>();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item_result, null);
            viewHolder = new ViewHolder();

            viewHolder.sectionViewGroup = (ViewGroup) convertView.findViewById(R.id.sectionViewGroup);
            viewHolder.titleSectionText = (TextView) convertView.findViewById(R.id.titleSectionText);

            viewHolder.iconImage = (ImageView) convertView.findViewById(R.id.iconImage);
            viewHolder.descriptionText = (TextView) convertView.findViewById(R.id.descriptionText);
            viewHolder.resultText = (TextView) convertView.findViewById(R.id.resultText);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ResultItem result = mData.get(position);
        String titleSection = result.getTitleSection();
        if (titleSection != null && titleSection.length() > 0) {
            viewHolder.titleSectionText.setText(titleSection);
            viewHolder.sectionViewGroup.setVisibility(View.VISIBLE);
        } else {
            viewHolder.titleSectionText.setText("");
            viewHolder.sectionViewGroup.setVisibility(View.GONE);
        }

        viewHolder.iconImage.setImageResource(result.getIdIcon());
        viewHolder.descriptionText.setText(result.getDescription());
        viewHolder.resultText.setText(result.getResult());

        return convertView;
    }

    public void setData(ArrayList<ResultItem> data) {
        this.mData = data;
    }

    static class ViewHolder {
        ViewGroup sectionViewGroup;
        TextView titleSectionText;

        ImageView iconImage;
        TextView descriptionText;
        TextView resultText;
    }

    public void addItem(int idIcon, String description, String result) {
        mData.add(new ResultItem(idIcon, description, result));
        notifyDataSetChanged();
    }

    public void addItem(String titleSection, int idIcon, String description, String result) {
        mData.add(new ResultItem(titleSection, idIcon, description, result));
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }
}
