package ssafy17.team4.bank.core.account.adapter.out.persistence.mybatis.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * TransactionEntry 테이블의 엔티티 클래스 (JDBC/MyBatis용)
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class TransactionEntryEntity {

    /**
     * 거래 ID (복합키 PK, FK)
     */
    private Long transactionId;

    /**
     * 라인 번호 (복합키 PK) - 1, 2, 3, ...
     */
    private Integer lineNo;

    /**
     * 계좌 ID (FK)
     */
    private Long accountId;

    /**
     * 차대 구분 ('D' = Debit / 'C' = Credit)
     */
    private String dcType;

    /**
     * 금액 (항상 양수, DECIMAL(18,2))
     */
    private BigDecimal amount;

    /**
     * 이 분개 반영 직후 잔액 (nullable, DECIMAL(18,2))
     */
    private BigDecimal balanceAfter;

    /**
     * 생성일시
     */
    private LocalDateTime createdAt;
}
