package ru.arcadudu.retrofit2practice;

import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<PostModel> posts;

    public PostAdapter(List<PostModel> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel post = posts.get(position);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            holder.post.setText(Html.fromHtml(post.getElementPureHtml(), Html.FROM_HTML_MODE_LEGACY));
        }else{
            holder.post.setText(Html.fromHtml(post.getElementPureHtml()));
        }
        holder.site.setText(post.getSite());

    }

    @Override
    public int getItemCount() {
        if(posts == null){
            return 0;
        }
        return posts.size();
    }


    class PostViewHolder extends RecyclerView.ViewHolder{
        TextView post, site;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            post = itemView.findViewById(R.id.postitem_post);
            site = itemView.findViewById(R.id.postitem_site);

        }
    }


}

