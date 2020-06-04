package com.renjack.webdemo.study.mybatis;

import com.renjack.webdemo.dao.sample.TestDao;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

/**
 * @Classname MybatisTest
 * @Description TODO
 * @Date 2020/6/4 18:07
 * @Created by renshaobo
 */
public class MybatisTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://outlets.mysql:3306/jq_store?serverTimezone=GMT%2B8&characterEncoding=utf-8&autoReconnect=true&useSSL=false&allowMultiQueries=true");
        properties.setProperty("username", "jq_user");
        properties.setProperty("password", "1akGja4B2hdasgQa");
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        pooledDataSourceFactory.setProperties(properties);
        DataSource dataSource = pooledDataSourceFactory.getDataSource();

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.addMapper(TestDao.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(inputStream);

//        try(SqlSession session = sqlSessionFactory.openSession()){
//            AreaMapper mapper = session.getMapper(AreaMapper.class);
//
//            List calanderPrices = mapper.getCalanderPrice();
//            List calanderPrices1 = mapper.getCalanderPrice();
//            System.out.println(1);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }

        SqlSession session = sqlSessionFactory.openSession();
        TestDao mapper = session.getMapper(TestDao.class);
        List calanderPrices = mapper.findList();
        System.out.println(1);
    }
}
