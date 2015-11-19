package view_pager.example.com.viewpagerdebug;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrey on 20.11.15.
 */
public class ArticleFragment extends Fragment {
    private static final String LOG_DEBUG = "ArticleFragment";

    private RecyclerView mRecyclerView;
    private RecycleAdapter mAdapter;

    public static ArticleFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(LOG_DEBUG, " onAttach " + getPositionFromArguments());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_DEBUG, " onCreate " + getPositionFromArguments());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(LOG_DEBUG, " onCreateView " + getPositionFromArguments());
        View rootView = inflater.inflate(R.layout.fragment_article, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.news_recycler_view);
        View updateNews = rootView.findViewById(R.id.update_news);
        updateNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.updateNews("-new news_ " + getPositionFromArguments());
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(LOG_DEBUG, " onViewCreated " + getPositionFromArguments());
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        List<String> testNews = new ArrayList<>();
        testNews.add("Hello_" + getPositionFromArguments());
        testNews.add("Android_" + getPositionFromArguments());

        mAdapter = new RecycleAdapter(testNews);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_DEBUG, " onActivityCreated " + getPositionFromArguments());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_DEBUG, " onResume " + getPositionFromArguments());
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_DEBUG, " onPause " + getPositionFromArguments());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_DEBUG, " onStop " + getPositionFromArguments());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_DEBUG, " onDestroyView " + getPositionFromArguments());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(LOG_DEBUG, " onDetach " + getPositionFromArguments());
    }

    private int getPositionFromArguments() {
        return getArguments().getInt("position");
    }
}
