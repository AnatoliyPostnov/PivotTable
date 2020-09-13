package com.postnov.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${data.source.url}")
    private String dataSourceUrl;

    @Value("${driver.class.name}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.type(org.sqlite.SQLiteDataSource.class);
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(dataSourceUrl);
        return dataSourceBuilder.build();
    }

}
