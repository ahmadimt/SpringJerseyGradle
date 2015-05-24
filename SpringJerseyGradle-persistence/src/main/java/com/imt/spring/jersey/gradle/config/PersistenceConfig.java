/**
 * 
 */
package com.imt.spring.jersey.gradle.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author imti
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.imt.spring.jersey.gradle" })
@EnableJpaRepositories(basePackages = { "com.imt.spring.jersey.gradle" })
@EnableTransactionManagement
public class PersistenceConfig {

	@Value("${db.url}")
	private String dbUrl;

	@Value("${db.driver}")
	private String driverClass;

	@Value("${db.username}")
	private String dbUserName;

	@Value("${db.password}")
	private String password;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Value("${hibernate.ejb.naming_strategy}")
	private String hibernateEjbNamingStrategy;

	@Value("${hibernate.hbm2ddl.auto}")
	private String ddlAuto;
	
	@Value("${hibernate.show_sql}")
	private String showSql;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.imt.spring.jersey" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(jpaProperties());
		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	Properties jpaProperties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", hibernateDialect);
		prop.setProperty("hibernate.ejb.naming_strategy",
				hibernateEjbNamingStrategy);
		prop.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
		prop.setProperty("hibernate.show_sql", showSql);
		
		return prop;

	}
}
