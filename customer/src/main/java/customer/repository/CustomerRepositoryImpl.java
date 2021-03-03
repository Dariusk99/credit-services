package customer.repository;

import customer.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Customer customer) {
        String sql = "insert into customer (CreditID, FirstName, Pesel, Surname) values (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, customer.getCreditID(), customer.getFirstName(), customer.getPesel(), customer.getSurname());
    }
}
