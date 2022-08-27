package com.Fatih.Demo3.Service;

import com.Fatih.Demo3.Model.Musteri;
import com.Fatih.Demo3.Repository.MusteriRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class MusteriService {
    private final MusteriRepository musteriRepository;

    public List<Musteri> getMusteriler() {

        return musteriRepository.findAll();
    }

    public Musteri createMusteri(Musteri newMusteri) {

        return musteriRepository.save(newMusteri);
    }

    public void deleteMusteri(String id) {

        musteriRepository.deleteById(id);
    }

    public Musteri getMusteriById(String id) {
        return musteriRepository.findById(id)
                .orElseThrow(()->new RuntimeException("il bulunamadi"));
    }

    public void updateMusteri(String id, Musteri newMusteri) {
        Musteri oldMusteri=getMusteriById(id);
        oldMusteri.setName(newMusteri.getName());
        oldMusteri.setSurname(newMusteri.getSurname());
        musteriRepository.save(oldMusteri);
    }
}




