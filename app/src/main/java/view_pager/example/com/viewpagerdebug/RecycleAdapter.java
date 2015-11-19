package view_pager.example.com.viewpagerdebug;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andrey on 20.11.15.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private List<String> mNews;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView)v.findViewById(R.id.title_news);
        }
    }

    public RecycleAdapter(List<String> news) {
        mNews = news;
    }


    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTextView.setText(mNews.get(position));

    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public void updateNews(String newNews){
        mNews.add(newNews);
        notifyDataSetChanged();
    }
}
