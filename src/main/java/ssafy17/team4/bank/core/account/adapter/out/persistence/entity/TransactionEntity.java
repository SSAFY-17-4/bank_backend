package ssafy17.team4.bank.core.account.adapter.out.persistence.entity;

import lombok.*;

import java.time.LocalDateTime;

/**
 * Transaction 테이블의 엔티티 클래스 (JDBC/MyBatis용)
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class TransactionEntity {

    /**
     * 거래 고유 ID
     */
    private Long id;

    /**
     * 비즈니스 유형 (TRANSFER / INTEREST / FEE / ADJUSTMENT 등)
     */
    private String bizType;

    /**
     * 거래 유형 (NORMAL / REVERSAL / CORRECTION)
     */
    private String txType;

    /**
     * 거래 상태 (INIT / POSTED / CANCELED)
     */
    private String status;

    /**
     * 운영 거래 ID (멱등 키, UNIQUE)
     */
    private String operationTxId;

    /**
     * 사건 발생 시각 (사용자 기준)
     */
    private LocalDateTime occurredAt;

    /**
     * 원장 반영 확정 시각 (nullable)
     */
    private LocalDateTime postedAt;
}
