// package com.kts.cultural_content.service;
//
// import com.kts.cultural_content.model.CulturalContentCategory;
// import com.kts.cultural_content.repository.CulturalContentCategoryRepository;
// import org.junit.Test;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageImpl;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.context.junit4.SpringRunner;
//
// import static org.junit.Assert.assertEquals;
// import static org.mockito.BDDMockito.given;
//
// import java.util.ArrayList;
// import java.util.List;
//
// import static com.kts.cultural_content.constants.CulturalContentCategoryConstants.*;
// import static org.mockito.Mockito.*;
//
// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @TestPropertySource("classpath:application-test.properties")
// public class CulturalContentCategoryServiceUnitTest {
//
// 	// Instanciramo pravi objekat klase koju testiramo
// 	@Autowired
// 	private CulturalContentCategoryService culturalContentCategoryService;
//
// 	// Mokujemo sve reference, kako bismo imali unit test
// 	@MockBean
// 	private CulturalContentCategoryRepository culturalContentCategoryRepository;
//
// 	// Metoda se izvrsava pre svih test metoda ove klase
// 	@BeforeAll
// 	public void setup() {
// 		List<CulturalContentCategory> culturalContentCategories = new ArrayList<>();
// 		culturalContentCategories.add(new CulturalContentCategory(NEW_CATEGORY));
//
// 		Pageable pageable = PageRequest.of(PAGEABLE_PAGE, PAGEABLE_SIZE);
// 		Page<CulturalContentCategory> culturalContentCategoryPage = new PageImpl<>(culturalContentCategories, pageable,
// 				PAGEABLE_TOTAL_ELEMENTS);
//
// 		// Definisanje ponasanja test dvojnika culturalContentCategoryRepository za
// 		// findAll metodu
// 		given(culturalContentCategoryRepository.findAll()).willReturn(culturalContentCategories);
//
// 		given(culturalContentCategoryRepository.findAll(pageable)).willReturn(culturalContentCategoryPage);
//
// 		CulturalContentCategory culturalContentCategory = new CulturalContentCategory(NEW_CATEGORY);
// 		CulturalContentCategory savedCulturalContentCategory = new CulturalContentCategory(NEW_CATEGORY);
// 		savedCulturalContentCategory.setId(CATEGORY_ID);
//
// 		given(culturalContentCategoryRepository.findById(CATEGORY_ID))
// 				.willReturn(java.util.Optional.of(savedCulturalContentCategory));
//
// 		given(culturalContentCategoryRepository.findByName(NEW_CATEGORY)).willReturn(null);
//
// 		CulturalContentCategory culturalContentCategoryFound = new CulturalContentCategory(DB_CATEGORY_ID, DB_CATEGORY);
// 		given(culturalContentCategoryRepository.findByName(DB_CATEGORY)).willReturn(culturalContentCategoryFound);
//
// 		given(culturalContentCategoryRepository.findByNameAndIdNot(NEW_CATEGORY, CATEGORY_ID)).willReturn(null);
// 		given(culturalContentCategoryRepository.save(culturalContentCategory)).willReturn(savedCulturalContentCategory);
//
// 		doNothing().when(culturalContentCategoryRepository).delete(savedCulturalContentCategory);
// 	}
//
// 	@Test
// 	public void testFindAll() {
// 		List<CulturalContentCategory> found = culturalContentCategoryService.findAll();
//
// 		verify(culturalContentCategoryRepository, times(1)).findAll();
// 		assertEquals(FIND_ALL_NUMBER_OF_ITEMS, found.size());
// 	}
//
// 	@Test
// 	public void testFindAllPageable() {
// 		Pageable pageable = PageRequest.of(PAGEABLE_PAGE, PAGEABLE_SIZE);
// 		Page<CulturalContentCategory> found = culturalContentCategoryService.findAll(pageable);
//
// 		verify(culturalContentCategoryRepository, times(1)).findAll(pageable);
// 		assertEquals(FIND_ALL_NUMBER_OF_ITEMS, found.getNumberOfElements());
// 	}
//
// 	@Test
// 	public void testFindById() {
// 		CulturalContentCategory found = culturalContentCategoryService.findOne(CATEGORY_ID);
//
// 		verify(culturalContentCategoryRepository, times(1)).findById(CATEGORY_ID);
// 		assertEquals(CATEGORY_ID, found.getId());
// 	}
//
// 	@Test
// 	public void testCreate() throws Exception {
// 		CulturalContentCategory culturalContentCategory = new CulturalContentCategory(NEW_CATEGORY);
// 		CulturalContentCategory created = culturalContentCategoryService.create(culturalContentCategory);
//
// 		verify(culturalContentCategoryRepository, times(1)).findByName(NEW_CATEGORY);
// 		verify(culturalContentCategoryRepository, times(1)).save(culturalContentCategory);
//
// 		assertEquals(NEW_CATEGORY, created.getName());
// 	}
//
// 	@Test
// 	public void testCreate_GivenNameAlreadyExists() throws Exception {
// 		CulturalContentCategory culturalContentCategory = new CulturalContentCategory(DB_CATEGORY);
// 		CulturalContentCategory created = culturalContentCategoryService.create(culturalContentCategory);
//
// 		verify(culturalContentCategoryRepository, times(1)).findByName(DB_CATEGORY);
//
// 		assertEquals(null, created);
// 	}
//
// 	@Test
// 	public void testUpdate() throws Exception {
// 		CulturalContentCategory culturalContentCategory = new CulturalContentCategory(NEW_CATEGORY);
// 		CulturalContentCategory created = culturalContentCategoryService.update(culturalContentCategory, CATEGORY_ID);
//
// 		verify(culturalContentCategoryRepository, times(1)).findById(CATEGORY_ID);
// 		verify(culturalContentCategoryRepository, times(1)).findByNameAndIdNot(NEW_CATEGORY, CATEGORY_ID);
//
// 		assertEquals(NEW_CATEGORY, created.getName());
// 	}
//
// 	@Test
// 	public void testDelete() throws Exception {
// 		culturalContentCategoryService.delete(CATEGORY_ID);
//
// 		CulturalContentCategory savedCulturalContentCategory = new CulturalContentCategory(NEW_CATEGORY);
// 		savedCulturalContentCategory.setId(CATEGORY_ID);
//
// 		verify(culturalContentCategoryRepository, times(1)).findById(CATEGORY_ID);
// 	}
// }
