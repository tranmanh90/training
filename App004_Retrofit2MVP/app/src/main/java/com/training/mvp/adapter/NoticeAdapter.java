package com.training.mvp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.training.mvp.R;
import com.training.mvp.model.Notice;

import java.util.ArrayList;

/**
 * Created by Tran Manh on 9/9/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    private ArrayList<Notice> dataList;

    public NoticeAdapter(ArrayList<Notice> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view, parent, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
        holder.noticeTitle.setText(dataList.get(position).getTitle());
        holder.noticeBrief.setText(dataList.get(position).getBrief());
        holder.noticeFilePath.setText(dataList.get(position).getFilesource());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class NoticeViewHolder extends RecyclerView.ViewHolder {

        private TextView noticeTitle;
        private TextView noticeBrief;
        private TextView noticeFilePath;

        NoticeViewHolder(View itemView) {
            super(itemView);
            noticeTitle = itemView.findViewById(R.id.notice_title_text);
            noticeBrief = itemView.findViewById(R.id.notice_brief_text);
            noticeFilePath = itemView.findViewById(R.id.notice_file_path_text);
        }
    }
}
