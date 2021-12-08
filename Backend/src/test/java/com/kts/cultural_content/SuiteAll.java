package com.kts.cultural_content;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.test.context.TestPropertySource;

@RunWith(Suite.class)
// @SuiteClasses({CulturalContentCategoryRepositoryTests.class, CulturalContentCategoryRepositoryTests_SQL.class,
//         CategoryTypeRepositoryTests.class, CategoryTypeRepositoryTests_SQL.class,
//         UserRepositoryTests.class, UserRepositoryTests_SQL.class, CulturalContentCategoryServiceUnitTest.class,
//         CulturalContentCategoryServiceIntegrationTest.class})
@TestPropertySource("classpath:test.properties")
public class SuiteAll {


}
