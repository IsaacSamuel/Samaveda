package samaveda;

import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;

import java.util.Arrays;

public class Song {
    private final String name;
    private final String id;
    private final String [] artist_names;
    private final String album_name;

    public Song(String name, String id, ArtistSimplified[] artists, AlbumSimplified album) {
        this.name = name;
        this.id = id;
        this.album_name = album.getName();

        this.artist_names = Arrays.stream(artists).map(artist -> artist.getName()).toArray(String[]::new);
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return id;
    }

    public String[] getArtist_names() {
        return artist_names;
    }

    public String getAlbum_name() {
        return album_name;
    }
}
