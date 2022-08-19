package surajitg.mfanalytics.api;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;

@Repository
public interface UserRepository extends CosmosRepository<User, String> {
    List<User> findByFirstName(String firstName);
    long countByFirstName(String firstName);
    // User findOne(String id);

    @Query("select * from c where c.firstName = @firstName and c.lastName = @lastName")
    List<User> getUsersByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("select * from c offset @offset limit @limit")
    List<User> getUsersWithOffsetLimit(@Param("offset") int offset, @Param("limit") int limit);

    @Query("select value count(1) from c where c.firstName = @firstName")
    long getNumberOfUsersWithFirstName(@Param("firstName") String firstName);

    @Query("select top 1 * from c where c.email = @email and c.password = @password")
    User validateUserByPassword(@Param("email") String email, @Param("password") String password);
    
}
