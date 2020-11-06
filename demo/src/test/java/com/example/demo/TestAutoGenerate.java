package com.example.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAutoGenerate {

    @Test
    public void autoGenerate() {
        // Step1:代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // Step2:全局配置
        GlobalConfig gc = new GlobalConfig();
        // 填写代码生成的目录
        String projectPath = "D:\\Projects\\mybatis-plus\\demo";
        // 拼接出代码最终输出的目录
        gc.setOutputDir(projectPath + "/src/main/java");
        // 配置开发者信息
        gc.setAuthor("zlei");
        // 配置是否打开目录 false表示不打开
        gc.setOpen(false);
        // 实体属性Swagger2注解，添加swagger依赖，开启swagger模式
//        gc.setSwagger2(true);
        // 重新生成文件时是否覆盖 false表示不覆盖
        gc.setFileOverride(false);
        // 配置主键生成策略
        gc.setIdType(IdType.ASSIGN_ID);
        // 配置日期类型
        gc.setDateType(DateType.ONLY_DATE);
        // 默认生成的service会有I前缀
        gc.setServiceName("%sService");

        mpg.setGlobalConfig(gc);

        // Step3:配置数据源信息，用于指定数据库
        DataSourceConfig dsc = new DataSourceConfig();
        // 配置数据库url地址
        dsc.setUrl("jdbc:mysql://120.26.88.216:3306/testMyBatisPlus?useUnicode=true&characterEncoding=utf8");
        // 配置数据库驱动
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        // 配置数据库连接用户名
        dsc.setUsername("root");
        // 配置数据库连接密码
        dsc.setPassword("123456");

        mpg.setDataSource(dsc);

        // Step4:包配置
        PackageConfig pc = new PackageConfig();
        // 配置父包名
        pc.setParent("com.example.demo");
        // 配置模块名
        pc.setModuleName("test_mybatis_plus");
        // 配置entity包名
        pc.setEntity("entity");
        // 配置mapper包名
        pc.setMapper("mapper");
        // 配置service包名
        pc.setService("service");
        // 配置controller包名
        pc.setController("controller");

        mpg.setPackageInfo(pc);

        // Step5:策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        // 指定表名
        strategyConfig.setInclude("test_mybatis_plus_user");
        // 配置数据表与实体类名之间映射的策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 配置数据库表的字段与实体类的属性名之间映射的策略
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 配置lombok模式
        strategyConfig.setEntityLombokModel(true);
        // 配置rest风格的控制器(@RestController)
        strategyConfig.setRestControllerStyle(true);
        // 配置驼峰转连字符
        strategyConfig.setControllerMappingHyphenStyle(true);
        // 配置表前缀，生成实体时去除表前缀
        strategyConfig.setTablePrefix(pc.getModuleName() + "_");

        mpg.setStrategy(strategyConfig);

        // Step6:执行代码生成操作
        mpg.execute();
    }

}
