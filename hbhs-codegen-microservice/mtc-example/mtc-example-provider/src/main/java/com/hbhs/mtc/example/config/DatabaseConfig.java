package com.hbhs.mtc.example.config;

import com.hbhs.common.datasource.autoconfig.DataSourceAutoConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@Import(DataSourceAutoConfig.class)
public class DatabaseConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ds);
        sqlSessionFactoryBean.afterPropertiesSet();
        SqlSessionFactory factory = sqlSessionFactoryBean.getObject();
//        factory.getConfiguration().setMapUnderscoreToCamelCase(true);

        return factory;
    }
}
