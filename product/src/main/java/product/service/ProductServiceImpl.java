package product.service;

import org.springframework.stereotype.Service;
import product.model.Product;
import product.repository.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepositoryImpl productRepository;

    public ProductServiceImpl(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean addProduct(Product product) {
        if(productRepository.save(product) > 0) {
            return true;
        }

        return false;
    }
}
