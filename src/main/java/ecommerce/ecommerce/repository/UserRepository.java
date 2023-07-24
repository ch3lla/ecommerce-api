package ecommerce.ecommerce.repository;

import com.mongodb.lang.NonNullApi;
import ecommerce.ecommerce.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    public User findByUsername(String username);
}
