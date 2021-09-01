package springgurucourse.sg_mvc_brewery.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springgurucourse.sg_mvc_brewery.web.model.BeerDTO;
import springgurucourse.sg_mvc_brewery.web.service.BeerService;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveBeer(BeerDTO beerDTO){ //wildcard for raw type

        UUID uuid = beerService.saveBeer(beerDTO);  //different from course, lecture 31
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + uuid);

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
