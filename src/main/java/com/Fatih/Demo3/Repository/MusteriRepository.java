package com.Fatih.Demo3.Repository;

import com.Fatih.Demo3.Model.Musteri;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusteriRepository extends MongoRepository<Musteri,String> {

}


