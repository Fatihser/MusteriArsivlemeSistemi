package com.Fatih.Demo3.Repository;

import com.Fatih.Demo3.Model.Dosya;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DosyaRepository extends MongoRepository<Dosya,String> {
    List<Dosya> findByMusteriId(String musteriId);
}
