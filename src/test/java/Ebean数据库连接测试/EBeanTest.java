package Ebean数据库连接测试;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.config.UnderscoreNamingConvention;
import org.junit.Test;

public class EBeanTest {

    @Test
    public void runTest() {
        ServerConfig config = new ServerConfig();
        config.setName("db");
        config.loadFromProperties();
        config.addPackage("com.zyf.test.爬虫.webmagic");
        config.setNamingConvention(new UnderscoreNamingConvention());// 下划线
        EbeanServer ebeanServer = EbeanServerFactory.create(config);
    }

}
