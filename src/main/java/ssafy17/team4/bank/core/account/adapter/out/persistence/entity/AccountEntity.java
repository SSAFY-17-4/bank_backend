package ssafy17.team4.bank.core.account.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Account 테이블의 엔티티 클래스 (JDBC/MyBatis용)
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {

    /**
     * 계좌 고유 ID
     */
    private Long id;

    /**
     * 고객 ID
     */
    private Long customerId;

    /**
     * 계좌 유형 코드 (운영계에서 관리)
     */
    private String productCode;

    /**
     * 통화 코드 (KRW, USD 등)
     */
    private String currency;

    /**
     * 계좌 상태 (ACTIVE / FROZEN / CLOSED)
     */
    private String status;

    /**
     * 생성일시
     */
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    private LocalDateTime updatedAt;

    /**
     * 삭제일시 (소프트 삭제)
     */
    private LocalDateTime deletedAt;
}
