package samaveda;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.User;
import com.wrapper.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;

import java.io.IOException;

public class UserGetter {

    public static User getUser(String code) {

        SpotifyApi spotifyApi = SpotifyClientAuth.getClientCredentials(code);

        try {
            GetCurrentUsersProfileRequest request = spotifyApi.getCurrentUsersProfile()
                 .build();

            final User user = request.execute();

            return user;

        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null; //Should throw exception but it's 2AM

    }

}
