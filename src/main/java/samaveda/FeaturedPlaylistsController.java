package samaveda;

import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wrapper.spotify.model_objects.specification.Track;


@RestController
public class FeaturedPlaylistsController {

    @RequestMapping("/featured")
    public PlaylistSimplified[] featuredPlaylists() {
        return FeaturedPlaylistsGetter.getFeaturedPlaylists();
    }
}
