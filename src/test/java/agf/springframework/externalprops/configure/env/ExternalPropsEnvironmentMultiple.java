package agf.springframework.externalprops.configure.env;

import agf.springframework.externalprops.model.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

/**
 * Created by jt on 5/7/16.
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:uat.properties"),
        @PropertySource("classpath:uat.encrypt.properties")
})
public class ExternalPropsEnvironmentMultiple {

    @Autowired
    Environment env; //also from Spring 3.1
    @Bean
    public DBObject fakeJmsBrokerEnv(){
        DBObject dbobj = new DBObject();
        dbobj.setUrl(env.getProperty("agf.db.uat.server"));
        dbobj.setPassword(env.getProperty("agf.db.uat.encrypt.password"));
        dbobj.setPort(env.getRequiredProperty("agf.db.uat.port", Integer.class));
        dbobj.setUserId(env.getProperty("agf.db.uat.userid"));
        return dbobj;
    }
}
