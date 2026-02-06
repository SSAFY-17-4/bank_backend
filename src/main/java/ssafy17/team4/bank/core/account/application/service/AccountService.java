package ssafy17.team4.bank.core.account.application.service;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ssafy17.team4.bank.core.account.adapter.out.persistence.AccountPersistenceAdapter;
import ssafy17.team4.bank.core.account.application.port.in.AccountUseCase;
import ssafy17.team4.bank.core.account.application.port.out.SaveAccountPort;
import ssafy17.team4.bank.core.account.domain.model.Account;

@Component
@RequiredArgsConstructor
public class AccountService implements AccountUseCase {
    private final AccountPersistenceAdapter accountPersistenceAdapter;
    private final SaveAccountPort saveAccountPort;

    @Override
    public void createAccount(Account account) {
        saveAccountPort.save(account);
    }
}
