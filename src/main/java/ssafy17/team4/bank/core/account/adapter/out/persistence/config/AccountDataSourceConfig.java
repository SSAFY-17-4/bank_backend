package ssafy17.team4.bank.core.account.adapter.out.persistence.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AccountDataSourceProperties.class)
public class AccountDataSourceConfig {

    @Bean(name = "accountDataSource")
    public DataSource accountDataSource(AccountDataSourceProperties props) {
        return DataSourceBuilder.create()
            .url(props.getUrl())
            .username(props.getUsername())
            .password(props.getPassword())
            .driverClassName(props.getDriverClassName())
            .build();
    }
}
