package com.danyalvarez.operationsresearch.adapters.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.danyalvarez.operationsresearch.R;
import com.danyalvarez.operationsresearch.classes.Option;
import com.danyalvarez.operationsresearch.classes.ResultItem;
import com.danyalvarez.operationsresearch.util.Util;
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * @author Daniel Alvarez
 */
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
            viewHolder =  new ViewHolder();

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

        viewHolder.iconImage.setImageBitmap(result.getIcon());
        viewHolder.descriptionText.setText(result.getDescription());
        viewHolder.resultText.setText(result.getResult() + "");

        return convertView;
    }

    /**
     * ViewHolder static class
     */

    static class ViewHolder {
        ViewGroup sectionViewGroup;
        TextView titleSectionText;

        ImageView iconImage;
        TextView descriptionText;
        TextView resultText;
    }

    /**
     * Data methods
     */

    public void addItem(String iconName, String description, double result) {
        mData.add(new ResultItem(Util.getPngBitmapFromAssets(mContext, iconName), description, result));
        notifyDataSetChanged();
    }

    public void addItem(String titleSection, String iconName, String description, double result) {
        mData.add(new ResultItem(titleSection, Util.getPngBitmapFromAssets(mContext, iconName), description, result));
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }
}
