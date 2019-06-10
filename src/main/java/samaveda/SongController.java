package samaveda;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wrapper.spotify.model_objects.specification.Track;



@RestController
public class SongController {



    @RequestMapping("/song")
    public Song track(@RequestParam(value="id") String id) {
        Track track = TrackGetter.getTrack(id);

        Song song = new Song(track.getName(), id);

        return song;
    }

}
