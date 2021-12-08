// package com.kts.cultural_content.controller;

// import static com.kts.cultural_content.constants.CategoryTypeConstants.DB_CATEGORY_SIZE;
// import static com.kts.cultural_content.constants.CategoryTypeConstants.DB_CATEGORY_TYPE;
// import static com.kts.cultural_content.constants.CategoryTypeConstants.DB_CATEGORY_TYPE_ID;
// import static com.kts.cultural_content.constants.CulturalContentCategoryConstants.DB_CATEGORY;
// import static com.kts.cultural_content.constants.CulturalContentCategoryConstants.DB_CATEGORY_ID;
// import static com.kts.cultural_content.constants.CulturalContentCategoryConstants.FIND_ALL_NUMBER_OF_ITEMS;
// import static org.hamcrest.Matchers.hasItem;
// import static org.hamcrest.Matchers.hasSize;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.util.ArrayList;
// import java.util.List;

// import javax.annotation.PostConstruct;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.web.context.WebApplicationContext;

// import com.kts.cultural_content.model.CategoryType;
// import com.kts.cultural_content.model.CulturalContentCategory;
// import com.kts.cultural_content.service.CategoryTypeService;
// import com.kts.cultural_content.service.CulturalContentCategoryService;

// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @TestPropertySource("classpath:application-test.properties")
// public class CulturalContentCategoryControllerUnitTest {

// 	private static final String URL_PREFIX = "/api/cultural-content-category";

// 	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
// 			MediaType.APPLICATION_JSON.getSubtype());

// 	private MockMvc mockMvc;

// 	@MockBean
// 	private CulturalContentCategoryService culturalContentCategoryService;

// 	@MockBean
// 	private CategoryTypeService categoryTypeService;

// 	@Autowired
// 	private WebApplicationContext webApplicationContext;

// 	@PostConstruct
// 	public void setup() {
// 		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
// 	}

// 	// JWT token za pristup REST servisima. Bice dobijen pri logovanju
// 	// private String accessToken;

// 	/*
// 	 * public void login(String username, String password) {
// 	 * ResponseEntity<UserTokenState> responseEntity =
// 	 * restTemplate.postForEntity("/auth/login", new
// 	 * JwtAuthenticationRequest(username,password), UserTokenState.class);
// 	 * accessToken = "Bearer " + responseEntity.getBody().getAccessToken(); }
// 	 */

// 	@Test
// 	public void testGetAllCulturalContentCategories() throws Exception {

// 		// login(USER_EMAIL, PASSWORD);

// 		// postavimo JWT token u zaglavlje zahteva da bi bilo dozvoljeno da pozovemo
// 		// funkcionalnost
// 		// HttpHeaders headers = new HttpHeaders();
// 		// headers.add("Authorization", accessToken);
// 		// kreiramo objekat koji saljemo u sklopu zahteva
// 		// objekat nema telo, vec samo zaglavlje, jer je rec o GET zahtevu
// 		// HttpEntity<Object> httpEntity = new HttpEntity<Object>(headers);

// 		List<CulturalContentCategory> found = new ArrayList<>();
// 		CulturalContentCategory category = new CulturalContentCategory(DB_CATEGORY_ID, DB_CATEGORY);
// 		found.add(category);

// 		Mockito.when(culturalContentCategoryService.findAll()).thenReturn(found);

// 		mockMvc.perform(get(URL_PREFIX)).andExpect(status().isOk()).andExpect(content().contentType(contentType))
// 				.andExpect(jsonPath("$", hasSize((int) FIND_ALL_NUMBER_OF_ITEMS)))
// 				.andExpect(jsonPath("$.[*].id").value(hasItem(DB_CATEGORY_ID.intValue())))
// 				.andExpect(jsonPath("$.[*].name").value(hasItem(DB_CATEGORY)));

// 		verify(culturalContentCategoryService, times(1)).findAll();
// 	}

// 	@Test
// 	public void testGetAllCategoryTypes() throws Exception {

// 		List<CategoryType> found = new ArrayList<>();
// 		CategoryType categoryType = new CategoryType(DB_CATEGORY_TYPE_ID, DB_CATEGORY_TYPE);
// 		CulturalContentCategory category = new CulturalContentCategory(DB_CATEGORY_ID, DB_CATEGORY);
// 		categoryType.setCategory(category);
// 		found.add(categoryType);

// 		Mockito.when(categoryTypeService.findAll(categoryType.getCategory().getId())).thenReturn(found);

// 		mockMvc.perform(get(URL_PREFIX + "/" + DB_CATEGORY_ID + "/category-types")).andExpect(status().isOk())
// 				.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize((int) DB_CATEGORY_SIZE)))
// 				.andExpect(jsonPath("$.[*].id").value(hasItem(DB_CATEGORY_TYPE_ID.intValue())))
// 				.andExpect(jsonPath("$.[*].name").value(hasItem(DB_CATEGORY_TYPE)));

// 		verify(categoryTypeService, times(1)).findAll(categoryType.getCategory().getId());
// 	}

// }
