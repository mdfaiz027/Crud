package com.rama.sqliteapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context context;
    List<MyModel> myModelArrayList;
    LayoutInflater layoutInflater;

    public MyAdapter(Context context, List<MyModel> myModelArrayList) {
        this.context = context;
        this.myModelArrayList = myModelArrayList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View root = layoutInflater.inflate(R.layout.custom_layout, null);

        TextView name = root.findViewById(R.id.name);
        TextView className = root.findViewById(R.id.className);
        TextView imagePath = root.findViewById(R.id.imagePath);
        TextView videoPath = root.findViewById(R.id.videoPath);

        name.setText(""+myModelArrayList.get(i).getName());
        className.setText(""+myModelArrayList.get(i).getClassName());
        imagePath.setText(""+myModelArrayList.get(i).getImagePath());
        videoPath.setText(""+myModelArrayList.get(i).getVideoPath());

        return root;
    }
}
