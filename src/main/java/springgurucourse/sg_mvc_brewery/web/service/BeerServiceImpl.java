package springgurucourse.sg_mvc_brewery.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springgurucourse.sg_mvc_brewery.web.model.BeerDTO;

import java.util.UUID;

@Slf4j
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

    @Override
    public UUID saveBeer(BeerDTO beerDTO) {
        return UUID.randomUUID();
    }

    @Override
    public void updateBeer(UUID id, BeerDTO updateBeerDTO) {
        //todo - make implementation for update method
    }

    @Override
    public void deleteBeerById(UUID id) {
        log.debug("Deleting beer...");
        //todo - make implementation for delete by id method
    }
}
