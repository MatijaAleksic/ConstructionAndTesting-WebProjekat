// package com.kts.cultural_content.repository;

// import com.kts.cultural_content.model.User;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.context.junit4.SpringRunner;

// import static com.kts.cultural_content.constants.UserConstants.DB_USER_EMAIL;
// import static org.junit.Assert.assertEquals;

// @RunWith(SpringRunner.class)
// @DataJpaTest
// @TestPropertySource("classpath:application-test.properties")
// public class UserRepositoryTests_SQL {

//     @Autowired
//     private UserRepository userRepository;

//     @Test
//     public void testFindByEmail() {
//         User found = userRepository.findByEmail(DB_USER_EMAIL);
//         assertEquals(DB_USER_EMAIL, found.getEmail());
//     }
// }
