// package com.kts.cultural_content.repository;

// import com.kts.cultural_content.model.User;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.junit4.SpringRunner;

// import static com.kts.cultural_content.constants.UserConstants.NEW_USER_EMAIL;
// import static org.junit.Assert.assertEquals;

// @RunWith(SpringRunner.class)
// @DataJpaTest
// @ActiveProfiles("test")
// public class UserRepositoryTests {

//     @Autowired
//     private TestEntityManager entityManager;

//     @Autowired
//     private UserRepository userRepository;


//     @Before
//     public void setUp() {
//         entityManager.persist(new User("tamaraSimic@maildrop.cc", "tamaraSimic6"));
//     }

//     @Test
//     public void testFindByEmail() {
//         User found = userRepository.findByEmail(NEW_USER_EMAIL);
//         assertEquals(NEW_USER_EMAIL, found.getEmail());
//     }
// }
