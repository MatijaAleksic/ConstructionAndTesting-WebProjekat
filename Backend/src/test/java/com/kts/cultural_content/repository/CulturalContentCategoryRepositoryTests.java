// package com.kts.cultural_content.repository;

// import com.kts.cultural_content.model.CulturalContentCategory;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.context.junit4.SpringRunner;
// import static com.kts.cultural_content.constants.CulturalContentCategoryConstants.*;
// import static org.junit.Assert.assertEquals;

// @RunWith(SpringRunner.class)
// @DataJpaTest
// @TestPropertySource("classpath:application-test.properties")
// public class CulturalContentCategoryRepositoryTests {

//     @Autowired
//     private TestEntityManager entityManager;

//     @Autowired
//     private CulturalContentCategoryRepository culturalContentCategoryRepository;

//     @Before
//     public void setUp() {
//         entityManager.persist(new CulturalContentCategory(NEW_CATEGORY));
//     }

//     @Test
//     public void testFindByName() {
//         CulturalContentCategory found = culturalContentCategoryRepository.findByName(NEW_CATEGORY);
//         assertEquals(NEW_CATEGORY, found.getName());
//     }
// }