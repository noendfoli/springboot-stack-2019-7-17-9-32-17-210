package com.tw.apistackbase;

import com.tw.apistackbase.entity.CriminalCase;
import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.repository.ProcuratorateRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ProcuratorateTest {
    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Test
    public void should_return_exception_when_name_null() {
        //given
        Procuratorate procuratorate = new Procuratorate();
        //when// /then
        Assertions.assertThrows(Exception.class,()->{
           procuratorateRepository.saveAndFlush(procuratorate);
        });

    }

}
