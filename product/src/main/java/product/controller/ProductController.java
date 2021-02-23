package product.controller;

import product.model.Product;
import product.service.ProductService;

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    public void CreateProduct(Product product) {
        productService.saveProduct(product);
    }
}
