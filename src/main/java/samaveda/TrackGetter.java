package samaveda;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.tracks.GetTrackRequest;

import java.io.IOException;


public class TrackGetter {


    public static Track getTrack(String id) {

        SpotifyApi spotifyApi = SpotifyServerAuth.clientCredentials_Sync();

        GetTrackRequest getTrackRequest = spotifyApi.getTrack(id)
                .build();

        try {
            final Track track = getTrackRequest.execute();

            return track;

        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null; //Should throw exception but it's 2AM

    }


}
