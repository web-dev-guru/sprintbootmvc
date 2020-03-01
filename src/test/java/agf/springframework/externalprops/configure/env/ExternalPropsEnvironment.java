package agf.springframework.externalprops.configure.env;

import agf.springframework.externalprops.model.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by jt on 5/7/16.
 */
@Configuration
@PropertySource("classpath:uat.properties")
public class ExternalPropsEnvironment {

    @Autowired
    Environment env; //also from Spring 3.1
    @Bean
    public DBObject fakeJmsBrokerEnv(){
        DBObject dbobj = new DBObject();
        dbobj.setUrl(env.getProperty("agf.db.uat.server"));
        dbobj.setPassword(env.getProperty("agf.db.uat.password"));
        dbobj.setPort(env.getRequiredProperty("agf.db.uat.port", Integer.class));
        dbobj.setUserId(env.getProperty("agf.db.uat.userid"));
        return dbobj;
    }
}
