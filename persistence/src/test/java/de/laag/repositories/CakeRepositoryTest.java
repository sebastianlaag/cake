package de.laag.repositories;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import de.laag.config.DatabaseConfig;
import de.laag.entities.Cake;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@DataJpaTest
public class CakeRepositoryTest {

    @Autowired
    private CakeRepository cakeRepository;

    @Test
    public void saveAndFindOne() {
        final Date date = new Date();
        final Cake cake = new Cake();
        cake.setDate(date);
        cake.setDescription("Käsekuchen");
        final Cake test = cakeRepository.save(cake);
        final Cake findOne = cakeRepository.findOne(test.getId());
        assertThat(cake.getDate()).isEqualTo(findOne.getDate());
    }

}
