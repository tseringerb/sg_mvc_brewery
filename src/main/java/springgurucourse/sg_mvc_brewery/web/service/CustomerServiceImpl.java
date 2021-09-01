package springgurucourse.sg_mvc_brewery.web.service;

import org.springframework.stereotype.Service;
import springgurucourse.sg_mvc_brewery.web.model.CustomerDTO;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Dick")
                .build();
    }
}
