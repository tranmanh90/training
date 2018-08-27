package com.training.retrofit.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.training.retrofit.R;
import com.training.retrofit.models.Notice;

import java.util.ArrayList;

/**
 * Created by Tran Manh on 8/24/2018.
 * Woori Bank Vietnam
 * Email: manh.tranvan@woori.com.vn
 */
public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    private ArrayList<Notice> list;

    public NoticeAdapter(ArrayList<Notice> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_row_view, parent, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
        holder.noticeTitle.setText(list.get(position).getTitle());
        holder.noticeBrief.setText(list.get(position).getBrief());
        holder.noticeFilePath.setText(list.get(position).getFilesource());

        Log.i("AAAAAAAAAAA: ", list.get(position).getTitle());
        Log.i("AAAAAAAAAAA: ", list.get(position).getBrief());
        Log.i("AAAAAAAAAAA: ", list.get(position).getFilesource());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder {
        private TextView noticeTitle, noticeBrief, noticeFilePath;

        public NoticeViewHolder(View view) {
            super(view);
            noticeTitle = view.findViewById(R.id.notice_name);
            noticeBrief = view.findViewById(R.id.notice_description);
            noticeFilePath = view.findViewById(R.id.notice_file_path);

        }
    }
}
