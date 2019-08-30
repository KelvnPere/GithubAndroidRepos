package com.example.starredandroidrepos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.starredandroidrepos.R;
import com.example.starredandroidrepos.model.Repos;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.CustomViewHolder> {
    private List<Repos> repositories;

    public RepositoryAdapter(List<Repos> repositories) {
        this.repositories = repositories;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Repos reposs = repositories.get(position);
        holder.repoName.setText(reposs.getName());
        holder.repoStar.setInputType(reposs.getStars());
        holder.repoDescribtion.setText(reposs.getDescription());
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView repoName, repoStar, repoDescribtion;

        public CustomViewHolder(View view) {
            super(view);
            repoName = view.findViewById(R.id.repositoryName);
            repoStar = view.findViewById(R.id.repoStars);
            repoDescribtion = view.findViewById(R.id.repoDescription);
        }
    }
}
