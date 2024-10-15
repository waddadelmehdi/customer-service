package ma.wem.customerservice.service;

import ma.wem.customerservice.dao.entities.Customer;

import java.util.List;

public interface CustomerManager {
    public Customer addCustomer(Customer customer);
    public boolean deleteCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public List<Customer> getAllCustomer();
    public Customer getCustomerById(Long id);
}
