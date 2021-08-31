package springgurucourse.sg_mvc_brewery.web.service;

import org.springframework.stereotype.Service;
import springgurucourse.sg_mvc_brewery.web.model.BeerDTO;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName("Hard Rock")
                .beerStyle("IPA")
                .build();
    }
}
