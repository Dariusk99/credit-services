package customer.controller;

import customer.model.Customer;
import customer.service.CustomerService;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void CreateCustomer(Customer customer) {
        customerService.saveCustomer(customer);
    }
}
