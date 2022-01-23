 package kts.restaurant_application;

 import kts.restaurant_application.services.Integration.*;
 import kts.restaurant_application.services.Unit.*;
 import org.junit.runner.RunWith;
 import org.junit.runners.Suite;
 import org.springframework.test.context.TestPropertySource;

 @RunWith(Suite.class)
  @Suite.SuiteClasses({AdminServiceIntegrationTest.class, BarmanServiceIntegrationTest.class,CookServiceIntegrationTest.class,
          DrinkServiceIntegrationTest.class,FoodServiceIntegrationTest.class,ItemServiceIntegrationTest.class,MainCookServiceIntegrationTest.class,
          ManagerServiceIntegrationTest.class,NotificationServiceIntegrationTest.class,OrderItemServiceIntegrationTest.class,OrderServiceIntegrationTest.class,
          RestaurantTableServiceIntegrationTest.class,StaffServiceIntegrationTest.class,UserServiceIntegrationTest.class,WaiterServiceIntegrationTest.class,

          AdminServiceUnitTest.class, BarmanServiceUnitTest.class,CookServiceUnitTest.class,DrinkServiceUnitTest.class,FoodServiceUnitTest.class,
          ItemServiceUnitTest.class,MainCookServiceUnitTest.class,ManagerServiceUnitTest.class,NotificationServiceUnitTest.class,OrderServiceUnitTest.class,
          OrderItemServiceUnitTest.class,RestourantTableServiceUnitTest.class,StaffServiceUnitTest.class,UserServiceUnitTest.class,WaiterServiceUnitTest.class,
  })
 @TestPropertySource("classpath:test.properties")
 public class SuiteAll {


 }
