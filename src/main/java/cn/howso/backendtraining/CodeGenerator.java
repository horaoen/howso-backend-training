package cn.howso.backendtraining;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.fill.Column;

public class CodeGenerator {
    private static final String datasourceUrl = "jdbc:mysql://localhost:3306/training?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&createDatabaseIfNotExist=true";
    private static final String username = "root";
    private static final String password = "123456";

    private static final DataSourceConfig DATA_SOURCE_CONFIG =
            new DataSourceConfig
                    .Builder(datasourceUrl, username, password)
                    .schema("training")
                    .build();

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(getStrategyConfig());
        generator.global(globalConfig().build());
        generator.packageInfo(packageConfig().build());
        generator.execute();
    }

    /**
     * 策略配置
     */
    protected static StrategyConfig getStrategyConfig() {
        return new StrategyConfig.Builder()
                .addTablePrefix("t_")
                .entityBuilder().enableLombok()
                    .addTableFills(
                            new Column("create_time", FieldFill.INSERT),
                            new Column("update_time", FieldFill.UPDATE),
                            new Column("create_user", FieldFill.INSERT),
                            new Column("update_user", FieldFill.UPDATE)
                    )
                .logicDeleteColumnName("delete_mark")
                .controllerBuilder().enableRestStyle()
                .build();
    }

    /**
     * 全局配置
     */
    protected static GlobalConfig.Builder globalConfig() {
        return new GlobalConfig.Builder()
                .author("horaoen")
                .outputDir(System.getProperty("user.dir") + "/src/main/java");
                
    }
    /**
     * 包配置
     */
    protected static PackageConfig.Builder packageConfig() {
        return new PackageConfig.Builder()
                .parent("cn.howso.backendtraining");
    }
}
