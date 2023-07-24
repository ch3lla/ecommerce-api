package ecommerce.ecommerce.service;

import ecommerce.ecommerce.model.User;
import ecommerce.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> allUsers () {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){ return userRepository.findById(id); }

    public User createUser(User user){
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(user.getUsername()));
        if (userOptional.isPresent()){
            throw new IllegalStateException("User already exists");
        }
        return userRepository.save(user);
    }

    public void deleteUser(ObjectId id){
        boolean exists = userRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }

}
