package com.example.marketbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder>{

    private Context context;
    private List<Post> posts;
    private Boolean heart = false;
    private Boolean save = false;

    public TimelineAdapter(Context context, List<Post>posts){
        this.context = context;
        this.posts = posts;
    }

    //inflate the adapter with data
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_activity,viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        //binding for each post
        final Post post = posts.get(i);

        //getting the image
        ParseFile image = post.getImage();
        if(image != null) {
            String url = image.getUrl();
            String https = stringConverter(url);//convert the string to https


            //need to turn the image returned to a bitmap image, or turn it to a absolute path
            if (url != null) {
                Glide.with(context).load(https).into(viewHolder.ivPost);
                //TODO: need to link the profile pic in the backend to here
                //Glide.with(context)
                Log.d("url_image", "this is the url " + https);
            }
        }

        //getting the username and the description
        viewHolder.tvUsername.setText(post.getUser().getUsername());
        viewHolder.tvHandler.setText(post.getUser().getString("Handler"));
        viewHolder.tvDescription.setText(post.getDescription());
        viewHolder.tvLikesAmount.setText(Integer.toString(post.getLikes()));
        viewHolder.tvCommentAmount.setText(Integer.toString(post.getComments()));
        viewHolder.tvRepostAmount.setText(Integer.toString(post.getReposts()));
        viewHolder.tvSavedAmount.setText(Integer.toString(post.getSaved()));

        //persistence for the liked or saved button
        if(post.getLikedFlagged()) viewHolder.ivHeart.setBackgroundResource(R.drawable.ic_heart);
        else viewHolder.ivHeart.setBackgroundResource(R.drawable.ic_heart_outline);
        if(post.getSavedFlagged()) viewHolder.ivSave.setBackgroundResource(R.drawable.ic_saved);
        else  viewHolder.ivSave.setBackgroundResource(R.drawable.ic_saved_outline);

        //listener for likes
        viewHolder.ivHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int likes = post.getLikes();
                if(!heart) {
                    viewHolder.ivHeart.setBackgroundResource(R.drawable.ic_heart);
                    ++likes;
                    heart = true;
                }else {
                    viewHolder.ivHeart.setBackgroundResource(R.drawable.ic_heart_outline);
                    --likes;
                    heart = false;
                }

                post.setLikedFlagged(heart); //setting the data to liked or not liked
                viewHolder.tvLikesAmount.setText(Integer.toString(likes)); //updating the amount of likes
                post.setLikes(likes);//saving the amount of likes in the backend
                post.saveInBackground();

            }
        });

        //listener for saves
        viewHolder.ivSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int saves = post.getSaved();
                if (!save) {
                    viewHolder.ivSave.setBackgroundResource(R.drawable.ic_saved);
                    ++saves;
                    save = true;
                } else {
                    viewHolder.ivSave.setBackgroundResource(R.drawable.ic_saved_outline);
                    --saves;
                    save = false;
                }

                post.setSavedFlagged(save); //setting the data to saved or not saved
                viewHolder.tvSavedAmount.setText(Integer.toString(saves)); //updating the amount of likes
                post.setSaved(saves);//saving the amount of likes in the backend
                post.saveInBackground(); //saving all backend data

            }
        });
    }

    //reformatting the link to get a https connection
    private String stringConverter(String url) {
        String newLink = " ";
        char[] link = url.toCharArray();
        for(int i = 0; i < link.length; i++){
            newLink += link[i];
            if(i == 3) newLink += 's';
        }
        Log.d("string", newLink);
        newLink = newLink.trim();
        return newLink;
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    //this is where the item shown is defined
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsername;
        TextView tvHandler;
        TextView tvSeconds;
        ImageView ivProfilePic;
        ImageView ivPost;
        TextView tvDescription;
        ImageView ivHeart;
        ImageView ivComments;
        ImageView ivRepost;
        ImageView ivSave;
        TextView tvLikesAmount;
        TextView tvCommentAmount;
        TextView tvRepostAmount;
        TextView tvSavedAmount;

        //bind the objects with the views
        private ViewHolder(View itemView) {
            super(itemView);

            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvHandler = itemView.findViewById(R.id.tvHandle);
            tvSeconds = itemView.findViewById(R.id.tvSeconds);
            ivProfilePic = itemView.findViewById(R.id.ivProfilePic);
            ivPost = itemView.findViewById(R.id.ivPost);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivHeart = itemView.findViewById(R.id.ivHeart);
            ivComments = itemView.findViewById(R.id.ivComment);
            ivRepost = itemView.findViewById(R.id.ivRepost);
            ivSave = itemView.findViewById(R.id.ivSave);
            tvLikesAmount = itemView.findViewById(R.id.tvLikesAmount);
            tvCommentAmount = itemView.findViewById(R.id.tvCommentsAmount);
            tvRepostAmount = itemView.findViewById(R.id.tvRepostAmount);
            tvSavedAmount = itemView.findViewById(R.id.tvSavedAmount);


            //TODO: set up the click event for each and update the number next to it, change heart from outline to filled
            //TODO: and the bookmark one, set logic for when book market is saved for user
            ivComments.setBackgroundResource(R.drawable.ic_comment);
            ivRepost.setBackgroundResource(R.drawable.ic_repost);

        }

        public void updateLikes() {
            //if the heart is not filled in then fill it in
            if (!heart) {
                ivHeart.setBackgroundResource(R.drawable.ic_heart);
                heart = true;

            } else {
                ivHeart.setBackgroundResource(R.drawable.ic_heart_outline);
                heart = false;
            }
        }
    }

}
