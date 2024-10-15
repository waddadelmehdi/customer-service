package ma.wem.customerservice.web;

import ma.wem.customerservice.dao.entities.Customer;
import ma.wem.customerservice.service.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {
    @Autowired
    private CustomerManager customerManager;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerManager.getAllCustomer();
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerManager.addCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerManager.updateCustomer(customer);
    }

    @DeleteMapping("/deleteCustomer")
    public boolean deleteCustomer(Customer customer){
        customerManager.deleteCustomer(customer);
        return true;
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerManager.getCustomerById(id);
    }





}
