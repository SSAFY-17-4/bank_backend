package ssafy17.team4.bank.core.account.adapter.out.persistence.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "bank.account.datasource")
public class AccountDataSourceProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
