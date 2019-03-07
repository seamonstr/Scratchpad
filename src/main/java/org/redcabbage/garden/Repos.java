package org.redcabbage.garden;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:postgresql.properties")
public class Repos {
    @Value("${username}")
    String username;

    @Value("${password}")
    String password;

    @Value("${url}")
    String url;

    @Bean
    DataSource getDatasource() {
        PGSimpleDataSource ret = new PGSimpleDataSource();
        ret.setUser(username);
        ret.setPassword(password);
        ret.setUrl(url);
        return ret;
    }

    @Bean
    JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDatasource());
    }
}
