//package pl.coderslab.sport_book;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//import org.springframework.web.servlet.LocaleContextResolver;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//import pl.coderslab.sport_book.converter.FixtureConverter;
//import pl.coderslab.sport_book.converter.MarketConverter;
//
//import javax.persistence.EntityManagerFactory;
//import javax.validation.Validator;
//import java.util.Locale;
//
//@Configuration
//@EnableWebMvc
//
//public class AppConfig extends WebMvcConfigurerAdapter {
//
//
//    @Bean(name="localeResolver")
//    public LocaleContextResolver getLocaleContextResolver() {
//        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(new Locale("pl","PL"));
//        return localeResolver; }
//
//    @Bean
//    public Validator validator() {
//        return new LocalValidatorFactoryBean();
//    }
//
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(getMarketConverter());
//        registry.addConverter(getFixtureConverter());
//    }
//
//
//    @Bean
//    public MarketConverter getMarketConverter() {
//        return new MarketConverter();
//    }
//
//    @Bean
//    public FixtureConverter getFixtureConverter(){
//        return  new FixtureConverter();
//    }
//
//
//
//
//}
