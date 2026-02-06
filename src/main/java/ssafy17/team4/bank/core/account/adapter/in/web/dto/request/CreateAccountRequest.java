package ssafy17.team4.bank.core.account.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ssafy17.team4.bank.core.account.domain.model.Account;

public record CreateAccountRequest(
    @NotNull Long customerId,
    @NotBlank String productCode,
    @NotBlank String currency
) {
    public Account toDomain() {
        return Account.create(customerId, productCode, currency);
    }
}
