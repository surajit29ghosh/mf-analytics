package surajitg.mfanalytics.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "User", ru = "400")
public class User {

    @Id
    @GeneratedValue
    private String Id;

    private String email;
    private String firstName;

    @PartitionKey
    private String lastName;

    private String password;

    private List<UserFavorite> favorites;
    
    public User() {

    }

    public User(String email, String firstName, String lastName, String password) {
        this.email = email;
        this. firstName = firstName;
        this.lastName = lastName;
        this.password = password;

        this.favorites = new ArrayList<UserFavorite>();
    }

    public List<UserFavorite> getFavorites() {
        return this.favorites;
    }

    public void addToFavorites(String id, String name) {
        favorites.add(new UserFavorite(id, name));
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean matchPassword(String password) {
           return (this.password == password) ? true:false;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
