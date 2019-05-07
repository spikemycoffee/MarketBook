package com.example.marketbook.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marketbook.R;
import com.example.marketbook.TimelineAdapter;
import com.example.marketbook.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class TimeLineFragment extends Fragment {
    private RecyclerView rvTimeline;
    protected List<Post> posts;
    protected TimelineAdapter adapter;
    //TODO: set up the swipe top refresh
   //private SwipeRefreshLayout swipeContainer; //container to refresher


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timeline, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvTimeline = view.findViewById(R.id.rvTimeline);

        posts = new ArrayList<Post>();

        adapter = new TimelineAdapter(getContext(), posts);

        rvTimeline.setAdapter(adapter);

        rvTimeline.setLayoutManager(new LinearLayoutManager(getContext()));

        postQuery();
    }

    //this method is going to be used to get the data on the timeline
    protected void postQuery() {
        final ParseQuery<Post> postQuery = new ParseQuery<>(Post.class);
        postQuery.include(Post.KEY_USER); //include the user for each post
        postQuery.setLimit(20);
        postQuery.addDescendingOrder(Post.KEY_CREATED_AT);
        postQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> objects, ParseException e) {
                if(e != null){
                    Log.e("app", "something has happend " + e.getMessage());
                    e.printStackTrace();
                    return;
                }

                posts.clear();
                posts.addAll(objects);
                adapter.notifyDataSetChanged();

//                for(int i = 0; i < objects.size(); i ++){
//                    Log.d("image_url", "the url is " + objects.get(i).getImage().getUrl());
//                }
            }
        });
//        swipeContainer.setRefreshing(false);
    }
}
