package com.travel.mvp.adapters;

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
import com.travel.mvp.R;
import com.travel.mvp.models.TravelModel;
import com.travel.mvp.utils.DateTimeFormatUtil;

/**
 * Created by Tran Manh on 9/10/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class TravelBookAdapter extends RecyclerView.Adapter<TravelBookAdapter.TravelBookViewHolder> {

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
    public TravelBookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.single_card_view, viewGroup, false);
        return new TravelBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelBookViewHolder travelBookViewHolder, int i) {
        for (int j = 0; j < travelModel.getIncludedUserPlaces().size(); j++) {
            if (travelModel.getIncludedUserPlaces().get(j).getId().equals(travelModel.getTravelogues().get(i).getRelationships().getTravelogueUser().getRelationshipDetail().getId())) {
                travelBookViewHolder.titleText.setText(travelModel.getIncludedUserPlaces().get(j).getAttributes().getName());

                Glide.with(context.getApplicationContext()).load(travelModel.getIncludedUserPlaces().get(j).getAttributes().getAvatar()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL).into(travelBookViewHolder.avatarImage);
            } else if (travelModel.getIncludedUserPlaces().get(j).getId().equals(travelModel.getTravelogues().get(i).getRelationships().getTravelogueDestination().getRelationshipDetail().getId())) {
                travelBookViewHolder.addressBlur.setText(travelModel.getIncludedUserPlaces().get(j).getAttributes().getName());
            }
        }
        travelBookViewHolder.mounthYear.setText(dateTimeFormatUtil.convertDate(travelModel.getTravelogues().get(i).getAttributes().getPublishedAt()));
        Glide.with(context.getApplicationContext()).load(travelModel.getTravelogues().get(i).getAttributes().getCoverImageUrl()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL).into(travelBookViewHolder.mediaImage);

    }

    @Override
    public int getItemCount() {
        return travelModel.getTravelogues().size();
    }

    class TravelBookViewHolder extends RecyclerView.ViewHolder {

        private TextView addressBlur;
        private TextView titleText;
        private ImageView avatarImage;
        private ImageView mediaImage;
        private TextView mounthYear;

        public TravelBookViewHolder(View itemView) {
            super(itemView);
            addressBlur = itemView.findViewById(R.id.address_blur);
            titleText = itemView.findViewById(R.id.title_text);
            avatarImage = itemView.findViewById(R.id.avatar_image);
            mediaImage = itemView.findViewById(R.id.media_image);
            mounthYear = itemView.findViewById(R.id.mounth_year);
        }
    }
}
