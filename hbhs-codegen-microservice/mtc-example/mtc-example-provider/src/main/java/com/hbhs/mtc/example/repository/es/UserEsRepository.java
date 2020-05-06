package com.hbhs.mtc.example.repository.es;

import com.hbhs.mtc.example.domain.es.UserEsEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserEsRepository extends ElasticsearchRepository<UserEsEntity, String> {

}
