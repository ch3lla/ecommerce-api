package ecommerce.ecommerce.service;

import ecommerce.ecommerce.model.Product;
import ecommerce.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> allProducts (){
        return productRepository.findAll();
    }
    //public Optional<Product> getSingleProduct (String product_name){ return productRepository.findByProductName(product_name); }

    public Optional<Product> getSingleProduct (String productName) {
        return productRepository.findByProductName(productName);
    }

    public List<Product> getProductBrand (String productBrand) {
        return productRepository.findByProductBrand(productBrand);
    }

}
