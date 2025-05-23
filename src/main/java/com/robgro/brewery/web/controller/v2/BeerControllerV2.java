package com.robgro.brewery.web.controller.v2;

import com.robgro.brewery.services.v2.BeerServiceV2;
import com.robgro.brewery.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

//    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
//        this.beerServiceV2 = beerServiceV2;
//    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId) {

        log.info("beer Id is: " + beerId);

        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping    // POST -> create new beer
    public ResponseEntity handlePost(@NotNull @RequestBody BeerDtoV2 beerDto) {

        log.debug("in handle post ...");

        val savedDto = beerServiceV2.saveNewBeer(beerDto);

        val headers = new HttpHeaders();
        // todo add hostname to url --> "http://localhost:8080/api/v2/beer/"
        headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto) {
        beerServiceV2.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerServiceV2.deleteById(beerId);
    }
}
