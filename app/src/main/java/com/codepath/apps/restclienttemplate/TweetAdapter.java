package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

/**
 * Created by Zacharie-EDH on 2/25/2018.
 */

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder>{

    // pass in the Tweets array in the constructor
    private List<Tweet> mTweets;
    Context context;
    public TweetAdapter(List<Tweet> tweets){

        mTweets=tweets;
    }

    // for each row, inflate the layout and cache references into ViewHolder

    @Override
    public TweetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);

        View tweetView=inflater.inflate(R.layout.item_tweet,parent,false);
        ViewHolder viewHolder= new ViewHolder(tweetView);
        return  viewHolder;
    }

    // bind the values  based on the position of the element

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // get the data

        Tweet tweet=mTweets.get(position);

        holder.tvUsername.setText(tweet.user.name);
        holder.tvBody.setText(tweet.body);
        Glide.with(context).load(tweet.user.profileImageUrl).into(holder.ivProfileImage);

    }

    @Override
    public int getItemCount() {
        return mTweets.size();
    }
// create ViewHolder

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivProfileImage;
        public TextView tvUsername;
        public TextView tvBody;

        public ViewHolder(View itemView){

            super(itemView);

            //perform findViewById lookups

            ivProfileImage= (ImageView) itemView.findViewById(R.id.ivProfileImage);
            tvUsername= (TextView) itemView.findViewById(R.id.tvUserName);
            tvBody=(TextView) itemView.findViewById(R.id.tvBody);
        }

    }
}
