package agf.springframework.externalprops.test;


import agf.springframework.externalprops.configure.ExternalPropsPropertySourceTestConfig;
import agf.springframework.externalprops.configure.env.ExternalPropsEnvironment;
import agf.springframework.externalprops.model.DBObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by jt on 5/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExternalPropsEnvironment.class)
public class PropertySourceENVTest {

    @Autowired
    DBObject dbobj;

    @Test
    public void testPropsSet() throws Exception {
        assertEquals("10.10.10.123", dbobj.getUrl());
        assertEquals(3330, dbobj.getPort().intValue());
        assertEquals("wesley", dbobj.getUserId());
        assertEquals("731031", dbobj.getPassword());
    }
}
