package ssafy17.team4.bank.core.account.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ssafy17.team4.bank.core.account.domain.enums.AccountStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    private long id;
    private long customerId;

    private String productCode;
    private String currency;
    private AccountStatus status;

    public static Account create(long customerId, String productCode, String currency) {
        return new Account(0, customerId, productCode, currency, AccountStatus.ACTIVE);
    }

}
