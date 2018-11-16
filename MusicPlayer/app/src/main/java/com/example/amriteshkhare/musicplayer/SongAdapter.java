package com.example.amriteshkhare.musicplayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Amritesh Khare on 2/1/2018.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    ArrayList<Songinfo> _songs;
    Context context;

    OnitemClickListener onitemClickListener;

    SongAdapter(Context context, ArrayList<Songinfo> _songs)
    {
         this.context=context;
         this._songs=_songs;
    }

    public interface OnitemClickListener{
        void onItemClick(Button b, View v, Songinfo obj, int position );

    }
     public void setOnitemClickListener(OnitemClickListener onitemClickListener){
        this.onitemClickListener=onitemClickListener;
     }
    @Override
    public SongHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
    View myview= LayoutInflater.from(context).inflate(R.layout.row_song, viewGroup, false);
    return new SongHolder(myview);
    }

    @Override
    public void onBindViewHolder(final SongHolder songHolder, final int i) {
         final Songinfo c=_songs.get(i);
         songHolder.songName.setText(c.songName);
         songHolder.artistName.setText(c.artistName);
         songHolder.btnAction.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(onitemClickListener!=null)
                 {
                     onitemClickListener.onItemClick(songHolder.btnAction, v, c, i);

                 }
             }
         });

    }

    @Override
    public int getItemCount() {
        return _songs.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        TextView songName,artistName;
        Button btnAction;

        public SongHolder(View itemView) {
            super(itemView);
            songName= (TextView)itemView.findViewById(R.id.tvSongName);
            artistName= (TextView)itemView.findViewById(R.id.tvArtistName);
            btnAction= (Button) itemView.findViewById(R.id.btnAction);
        }
    }
}
