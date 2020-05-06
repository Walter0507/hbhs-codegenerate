package com.hbhs.mtc.example;

import com.hbhs.common.tools.io.PropertiesLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableFeignClients(basePackages = {"com.hbhs.mtc.example"})
@EnableEurekaClient
@ComponentScan(basePackages = {"com.hbhs.mtc.example"})
@MapperScan(basePackages = {"com.hbhs.mtc.example.repository.dao.mapper"})
@Slf4j
public class MtcExampleApplicationBoot {

    public static void main(String[] args) {
        try {
            PropertiesLoader.folderPath = "/opt/configs/mtc-example/";
            PropertiesLoader.loadFile("mtc-example.properties");
        }catch (Exception e){
            log.error("Failed to load config file", e);
        }
        SpringApplication.run(MtcExampleApplicationBoot.class);
    }
}
