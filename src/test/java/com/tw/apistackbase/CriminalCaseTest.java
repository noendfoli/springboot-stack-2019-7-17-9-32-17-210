package com.tw.apistackbase;

import com.tw.apistackbase.entity.CriminalCase;
import com.tw.apistackbase.repository.CriminalCaseRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CriminalCaseTest {
    @Autowired
    private CriminalCaseRepository criminalCaseRepository;

    @Test
    public void should_return_size_when_the_add() {
        //given
        CriminalCase criminalCase1 = new CriminalCase("xxCase",System.currentTimeMillis());
        criminalCaseRepository.save(criminalCase1);
        CriminalCase criminalCase2= new CriminalCase("yyCase",System.currentTimeMillis());
        criminalCaseRepository.save(criminalCase2);
        CriminalCase criminalCase3 = new CriminalCase("zzCase",System.currentTimeMillis());
        criminalCaseRepository.save(criminalCase3);
        CriminalCase criminalCase4= new CriminalCase("mmCase",System.currentTimeMillis());
        criminalCaseRepository.save(criminalCase4);

        //when
        List<CriminalCase> caseList = criminalCaseRepository.findAll();
        // /then
        Assertions.assertEquals(4,caseList.size());
    }

    @Test
    public void should_can_add_when_property_null() {
        //given
        CriminalCase criminalCase1 = new CriminalCase();
        //when// /then
        Assertions.assertThrows(Exception.class,()->{
            criminalCaseRepository.saveAndFlush(criminalCase1);

        });
    }


}
