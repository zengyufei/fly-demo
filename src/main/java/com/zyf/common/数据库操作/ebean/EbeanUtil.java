package com.zyf.common.数据库操作.ebean;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.config.UnderscoreNamingConvention;
import org.apache.commons.lang3.StringUtils;

public class EbeanUtil {
    public static EbeanServer getEbean(String dbName, String packagePath) {
        ServerConfig config = new ServerConfig();
        dbName = StringUtils.isNotBlank(dbName) ? dbName : "db";
        config.setName(dbName);
        config.loadFromProperties();
        packagePath = StringUtils.isNotBlank(packagePath) ? packagePath : "com.zyf";
        config.addPackage(packagePath);
        config.setNamingConvention(new UnderscoreNamingConvention());// 下划线
        return EbeanServerFactory.create(config);
    }
}
