package com.iamjue.manchesterunited;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {
    public ArrayList<PlayerItem> getPlayerItemList() {
        return playerItemList;
    }

    public void setPlayerItemList(ArrayList<PlayerItem> playerItemList) {
        this.playerItemList = playerItemList;
    }

    private ArrayList<PlayerItem> playerItemList;
    private Context context;

    public ListViewAdapter(Context c) {
    this.context = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row,viewGroup,false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       Glide.with(context).load(getPlayerItemList().get(i).getStrThumb()).into(viewHolder.imgPlayer);
       viewHolder.tvNamePlayer.setText(String.format("\t\t\t%s", getPlayerItemList().get(i).getStrPlayer()));
        viewHolder.tvBirth.setText(String.format("\t\t\t%s", getPlayerItemList().get(i).getDateBorn()));
        viewHolder.tvSign.setText(String.format("\t\t\t%s", getPlayerItemList().get(i).getDateSigned()));
        viewHolder.tvPosition.setText(String.format("\t\t\t%s", getPlayerItemList().get(i).getStrPosition()));

    }

    @Override
    public int getItemCount() {
        return getPlayerItemList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_photo)
        CircleImageView imgPlayer;

        @BindView(R.id.tv_namePlayer)
        TextView tvNamePlayer;

        @BindView(R.id.tv_playerBorn)
        TextView tvBirth;

        @BindView(R.id.tv_playerSign)
        TextView tvSign;

        @BindView(R.id.tv_playerPosition)
        TextView tvPosition;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
