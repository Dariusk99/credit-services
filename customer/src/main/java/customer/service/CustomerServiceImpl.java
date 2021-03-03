package customer.service;

import customer.model.Customer;
import customer.repository.CustomerRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepositoryImpl customerRepository;

    public CustomerServiceImpl(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customerRepository.save(customer) > 0) {
            return true;
        }

        return false;
    }
}
