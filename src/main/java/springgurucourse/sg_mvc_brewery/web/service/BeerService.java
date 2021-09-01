package springgurucourse.sg_mvc_brewery.web.service;

import springgurucourse.sg_mvc_brewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    UUID saveBeer(BeerDTO beerDTO);
}
