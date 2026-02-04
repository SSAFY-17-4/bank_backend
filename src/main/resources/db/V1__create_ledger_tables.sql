-- =========================================================================
-- [계정계] 통합 원장 스키마
-- 1. 단독 PK는 'id'로 통일
-- 2. 참조/복합 PK는 정체성을 살려 'account_id', 'transaction_id' 유지
-- 3. account_type -> product_code 변경
-- =========================================================================

-- 1. 계좌 기본 정보 (Master)
CREATE TABLE IF NOT EXISTS `account` (
                                         `id`              BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                         `customer_id`     BIGINT UNSIGNED NOT NULL,
                                         `product_code`    VARCHAR(32)  NOT NULL,   -- DEPOSIT / LOAN / FEE / SUSPENSE
    `currency`        VARCHAR(3)   NOT NULL,   -- KRW, USD ...
    `status`          VARCHAR(16)  NOT NULL,   -- ACTIVE / FROZEN / CLOSED
    `created_at`      DATETIME(6)  NOT NULL,
    `updated_at`      DATETIME(6)  NOT NULL,
    `deleted_at`      DATETIME(6)  NULL,
    PRIMARY KEY (`id`),
    KEY `idx_account_customer_id` (`customer_id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- 2. 거래 마스터 (Transaction Header)
CREATE TABLE IF NOT EXISTS `transaction` (
                                             `id`              BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                             `biz_type`        VARCHAR(32)  NOT NULL,   -- TRANSFER / INTEREST / FEE / ADJUSTMENT ...
    `tx_type`         VARCHAR(16)  NOT NULL,   -- NORMAL / REVERSAL / CORRECTION
    `status`          VARCHAR(16)  NOT NULL,   -- INIT / POSTED / CANCELED
    `operation_tx_id` VARCHAR(64)  NOT NULL,   -- 멱등 키 (UK)
    `occurred_at`     DATETIME(6)  NOT NULL,
    `posted_at`       DATETIME(6)  NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_transaction_operation_tx_id` (`operation_tx_id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- 3. 거래 분개 엔트리 (Transaction Detail)
CREATE TABLE IF NOT EXISTS `transaction_entry` (
                                                   `transaction_id`  BIGINT UNSIGNED NOT NULL, -- PK 성분 (transaction.id 참조)
                                                   `line_no`         INT UNSIGNED    NOT NULL, -- PK 성분
                                                   `account_id`      BIGINT UNSIGNED NOT NULL,
                                                   `dc_type`         CHAR(1)         NOT NULL, -- 'D' / 'C'
    `amount`          DECIMAL(18,2)   NOT NULL,
    `balance_after`   DECIMAL(18,2)   NULL,
    `created_at`      DATETIME(6)     NOT NULL,
    PRIMARY KEY (`transaction_id`, `line_no`),
    KEY `idx_transaction_entry_account` (`account_id`),
    CONSTRAINT `fk_transaction_entry_tx`
    FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`),
    CONSTRAINT `fk_transaction_entry_account`
    FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- 4. 계좌 잔액 현황 (Account Extension)
CREATE TABLE IF NOT EXISTS `account_balance` (
                                                 `account_id`          BIGINT UNSIGNED NOT NULL, -- PK이자 FK (account.id 참조)
                                                 `balance_amount`      DECIMAL(18,2)   NOT NULL,
    `available_amount`    DECIMAL(18,2)   NOT NULL,
    `currency`       VARCHAR(3)      NOT NULL,
    `last_transaction_id` BIGINT UNSIGNED NULL,
    `created_at`          DATETIME(6)     NOT NULL,
    `updated_at`          DATETIME(6)     NOT NULL,
    PRIMARY KEY (`account_id`), -- [주군 강조] account_id를 PK로 사용
    KEY `idx_account_balance_last_tx` (`last_transaction_id`),
    CONSTRAINT `fk_account_balance_account`
    FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
    CONSTRAINT `fk_account_balance_tx`
    FOREIGN KEY (`last_transaction_id`) REFERENCES `transaction` (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- 5. 계좌 상태 변경 이력 (Audit Log)
CREATE TABLE IF NOT EXISTS `account_status_log` (
                                                    `id`                  BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                    `account_id`          BIGINT UNSIGNED NOT NULL,
                                                    `previous_status`     VARCHAR(16)     NOT NULL,
    `new_status`          VARCHAR(16)     NOT NULL,
    `reason_code`         VARCHAR(64)     NOT NULL,
    `changed_by`          VARCHAR(16)     NOT NULL,
    `created_at`          DATETIME(6)     NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_account_status_log_account` (`account_id`, `created_at`),
    CONSTRAINT `fk_account_status_log_account`
    FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
