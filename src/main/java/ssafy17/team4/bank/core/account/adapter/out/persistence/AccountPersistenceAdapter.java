package ssafy17.team4.bank.core.account.adapter.out.persistence;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ssafy17.team4.bank.core.account.adapter.out.persistence.mybatis.entity.AccountEntity;
import ssafy17.team4.bank.core.account.adapter.out.persistence.mybatis.mapper.AccountMapper;
import ssafy17.team4.bank.core.account.application.port.out.SaveAccountPort;
import ssafy17.team4.bank.core.account.domain.model.Account;

@Component
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements SaveAccountPort {

    private final AccountMapper accountMapper;

    @Override
    public void save(Account account) {
        AccountEntity entity = AccountEntity.from(account);

        accountMapper.insertAccount(entity);
    }
}
