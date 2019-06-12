package samaveda;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.special.FeaturedPlaylists;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.requests.data.browse.GetListOfFeaturedPlaylistsRequest;

import java.io.IOException;



public class FeaturedPlaylistsGetter {

    private static final SpotifyApi spotifyApi = SpotifyServerAuth.getSpotifyAPI();

    private static final GetListOfFeaturedPlaylistsRequest getListOfFeaturedPlaylistsRequest = spotifyApi
            .getListOfFeaturedPlaylists()
            .build();

    public static PlaylistSimplified[] getFeaturedPlaylists() {
        try {
            final FeaturedPlaylists featuredPlaylists = getListOfFeaturedPlaylistsRequest.execute();

            final Paging<PlaylistSimplified> playlistPager = featuredPlaylists.getPlaylists();


            return playlistPager.getItems();
        }

        catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null; //Should throw exception but it's 2AM

    }


}
