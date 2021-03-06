package com.hbhs.mtc.example.repository;

import com.hbhs.mtc.example.config.DatabaseConfig;
import com.hbhs.common.tools.io.PropertiesLoader;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(value = {"com.hbhs.mtc.example.repository.dao"})
@MapperScan(value = {"com.hbhs.mtc.example.repository.dao.mapper"})
@Import({DatabaseConfig.class})
@Slf4j
public class BaseDaoTest {

    static {
        try {
            PropertiesLoader.folderPath = "/opt/configs/mtc-example/";
            PropertiesLoader.loadFile("mtc-example.properties");
        }catch (Exception e){
            log.error("Failed to load properties file", e);
        }
    }
}
