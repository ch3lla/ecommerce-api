package ecommerce.ecommerce.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "cart")
@Getter
@Setter
public class Cart {
    @Id
    private ObjectId id;
    private User customer;
    @DocumentReference
    private List<Product> products;

    private Cart(){
        products = new ArrayList<>();
    }
}
