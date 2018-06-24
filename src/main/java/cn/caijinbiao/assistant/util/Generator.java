package cn.caijinbiao.assistant.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Generator {
    public void generateCode() {
        String packageName = "cn.caijinbiao.assistant";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName, "t_user", "t_isp", "t_type", "t_translate", "t_habit");
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/d_assistant";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("798998203")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setTablePrefix("t_")
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                .setFieldPrefix(new String[]{"f_"})
                .setDbColumnUnderline(true)
                .setSuperEntityClass("cn.caijinbiao.assistant.entity.BaseEntity")
                .setSuperEntityColumns("id", "name", "isDelete")
                .setSuperMapperClass("cn.caijinbiao.assistant.mapper.BaseMapper")
                .setSuperServiceClass("cn.caijinbiao.assistant.service.BaseService")
                .setSuperServiceImplClass("cn.caijinbiao.assistant.service.impl.BaseServiceImpl")
                .setLogicDeleteFieldName("f_is_delete")
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setEnableCache(true)
                .setAuthor("jinbiaocai")
                .setOutputDir("src/main/java");
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity")
                ).execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }


    public static void main(String args[]) {
        new Generator().generateCode();
    }
}
