package ma.wem.customerservice.service;

import ma.wem.customerservice.dao.entities.Customer;
import ma.wem.customerservice.dao.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerManager{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer addCustomer(Customer customer) {
        try {
            return customerRepository.save(customer);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public boolean deleteCustomer(Customer customer) {

         try {
             customerRepository.delete(customer);
             return true;
         }catch (Exception e)
         {
             System.out.println(e.getMessage());
         }
         return false;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        try {
            if (customerRepository.existsById(customer.getId())) {
                return customerRepository.save(customer);

            }else {
                System.out.println("Customer not found!");
                return null;
            }



            }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }
}
