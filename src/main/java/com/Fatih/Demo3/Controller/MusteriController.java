package com.Fatih.Demo3.Controller;

import com.Fatih.Demo3.Model.Musteri;
import com.Fatih.Demo3.Service.MusteriService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/Musteriler")
@AllArgsConstructor
public class MusteriController {
   private final MusteriService musteriService;

   @GetMapping
   public ResponseEntity<List<Musteri>> getMusteriler(){
      return new ResponseEntity<>(musteriService.getMusteriler(), OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Musteri> getMusteri(@PathVariable String id){
      return new ResponseEntity<>(getMusteriById(id),OK);
   }

   @PostMapping
   public ResponseEntity<Musteri> createMusteri(@RequestBody Musteri newMusteri){
      return new ResponseEntity<>(musteriService.createMusteri(newMusteri), CREATED);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Void> changeMusteri(@PathVariable String id,@RequestBody Musteri newMusteri){
      musteriService.updateMusteri(id,newMusteri);
      return new ResponseEntity<>(OK);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteMusteri(@PathVariable String id){
      musteriService.deleteMusteri(id);
      return new ResponseEntity<>(OK);
   }

   private Musteri getMusteriById(String id)
   {
      return musteriService.getMusteriById(id);
   }

}


