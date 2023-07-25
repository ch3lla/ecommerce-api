package ecommerce.ecommerce.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Getter
@Setter
public class Product {
    @Id
    private ObjectId id;
    private String productName;
    //private String image;
    private int quantity;
    private double price;
    private String productDescription;
    private String productType;
    private String productBrand;
}
