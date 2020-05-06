package com.hbhs.mtc.example.repository.es;

import com.hbhs.mtc.example.domain.es.UserEsEntity;
import com.hbhs.mtc.example.repository.BaseEsTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

public class UserRepositoryTest extends BaseEsTest {

    @Autowired
    private ElasticsearchRestTemplate restTemplate;
    @Autowired
    private UserEsRepository repository;


    @Test
    public void testIndex(){
        restTemplate.deleteIndex(UserEsEntity.class);
        restTemplate.createIndex(UserEsEntity.class);
        restTemplate.putMapping(UserEsEntity.class);
        restTemplate.refresh(UserEsEntity.class);
    }

    @Test
    public void addUser() throws Exception{
        UserEsEntity entity = new UserEsEntity();
        // TODO
        repository.save(entity);
        Thread.sleep(10000L);
    }
}
