package org.rv.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "org.rv.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="123";
	
	//dataSource bean
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		try
		{
		//providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		
		System.out.println("ds1");
		
		dataSource.setUrl(DATABASE_URL);
		System.out.println("2");
		dataSource.setUsername(DATABASE_USERNAME);
		System.out.println("3");
		dataSource.setPassword(DATABASE_PASSWORD);
		System.out.println("4");
	
		return dataSource;
		
		}
		catch(Exception e)
		{
			
			
			System.out.println("some errore"+e.toString());
			return dataSource;
		}
	}
	
	//sessionFactory bean
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		
		try
		{
			
			LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
			System.out.println("s1");
			builder.addProperties(getHibernateProperies());
			System.out.println("s2");
			builder.scanPackages("org.rv.shoppingbackend.dto");
			System.out.println("s3");
			return builder.buildSessionFactory();
			
		}catch (Exception e) {
			System.out.println("sessionfactory erroe"+e.toString());
			return null;
		}
		
	}

	
	//all the hibernate properties will return in this method
	public Properties getHibernateProperies()
	{
		try {
			
			Properties properties = new Properties();
			System.out.println("a");
			properties.put("hibernate.dialect", DATABASE_DIALECT);
			System.out.println("a");
			properties.put("hibernate.show_sql", "true");
			System.out.println("a");
			properties.put("hibernate.format_sql", "true");
			System.out.println("a");
			
			
			
		return 	properties;
			
		} catch (Exception e) {
			System.out.println("properties error"+e.toString());
			
			return 	null;
		}
		
	}
	
	
	//TransactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		
		HibernateTransactionManager htm = new HibernateTransactionManager(sessionFactory);
		return htm;
		
	}
	
}

