package com.zwy.accounting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


// 等于 @Configuration（Spring xml配置）+@EnableAutoConfiguration（自动配置）+@ComponentScan（可发现和装配一些bean）
@SpringBootApplication
@EnableTransactionManagement//开启事务，配合service的@Transactional注解
@MapperScan("com.zwy.accounting.dao")//不加这个mapper AutoWired会失败，或者给每个dao加@Mapper注解
//要做用户系统的话，可以将用户名加入url中。或者作为参数，每次请求都带上。
public class AccountingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountingServerApplication.class, args);
    }

}
