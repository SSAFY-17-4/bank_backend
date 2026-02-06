package ssafy17.team4.bank.core.account.application.port.in;

import ssafy17.team4.bank.core.account.domain.model.Account;

public interface AccountUseCase {

    public void createAccount(Account account);
}
