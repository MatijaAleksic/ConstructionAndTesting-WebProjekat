package kts.restaurant_application;

import kts.restaurant_application.controllers.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.test.context.TestPropertySource;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ItemControllerTest.class, OrderedItemControllerTest.class,OrderControllerTest.class,
        TableControllerTest.class,UserControllerTest.class,

         ItemControllerUnitTest.class, OrderedItemControllerUnitTest.class,OrderControllerUnitTest.class,
        TableControllerUnitTest.class,UserControllerTest.class
})
@TestPropertySource("classpath:test.properties")
public class SuiteAllContoller {
}
