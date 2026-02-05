package ssafy17.team4.bank.core.account.adapter.out.persistence.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(
    basePackages = "ssafy17.team4.bank.core.account.adapter.out.persistence.mapper",
    sqlSessionTemplateRef = "accountSqlSessionTemplate"
)
public class AccountMyBatisConfig {

    @Bean(name = "accountSqlSessionFactory")
    public SqlSessionFactory accountSqlSessionFactory(
        @Qualifier("accountDataSource") DataSource dataSource
    ) throws Exception {

        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);

        factory.setMapperLocations(
            new PathMatchingResourcePatternResolver()
                .getResources("classpath:account/db/mybatis/**/*.xml")
        );

        return factory.getObject();
    }

    @Bean(name = "accountSqlSessionTemplate")
    public SqlSessionTemplate accountSqlSessionTemplate(
        @Qualifier("accountSqlSessionFactory") SqlSessionFactory factory
    ) {
        return new SqlSessionTemplate(factory);
    }
}
