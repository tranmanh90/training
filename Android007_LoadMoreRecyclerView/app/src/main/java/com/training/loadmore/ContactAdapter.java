package com.training.loadmore;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tran Manh on 9/13/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private OnLoadMoreListener loadMoreListener;
    private boolean isLoading;
    private Activity activity;
    private List<Contact> contactList;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;

    public ContactAdapter(RecyclerView recyclerView, List<Contact> contactList, Activity activity) {
        this.contactList = contactList;
        this.activity = activity;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    if (loadMoreListener != null) {
                        loadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }

    public void setOnLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_recycler_view_row, viewGroup, false);
            return new UserViewHolder(view);
        } else if (i == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_loading, viewGroup, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof UserViewHolder) {

            Contact contact = contactList.get(i);
            UserViewHolder userViewHolder = (UserViewHolder) viewHolder;

            userViewHolder.phone.setText(contact.getPhone());
            userViewHolder.email.setText(contact.getEmail());
        } else if (viewHolder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) viewHolder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return contactList.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return contactList == null ? 0 : contactList.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    private class LoadingViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar progressBar;

        public LoadingViewHolder(View view) {
            super(view);
            progressBar = view.findViewById(R.id.progressBar1);
        }
    }

    private class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView phone;
        private TextView email;

        public UserViewHolder(View view) {
            super(view);
            phone = view.findViewById(R.id.txt_phone);
            email = view.findViewById(R.id.txt_email);
        }
    }
}
