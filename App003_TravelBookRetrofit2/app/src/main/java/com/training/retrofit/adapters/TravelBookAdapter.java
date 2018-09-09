package com.training.retrofit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.training.retrofit.R;
import com.training.retrofit.model.TravelModel;
import com.training.retrofit.utils.DateTimeFormatUtil;

/**
 * Created by Tran Manh on 8/23/2018.
 */
public class TravelBookAdapter extends RecyclerView.Adapter<TravelBookAdapter.TravelViewHolder> {

    private static final String TAG = "TravelBookAdapter";

    private Context context;
    private TravelModel travelModel;
    private DateTimeFormatUtil dateTimeFormatUtil;

    public TravelBookAdapter(Context context, TravelModel travelModel) {
        this.context = context;
        this.travelModel = travelModel;
        dateTimeFormatUtil = new DateTimeFormatUtil();
    }

    @NonNull
    @Override
    public TravelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_infor_layout, viewGroup, false);
        return new TravelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelViewHolder travelViewHolder, int i) {
        for (int j = 0; j < travelModel.getIncludedUserPlaces().size(); j++) {
            if (travelModel.getIncludedUserPlaces().get(j).getId().equals(travelModel.getTravelogues().get(i).getRelationships().getTravelogueUser().getRelationshipDetail().getId())) {
                travelViewHolder.titleText.setText(travelModel.getIncludedUserPlaces().get(j).getAttributes().getName());

                Glide.with(context.getApplicationContext()).load(travelModel.getIncludedUserPlaces().get(j).getAttributes().getAvatar()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL).into(travelViewHolder.avatarImage);
            } else if (travelModel.getIncludedUserPlaces().get(j).getId().equals(travelModel.getTravelogues().get(i).getRelationships().getTravelogueDestination().getRelationshipDetail().getId())) {
                travelViewHolder.addressBlur.setText(travelModel.getIncludedUserPlaces().get(j).getAttributes().getName());
            }
        }
        travelViewHolder.mounthYear.setText(dateTimeFormatUtil.convertDate(travelModel.getTravelogues().get(i).getAttributes().getPublishedAt()));
        Glide.with(context.getApplicationContext()).load(travelModel.getTravelogues().get(i).getAttributes().getCoverImageUrl()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL).into(travelViewHolder.mediaImage);
    }

    @Override
    public int getItemCount() {
        return travelModel.getTravelogues().size();
    }

    public class TravelViewHolder extends RecyclerView.ViewHolder {

        private TextView addressBlur;
        private TextView titleText;
        private ImageView avatarImage;
        private ImageView mediaImage;
        private TextView mounthYear;

        public TravelViewHolder(View view) {
            super(view);
            addressBlur = view.findViewById(R.id.address_blur);
            titleText = view.findViewById(R.id.title_text);
            avatarImage = view.findViewById(R.id.avatar_image);
            mediaImage = view.findViewById(R.id.media_image);
            mounthYear = view.findViewById(R.id.mounth_year);
        }
    }
}
