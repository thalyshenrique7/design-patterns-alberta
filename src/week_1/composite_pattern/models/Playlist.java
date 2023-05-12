package week_1.composite_pattern.models;

import week_1.composite_pattern.interfaces.IComponent;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements IComponent {
    private String playlistName ;
    private List<IComponent> playlist = new ArrayList<>();;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    public void add(IComponent component) {
        this.playlist.add(component);
    }

    @Override
    public void play() {}

    @Override
    public void setPlaybackSpeed(float speed) {}

    @Override
    public String getName() {
        return null;
    }
}
