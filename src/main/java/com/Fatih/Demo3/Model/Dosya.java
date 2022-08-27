package com.Fatih.Demo3.Model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dosya {
    @Id
    private String id;

    private Date createDate=new Date();

    private String dosyaName;

    private String musteriId;

}
