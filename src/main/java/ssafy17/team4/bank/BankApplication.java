package ssafy17.team4.bank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ssafy17.team4.bank.core.account.adapter.out.persistence.mybatis.mapper") // 실제 패키지 경로로 수정하소서
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

}
