package ssafy17.team4.bank.core.account.adapter.out.persistence.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * AccountBalance 테이블의 엔티티 클래스 (JDBC/MyBatis용)
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountBalanceEntity {

    /**
     * 계좌 ID (PK이자 FK)
     */
    private Long accountId;

    /**
     * 잔액 (DECIMAL(18,2))
     */
    private BigDecimal balanceAmount;

    /**
     * 사용 가능 금액 (DECIMAL(18,2))
     */
    private BigDecimal availableAmount;

    /**
     * 통화 코드 (KRW, USD 등)
     */
    private String currency;

    /**
     * 마지막 거래 ID (nullable)
     */
    private Long lastTransactionId;

    /**
     * 생성일시
     */
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    private LocalDateTime updatedAt;
}
