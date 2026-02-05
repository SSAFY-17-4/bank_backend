package ssafy17.team4.bank.core.account.adapter.out.persistence.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class AccountTransactionConfig {

    @Bean(name = "accountTransactionManager")
    public PlatformTransactionManager accountTransactionManager(
        @Qualifier("accountDataSource") DataSource dataSource
    ) {
        return new DataSourceTransactionManager(dataSource);
    }
}
