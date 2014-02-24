package com.danyalvarez.operationsresearch.adapters.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.danyalvarez.operationsresearch.R;
import com.danyalvarez.operationsresearch.classes.MenuItem;
import com.danyalvarez.operationsresearch.classes.Option;

import java.util.ArrayList;

/**
 * @author Daniel Alvarez
 */
public class MenuListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<MenuItem> mData;

    public MenuListAdapter(Context mContext) {
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mData = new ArrayList<MenuItem>();
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
            convertView = mLayoutInflater.inflate(R.layout.list_item_menu, null);
            viewHolder =  new ViewHolder();

            viewHolder.iconImage = (ImageView) convertView.findViewById(R.id.iconImage);
            viewHolder.titleText = (TextView) convertView.findViewById(R.id.titleText);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        MenuItem menuItem = mData.get(position);
        viewHolder.iconImage.setImageResource(menuItem.getIcon());
        viewHolder.titleText.setText(menuItem.getTitle());

        return convertView;
    }

    /**
     * ViewHolder static class
     */

    static class ViewHolder {
        ImageView iconImage;
        TextView titleText;
    }

    /**
     * Data methods
     */

    public void addItem(int imageResourse, String title) {
        mData.add(new MenuItem(imageResourse, title));
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }
}
