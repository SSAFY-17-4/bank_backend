package ssafy17.team4.bank.core.account.adapter.out.persistence.entity;

import lombok.*;

import java.time.LocalDateTime;

/**
 * AccountStatusLog 테이블의 엔티티 클래스 (JDBC/MyBatis용)
 * 계좌 상태 변경 이력을 추적하는 감사 로그
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountStatusLogEntity {

    /**
     * 계좌 상태 로그 고유 ID
     */
    private Long id;

    /**
     * 계좌 ID (FK)
     */
    private Long accountId;

    /**
     * 이전 상태 (ACTIVE / FROZEN / CLOSED)
     */
    private String previousStatus;

    /**
     * 새로운 상태 (ACTIVE / FROZEN / CLOSED)
     */
    private String newStatus;

    /**
     * 변경 사유 코드
     */
    private String reasonCode;

    /**
     * 변경 주체 (SYSTEM / ADMIN / BATCH)
     */
    private String changedBy;

    /**
     * 생성일시
     */
    private LocalDateTime createdAt;
}
