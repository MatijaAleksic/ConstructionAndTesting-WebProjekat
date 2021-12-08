// package com.kts.cultural_content.repository;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNull;

// import static com.kts.cultural_content.constants.CulturalContentCategoryConstants.*;
// import com.kts.cultural_content.model.CulturalContentCategory;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
// @TestPropertySource("classpath:application-test.properties")
// public class CulturalContentCategoryRepositoryTests_SQL {

//     @Autowired
//     private CulturalContentCategoryRepository culturalContentCategoryRepository;

//     @Test
//     public void testFindByName() {
//         CulturalContentCategory found = culturalContentCategoryRepository.findByName(DB_CATEGORY);
//         assertEquals(DB_CATEGORY, found.getName());
//     }

//     @Test
//     public void testFindByNameAndIdNot() {
//         CulturalContentCategory found = culturalContentCategoryRepository.findByNameAndIdNot(DB_CATEGORY,DB_CATEGORY_ID);
//         assertNull(found);
//     }
// }
