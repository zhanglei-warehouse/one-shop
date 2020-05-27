package com.one.shop;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        gc.setAuthor("luojianwu");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        //设置生成返回的结果集
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/xiaosi_practice?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setParent(CodeGenerator.class.getPackage().getName());
        mpg.setPackageInfo(pc);

        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("t_user");
        sc.setTablePrefix("t_");
        sc.setEntityLombokModel(true);
        mpg.setStrategy(sc);

        mpg.execute();
    }
}
