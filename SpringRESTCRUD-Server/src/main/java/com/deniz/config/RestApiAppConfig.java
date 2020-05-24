package com.deniz.config;



import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;



@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.deniz")
@PropertySource("classpath:db.properties")
public class RestApiAppConfig implements WebMvcConfigurer{
	
	
	// set up variable to hold the properties
		@Autowired
		private Environment env;
		
		// set up a logger for diagnostics
		private Logger logger = Logger.getLogger(getClass().getName());
	
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
	
	// define a bean for our security datasource
	
		@Bean
		public DataSource restDataSource() {
			
			// create connection pool
			ComboPooledDataSource restDataSource = new ComboPooledDataSource();

			// set the jdbc driver
			try {
				restDataSource.setDriverClass("oracle.jdbc.OracleDriver");		
			}
			catch (PropertyVetoException exc) {
				throw new RuntimeException(exc);
			}
			
			// for sanity's sake, let's log url and user ... just to make sure we are reading the data
			logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
			logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
			
			// set database connection props
			restDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			restDataSource.setUser(env.getProperty("jdbc.user"));
			restDataSource.setPassword(env.getProperty("jdbc.password"));
			
			// set connection pool props
			restDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));

			restDataSource.setMinPoolSize(
					getIntProperty("connection.pool.minPoolSize"));
			
			restDataSource.setMaxPoolSize(
					getIntProperty("connection.pool.maxPoolSize"));
			
			restDataSource.setMaxIdleTime(
					getIntProperty("connection.pool.maxIdleTime"));
					
			return restDataSource;
		}
	
		
		private int getIntProperty(String propName) {
			
			String propVal = env.getProperty(propName);
			
			// now convert to int
			int intPropVal = Integer.parseInt(propVal);
			
			return intPropVal;
		}
	
	
	
	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	
		return props;				
	}

	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// set the properties
		sessionFactory.setDataSource(restDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	
	
	

}

