package com.myshoes.ecommerce.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration {

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(this.dataSource());
		sessionFactoryBean.setPackagesToScan("com.myshoes.ecommerce.model");
		sessionFactoryBean.setHibernateProperties(this.hibernateProperties());
		
		return sessionFactoryBean;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSurce = new DriverManagerDataSource();
		dataSurce.setDriverClassName("com.mysql.jdbc.Driver");
		dataSurce.setPassword("TYEqXLXx)H9pb+#");
		dataSurce.setUrl("jdbc:mysql://localhost:3306/my_shoes?serverTimezone=UTC");
		dataSurce.setUsername("my_shoes");
		
		return dataSurce;
	}
	
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("show_sql", "true");
		
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transsctionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(this.sessionFactory().getObject());
		
		return hibernateTransactionManager;
	}
}
