package com.example.recipe_java.common;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import org.jetbrains.annotations.NotNull;

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] layoutIds;

    public ViewPagerAdapter(Context context, int[] layoutIds) {
        this.mContext = context;
        this.layoutIds = layoutIds;
    }

    @Override
    public int getCount() {
        return layoutIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view == object;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        return container.findViewById(layoutIds[position]);
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View)object);
    }
}
