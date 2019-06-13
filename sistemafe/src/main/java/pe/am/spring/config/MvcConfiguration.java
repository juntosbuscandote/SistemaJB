package pe.am.spring.config;

import javax.sql.DataSource;
import pe.am.spring.dao.ContactDAO;
import pe.am.spring.dao.ContactDAOImpl;
import pe.am.spring.dao.CtrUsuario;
import pe.am.spring.dao.CtrUsuarioImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pe.am.spring.dao.CtrEmpresa;
import pe.am.spring.dao.CtrEmpresaImpl;
import pe.am.spring.dao.CtrPeriodo;
import pe.am.spring.dao.CtrPeriodoImpl;

@Configuration
@ComponentScan(basePackages="pe.am.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
	//********************CONECCION**************************** 
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		
		dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=ERP");
		dataSource.setUsername("sa");
		dataSource.setPassword("12345678");
		return dataSource;
	}
	
	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}
        
        @Bean
	public CtrUsuario getCtrUsuario() {
		return new CtrUsuarioImpl(getDataSource());
	}
         @Bean
	public CtrEmpresa getCtrEmpresa() {
		return new CtrEmpresaImpl(getDataSource());
	}
        
        @Bean
	public CtrPeriodo getCtrPeriodo() {
		return new CtrPeriodoImpl(getDataSource());
	}
}
