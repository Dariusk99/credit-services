package product.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import product.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private final JdbcTemplate jdbcTemplate;

    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int save(Product product) {
        String sql = "insert into product (CreditID, ProductName, Value) values(?, ?, ?)";
        return jdbcTemplate.update(sql, product.getCreditID(), product.getProductName(), product.getValue());
    }
}