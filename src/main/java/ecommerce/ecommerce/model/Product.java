package ecommerce.ecommerce.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
@Getter
@Setter
public class Product {
    @Id
    private ObjectId id;
    private String name;
    private String image;
    private int quantity;
    private int price;
    private String description;
    private Category category;
}
