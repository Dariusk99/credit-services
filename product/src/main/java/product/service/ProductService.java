package product.service;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import product.model.Product;
import product.repository.ProductRepository;

public class ProductService implements ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProductService(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveProduct(Product product) {
        jdbcTemplate.update("insert into product (productname, value) values (:productName, :value)",
                new BeanPropertySqlParameterSource(product));
    }
}
