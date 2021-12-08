// package com.kts.cultural_content.service;

// import com.kts.cultural_content.model.CulturalContentCategory;
// import com.kts.cultural_content.repository.CulturalContentCategoryRepository;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.context.junit4.SpringRunner;

// import java.util.List;

// import static com.kts.cultural_content.constants.CulturalContentCategoryConstants.*;
// import static com.kts.cultural_content.constants.CulturalContentCategoryConstants.CATEGORY_ID;
// import static org.junit.Assert.assertEquals;

// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @TestPropertySource("classpath:application-test.properties")
// public class CulturalContentCategoryServiceIntegrationTest {

// 	@Autowired
// 	private CulturalContentCategoryService culturalContentCategoryService;
	
// //    @Autowired
// //    private CulturalContentCategoryRepository culturalContentCategoryRepository;

// 	@Test
// 	public void testFindAll() {
// 		List<CulturalContentCategory> found = culturalContentCategoryService.findAll();
// 		assertEquals(FIND_ALL_NUMBER_OF_ITEMS, found.size());
// 	}

// 	@Test
// 	public void testFindAllPageable() {
// 		Pageable pageable = PageRequest.of(PAGEABLE_PAGE, PAGEABLE_SIZE);
// 		Page<CulturalContentCategory> found = culturalContentCategoryService.findAll(pageable);
// 		assertEquals(FIND_ALL_NUMBER_OF_ITEMS, found.getNumberOfElements());
// 	}

// 	@Test
// 	public void testFindById() {
// 		CulturalContentCategory found = culturalContentCategoryService.findOne(CATEGORY_ID);
// 		assertEquals(CATEGORY_ID, found.getId());
// 	}

// 	@Test
// 	public void testCreate() throws Exception {
// 		CulturalContentCategory culturalContentCategory = new CulturalContentCategory(NEW_CATEGORY);
// 		CulturalContentCategory created = culturalContentCategoryService.create(culturalContentCategory);

// 		assertEquals(NEW_CATEGORY, created.getName());
// 	}

// 	@Test
// 	public void testDelete() throws Exception {
// 		culturalContentCategoryService.delete(CATEGORY_ID);

// 		CulturalContentCategory savedCulturalContentCategory = new CulturalContentCategory(NEW_CATEGORY);
// 		savedCulturalContentCategory.setId(CATEGORY_ID);
// 	}
// }
