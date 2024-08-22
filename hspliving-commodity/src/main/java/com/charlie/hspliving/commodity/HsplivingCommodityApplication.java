package com.charlie.hspliving.commodity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 如果在DAO中没有加上注解@Mapper,需要在主启动类上加上注解@MapperScan指定需要扫描的DAO包
//@MapperScan("com.charlie.hspliving.commodity.dao")
@SpringBootApplication
public class HsplivingCommodityApplication {
    public static void main(String[] args) {
        SpringApplication.run(HsplivingCommodityApplication.class, args);
    }
}
