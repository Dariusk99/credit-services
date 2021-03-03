package customer.repository;

import customer.model.Customer;

public interface CustomerRepository {

    int save(Customer customer);
}
