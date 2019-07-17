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

    @Test
    public void should_return_criminal_case_when_find_by_id() {
        //given
        CriminalCase criminalCase1 = new CriminalCase(1,"xxCase",System.currentTimeMillis());
        criminalCaseRepository.saveAndFlush(criminalCase1);
        CriminalCase criminalCase2= new CriminalCase(2,"yyCase",System.currentTimeMillis());
        criminalCaseRepository.saveAndFlush(criminalCase2);

        //when//
        CriminalCase crinial = criminalCaseRepository.findById(Integer.valueOf(1)).get();
        // /then
       Assertions.assertEquals("xxCase",crinial.getCaseName());
    }

    @Test
    public void should_return_order_by_all_case_when_find_crinimal_case_order_by() {
        //given
        CriminalCase criminalCase1 = new CriminalCase(1,"xxCase",System.currentTimeMillis());
        criminalCaseRepository.saveAndFlush(criminalCase1);
        CriminalCase criminalCase2= new CriminalCase(2,"yyCase",System.currentTimeMillis());
        criminalCaseRepository.saveAndFlush(criminalCase2);
        //when//
        List<CriminalCase> crinialList = criminalCaseRepository.findByOrderByTimeDesc();
        // /then
        Assertions.assertEquals("yyCase",crinialList.get(0).getCaseName());
    }

    @Test
    public void should_return_all_same_name_case_when_find_crinimal_case_by_name() {
        //given
        CriminalCase criminalCase1 = new CriminalCase(1,"xxCase",System.currentTimeMillis());
        criminalCaseRepository.saveAndFlush(criminalCase1);
        CriminalCase criminalCase2= new CriminalCase(2,"yyCase",System.currentTimeMillis());
        criminalCaseRepository.saveAndFlush(criminalCase2);
        CriminalCase criminalCase3 = new CriminalCase(3,"xxCase",System.currentTimeMillis());
        criminalCaseRepository.saveAndFlush(criminalCase3);
        //when//
        List<CriminalCase> crinialList = criminalCaseRepository.findAllByCaseName("xxCase");
        // /then
        Assertions.assertEquals(crinialList.get(1).getCaseName(),crinialList.get(0).getCaseName());
    }

    @Test
    public void should_delete_case_when_delete_crinimal_case_by_id() {
        //given
        CriminalCase criminalCase1 = new CriminalCase(1,"xxCase",System.currentTimeMillis());
        criminalCaseRepository.saveAndFlush(criminalCase1);
        CriminalCase criminalCase2= new CriminalCase(2,"yyCase",System.currentTimeMillis());
        criminalCaseRepository.saveAndFlush(criminalCase2);
        CriminalCase criminalCase3 = new CriminalCase(3,"xxCase",System.currentTimeMillis());
        criminalCaseRepository.saveAndFlush(criminalCase3);
        //when//
        criminalCaseRepository.deleteById(1);
        List<CriminalCase> caseList = criminalCaseRepository.findAll();

        // /then
        Assertions.assertEquals(2,caseList.size());
    }
}
