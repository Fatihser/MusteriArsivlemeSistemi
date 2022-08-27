package com.Fatih.Demo3.Service;

import com.Fatih.Demo3.Model.Dosya;
import com.Fatih.Demo3.Repository.DosyaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class DosyaService {

    private final DosyaRepository dosyaRepository;

    public List<Dosya> getDosyalar(String musteriId) {
        if (musteriId==null){
            return dosyaRepository.findAll();
        }else{
            return dosyaRepository.findByMusteriId(musteriId);
        }
    }

    public Dosya createDosya(Dosya newMusteri) {

        return dosyaRepository.save(newMusteri);
    }

    public void deleteDosya(String id) {

        dosyaRepository.deleteById(id);
    }

    public Dosya getDosyaById(String id) {
        return dosyaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("il bulunamadi"));
    }

    public void updateDosya(String id, Dosya newDosya) {
        Dosya oldDosya=getDosyaById(id);
        oldDosya.setDosyaName(newDosya.getDosyaName());
        dosyaRepository.save(oldDosya);
    }

}