package ssafy17.team4.bank.core.account.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountStatus {
    ACTIVE("ACTIVE", "활성 계좌"),
    INACTIVE("INACTIVE", "휴먼 계좌"),
    CLOSED("CLOSED", "해지 계좌");

    private final String code;
    private final String description;
}
