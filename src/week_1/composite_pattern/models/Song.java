package week_1.composite_pattern.models;

import week_1.composite_pattern.interfaces.IComponent;

public class Song implements IComponent {
    private String songName;
    private String artist;
    private float speed = 1;

    public Song(String songName, String artist) {
        this.songName = songName;
        this.artist = artist;
    }

    @Override
    public void play() {}

    @Override
    public void setPlaybackSpeed(float speed) {}

    @Override
    public String getName() {
        return this.songName;
    }

    public String getArtist() {
        return artist;
    }
}
