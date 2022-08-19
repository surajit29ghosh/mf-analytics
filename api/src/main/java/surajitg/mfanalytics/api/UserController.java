package surajitg.mfanalytics.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/authenticate")
    public ResponseEntity<User> validateUser(@RequestBody LoginModel login) {
        User current = userRepository.validateUserByPassword(login.email, login.password);

        if (current != null)
            return ResponseEntity.ok(current);
        else
            return ResponseEntity.badRequest().build();

    }

    @GetMapping("/find/{name}")
    public ResponseEntity<List<User>> getUsersByName(@PathVariable("name") String firstName) {
        try {
            List<User> users = (List<User>) userRepository.findByFirstName(firstName);

            if (users.size() > 0)
                return ResponseEntity.ok(users);
            else
                throw new EntityNotFoundException();
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserViewModel model) {

        String formattedEmail = model.email.toLowerCase();
        if (userRepository.findByEmail(formattedEmail) != null)
            return new ResponseEntity<String>("User with same email already exists", HttpStatus.EXPECTATION_FAILED);

        try {
            User user = new User(formattedEmail, model.firstName, model.lastName, model.password);
            userRepository.save(user);

            return new ResponseEntity<String>(user.getId(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw e;
        }
    }

}
