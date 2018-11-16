package com.example.amriteshkhare.musicplayer;

/**
 * Created by Amritesh Khare on 2/1/2018.
 */

public class Songinfo {
    public String songName,artistName,songUrl;

    public Songinfo()
    {

    }

    public Songinfo(String songName, String artistName, String songUrl) {
        this.songName = songName;
        this.artistName = artistName;
        this.songUrl = songUrl;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}


















