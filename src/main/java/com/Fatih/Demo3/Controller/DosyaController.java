package com.Fatih.Demo3.Controller;

import com.Fatih.Demo3.Model.Dosya;
import com.Fatih.Demo3.Service.DosyaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/Dosyalar")
@AllArgsConstructor
public class DosyaController {
    private final DosyaService dosyaService;

    @GetMapping
    public ResponseEntity<List<Dosya>> getDosyalar(@RequestParam(required = false) String musteriId){
        return new ResponseEntity<>(dosyaService.getDosyalar(musteriId), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dosya> getDosya(@PathVariable String id){
        return new ResponseEntity<>(getDosyaNameById(id),OK);
    }

    @PostMapping
    public ResponseEntity<Dosya> createDosya(@RequestBody Dosya newDosya){
        return new ResponseEntity<>(dosyaService.createDosya(newDosya), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeDosya(@PathVariable String id,@RequestBody Dosya newDosya){
        dosyaService.updateDosya(id,newDosya);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDosya(@PathVariable String id){
        dosyaService.deleteDosya(id);
        return new ResponseEntity<>(OK);
    }

    private Dosya getDosyaNameById(String id)
    {
        return dosyaService.getDosyaById(id);
    }
}
