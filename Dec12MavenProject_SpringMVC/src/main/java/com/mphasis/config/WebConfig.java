package com.mphasis.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import com.mphasis.model.User;

@Configuration
@ComponentScan("com.mphasis")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class WebConfig {
	
	
	 @Autowired
	    private Environment env;
	 
	 
	@Bean
	public InternalResourceViewResolver getResolver()
	{
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	

	    @Bean
	    public DataSource getDataSource() {
	        DriverManagerDataSource ds = new DriverManagerDataSource();
	        ds.setDriverClassName(env.getProperty("db.driver"));
	        ds.setUrl(env.getProperty("db.url"));
	        ds.setUsername(env.getProperty("db.username"));
	        ds.setPassword(env.getProperty("db.password"));
	        return ds;
	    }


	    @Bean   
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
	        factory.setDataSource(getDataSource());
	        factory.setAnnotatedClasses(User.class);
	        factory.setHibernateProperties(getHibernateProps());
	        return factory;
	    }

	    private Properties getHibernateProps() {
	        Properties props = new Properties();
	        props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	        return props;
	    }

	    @Bean
	    public HibernateTemplate hibernateTemplate(SessionFactory sf) {
	        return new HibernateTemplate(sf);
	    }

	    @Bean
	    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sf) {
	        return new HibernateTransactionManager(sf);
	    }

}
