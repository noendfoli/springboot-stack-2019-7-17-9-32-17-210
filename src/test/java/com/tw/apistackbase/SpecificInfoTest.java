package com.tw.apistackbase;

import com.tw.apistackbase.entity.CriminalCase;
import com.tw.apistackbase.entity.SpecificInfo;
import com.tw.apistackbase.repository.SpecificInfoRepository;
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
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpecificInfoTest {
    @Autowired
    private SpecificInfoRepository specificInfoRepository;

    @Test
    public void should_return_size_when_the_add() {
        //given
        SpecificInfo specificInfo = new SpecificInfo();
        //when// /then
        Assertions.assertThrows(Exception.class,()->{
            specificInfoRepository.saveAndFlush(specificInfo);
        });
    }

    @Test
    public void should_return_speciific_info_when_findbyid() {
        //given
        SpecificInfo specificInfo = new SpecificInfo(1,"xx in xx do some thing","xx in xx did'n do somethin");
        //when
        specificInfoRepository.saveAndFlush(specificInfo);
        SpecificInfo spe = specificInfoRepository.findById(1).get();
        // /then
        Assertions.assertEquals("xx in xx do some thing",spe.getObjectiveInfo());

    }
}
