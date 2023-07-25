package ecommerce.ecommerce.repository;

import ecommerce.ecommerce.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    Optional<Product> findByProductName(String productName);
    List<Product> findByProductBrand(String productBrand);
}

