package kts.restaurant_application;

import kts.restaurant_application.repositories.*;
import kts.restaurant_application.services.Integration.*;
import kts.restaurant_application.services.Unit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.test.context.TestPropertySource;

@RunWith(Suite.class)
@Suite.SuiteClasses({AdminRepositoryTest.class, BarmanRepositoryTest.class, CookRepositoryTest.class,
        DrinkRepositoryTest.class, FoodRepositoryTest.class, ItemRepositoryTest.class,MaincookRepositoryTest.class,
        ManagerRepositoryTest.class,OrderRepositoryTest.class,OrderRepositoryTest.class,
        TableRepositoryTest.class,StaffRepositoryTest.class,UserRepositoryTest.class,WaiterRepositoryTest.class,

})
@TestPropertySource("classpath:test.properties")
public class SuiteAllRepository {
}
