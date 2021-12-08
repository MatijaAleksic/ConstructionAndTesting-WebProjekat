// package com.kts.cultural_content.repository;

// import com.kts.cultural_content.model.CategoryType;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.context.junit4.SpringRunner;

// import java.util.List;

// import static com.kts.cultural_content.constants.CategoryTypeConstants.DB_CATEGORY_TYPE;
// import static com.kts.cultural_content.constants.CategoryTypeConstants.DB_CATEGORY_SIZE;
// import static com.kts.cultural_content.constants.CategoryTypeConstants.DB_CATEGORY_TYPE_ID;
// import static com.kts.cultural_content.constants.CulturalContentCategoryConstants.DB_CATEGORY_ID;
// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNull;

// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
// @TestPropertySource("classpath:application-test.properties")
// public class CategoryTypeRepositoryTests_SQL {

//     @Autowired
//     private CategoryTypeRepository categoryTypeRepository;

//     @Test
//     public void testFindByName() {
//         CategoryType found = categoryTypeRepository.findByName(DB_CATEGORY_TYPE);
//         assertEquals(DB_CATEGORY_TYPE, found.getName());
//     }

//     @Test
//     public void testFindByNameAndIdNot() {
//         CategoryType found = categoryTypeRepository.findByNameAndIdNot(DB_CATEGORY_TYPE,DB_CATEGORY_TYPE_ID);
//         assertNull(found);
//     }

//     @Test
//     public void testFindByCategoryId() {
//         List<CategoryType> found = categoryTypeRepository.findByCategoryId(DB_CATEGORY_ID);
//         assertEquals(DB_CATEGORY_SIZE, found.size());
//     }

// }
