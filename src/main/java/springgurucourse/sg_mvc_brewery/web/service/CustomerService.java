package springgurucourse.sg_mvc_brewery.web.service;

import springgurucourse.sg_mvc_brewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID customerId);
}
