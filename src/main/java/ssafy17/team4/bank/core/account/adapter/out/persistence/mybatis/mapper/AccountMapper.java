package ssafy17.team4.bank.core.account.adapter.out.persistence.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import ssafy17.team4.bank.core.account.adapter.out.persistence.mybatis.entity.AccountEntity;

@Mapper
public interface AccountMapper {
    void insertAccount(AccountEntity entity);
}
