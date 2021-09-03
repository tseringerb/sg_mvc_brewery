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
    public ResponseEntity<?> saveBeer(@RequestBody BeerDTO beerDTO){ //wildcard for raw type
        //@RequestBody mean that passing data has Json or Xml format
        UUID uuid = beerService.saveBeer(beerDTO);  //different from course, lecture 31
        // need pass UUID as string in Json
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + uuid);

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBeer(UUID id, @RequestBody BeerDTO updateBeerDTO){
        beerService.updateBeer(id, updateBeerDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/delete/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID id){
        beerService.deleteBeerById(id);
    }
}
