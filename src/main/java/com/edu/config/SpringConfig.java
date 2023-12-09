package com.edu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.edu"})// 包扫描
@MapperScan("com.edu.mapper")// 配置mapper所在位置
@PropertySource("db.properties")
@EnableAspectJAutoProxy //开启AOP的注解
public class SpringConfig {

    /*获取文件中jdbc的配置项*/
    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${jdbcUserName}")
    private String jdbcUserName;
    @Value("${password}")
    private String password;

    /**
     * 数据库源的配置
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * 集成mybatis的配置
     * @return
     */
    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean getSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        //设置别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.edu.entity");
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //设置驼峰标志的
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean;
    }

    /**
     * 加入事务管理的配置
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
}