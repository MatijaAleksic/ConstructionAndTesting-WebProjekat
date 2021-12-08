// package com.kts.cultural_content.repository;

// import static com.kts.cultural_content.constants.CategoryTypeConstants.*;
// import static com.kts.cultural_content.constants.CulturalContentCategoryConstants.*;
// import com.kts.cultural_content.model.CategoryType;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.junit4.SpringRunner;

// import java.util.List;

// import static org.junit.Assert.assertEquals;

// @RunWith(SpringRunner.class)
// @DataJpaTest
// @ActiveProfiles("test")
// public class CategoryTypeRepositoryTests {

//     @Autowired
//     private TestEntityManager entityManager;

//     @Autowired
//     private CategoryTypeRepository categoryTypeRepository;

//     @Autowired
//     private CulturalContentCategoryRepository culturalContentCategoryRepository;

//     @Before
//     public void setUp() {
//         entityManager.persist(new CategoryType(NEW_CATEGORY_TYPE1));

//         CategoryType categoryType = new CategoryType(NEW_CATEGORY_TYPE2);
//         categoryType.setCategory(culturalContentCategoryRepository.findByName(DB_CATEGORY));
//         entityManager.persist(categoryType);
//     }

//     @Test
//     public void testFindByName() {
//         CategoryType found = categoryTypeRepository.findByName(NEW_CATEGORY_TYPE1);
//         assertEquals(NEW_CATEGORY_TYPE1, found.getName());
//     }


//     @Test
//     public void testFindByCategoryId() {
//         List<CategoryType> found = categoryTypeRepository.findByCategoryId(DB_CATEGORY_ID);
//         assertEquals(2, found.size());
//     }
// }
