package ssafy17.team4.bank.core.account.global.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountFlywayConfig {

    @Bean
    public Flyway accountFlyway(
        @Qualifier("accountDataSource") DataSource dataSource
    ) {

        Flyway flyway = Flyway.configure()
            .dataSource(dataSource)
            .locations("classpath:account/db/migration")
            .baselineOnMigrate(true)
            .baselineVersion("1")
            .load();

        flyway.migrate();

        return flyway;
    }
}
