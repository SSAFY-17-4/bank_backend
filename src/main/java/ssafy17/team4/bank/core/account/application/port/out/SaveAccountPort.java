package ssafy17.team4.bank.core.account.application.port.out;

import ssafy17.team4.bank.core.account.domain.model.Account;

public interface SaveAccountPort {

    void save(Account account);
}
