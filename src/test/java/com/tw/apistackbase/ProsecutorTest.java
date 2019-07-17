package com.tw.apistackbase;

import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.repository.ProcuratorateRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ProsecutorTest {
    private ProcuratorateRepository procuratorateRepository;
//    @Test
//    public void should_return_procuratorate_when_find_by_id() {
//        //given
//        Procuratorate procuratorate = new Procuratorate();
//        procuratorate.setProcuratorateName("owen");
//        procuratorate.setProcuratorateId(1);
//        //when/
//        procuratorateRepository.saveAndFlush(procuratorate);
//        Procuratorate procuratorate1 = procuratorateRepository.findProcuratorateByprocuratorateId(procuratorate.getProcuratorateId());
//        // / /then
//       Assertions.assertEquals("owen",procuratorate1.getProcuratorateName());
//
//    }
}
