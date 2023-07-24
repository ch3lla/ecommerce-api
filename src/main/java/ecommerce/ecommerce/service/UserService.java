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
    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> allUsers () {
        return userRepository.findAll();
    }
    public Optional<User> findById(ObjectId id){ return userRepository.findById(id); }

}
