package ssafy17.team4.bank.core.account.adapter.in.web;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ssafy17.team4.bank.core.account.adapter.in.web.dto.request.AccountStatusRequest;
import ssafy17.team4.bank.core.account.adapter.in.web.dto.request.CreateAccountRequest;
import ssafy17.team4.bank.core.account.adapter.in.web.dto.request.TransferRequest;
import ssafy17.team4.bank.core.account.application.port.in.AccountUseCase;

@Component
@RequiredArgsConstructor
public class OperationInboundAdapter {
    final private AccountUseCase accountUseCase;

    public void createAccount(CreateAccountRequest request) {
        accountUseCase.createAccount(request.toDomain());
    }

    public void executeTransfer(TransferRequest request) {
    }

    public void updateAccountStatus(AccountStatusRequest request) {
    }

    // public CoreAccountBalanceResponse getAccountBalance(Long accountId) {
    //     return null;
    // }
}
