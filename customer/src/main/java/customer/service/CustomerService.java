package customer.service;

import customer.model.Customer;
import customer.repository.CustomerRepository;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class CustomerService implements CustomerRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CustomerService(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveCustomer(Customer customer) {
        jdbcTemplate.update("insert into customer (creditID, firstName, pesel, surname) values (:productName, :value)",
                new BeanPropertySqlParameterSource(customer));
    }
}
