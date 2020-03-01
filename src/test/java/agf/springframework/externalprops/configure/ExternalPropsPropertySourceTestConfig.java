package agf.springframework.externalprops.configure;
import agf.springframework.externalprops.model.DBObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * since Spring 3.1
 * Created by jt on 5/7/16.
 */
@Configuration
@PropertySource("classpath:uat.properties")
@PropertySources({
        @PropertySource("classpath:uat.properties"),
        @PropertySource("classpath:uat.encrypt.properties")
})
public class ExternalPropsPropertySourceTestConfig {

    @Value("${agf.db.uat.server}")
    String dbServer;

    @Value("${agf.db.uat.port}")
    Integer dbPort;

    @Value("${agf.db.uat.userid}")
    String dbUser;

    @Value("${agf.db.uat.password}")
    String dbPassword;


    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer
                = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public DBObject dbobj(){
        DBObject dbobj = new DBObject();
        dbobj.setUrl(dbServer);
        dbobj.setPassword(dbPassword);
        dbobj.setPort(dbPort);
        dbobj.setUserId(dbUser);
        return dbobj;
    }
}
