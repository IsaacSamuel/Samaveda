package samaveda;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;

public class SpotifyClientAuth {
    private final static String clientId = "2496d8f8670f4dc586a7627ee9ddeeb2"; //A terrible idea, but am hacking.
    private final static String clientSecret = "fdf3f254efbe4a749867c9bfe2360f51"; //Same, but REALLY DEFINITELY a bad idea.
    private final static URI redirectUri = SpotifyHttpManager.makeUri("http://localhost:8080/login");


    private final static SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .setRedirectUri(redirectUri)
            .build();


    public static SpotifyApi getClientCredentials(String code) {
        try {
            System.out.println(code);
            AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(code)
                    .build();

            AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();

            // Set access and refresh token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
            spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

            return spotifyApi;


        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null; //No.
    }

}
