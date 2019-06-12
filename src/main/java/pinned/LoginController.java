package samaveda;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @RequestMapping("/login")
    public String redirect(@RequestParam(value="code") String accessCode) {
        com.wrapper.spotify.model_objects.specification.User u = UserGetter.getUser(accessCode);

        samaveda.User user = new User(u.getId(), u.getDisplayName());

        return "redirect:/http://localhost:3000?user_id=" + user.getId() + "&display_name=" + user.getDisplayName();

    }

}
