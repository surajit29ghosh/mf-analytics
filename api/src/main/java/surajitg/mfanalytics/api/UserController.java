package surajitg.mfanalytics.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/authenticate")
    public boolean validateUser(@RequestBody LoginModel login) {
        User current = userRepository.validateUserByPassword(login.email, login.password);

        if(current != null)
            return true;
        else
            return false;

    }

    @GetMapping("/find/{name}")
    public ResponseEntity<List<User>> getUsersByName(@PathVariable("name") String firstName) {
        try {
        List<User> users = (List<User>)userRepository.findByFirstName(firstName);

        if(users.size() > 0)
            return ResponseEntity.ok(users);
        else
            throw new EntityNotFoundException();
        }
        catch(Exception e) {
            throw e;
        }
    }
    
}
