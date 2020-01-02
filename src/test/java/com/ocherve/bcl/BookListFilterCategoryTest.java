package com.ocherve.bcl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ocherve.bcl.dto.book.BookListFilterDvo;
import com.ocherve.bcl.exception.BookFilterException;

class FilterCategoryTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	//@Test
	void test() {
		fail("Not yet implemented");
	}
	
	private class FilterTest extends BookListFilterDvo {
				
		FilterTest(String categoryId, String writerId, String writtenDateMin, String writtenDateMax,
				String pagesNumberMin, String pagesNumberMax, String quantityAvailableMin,
				String quantityAvailableMax, String words, String sortByCategory, String sortByWriter, 
				String sortById, String sortByTitle, String sortByWrittenDate, String sortByPagesNumber,
				String sortByQuantityAvailable, 
				String pageId, String pageLimit) {
			super(categoryId, writerId, writtenDateMin, writtenDateMax,
					pagesNumberMin, pagesNumberMax, quantityAvailableMin,
					quantityAvailableMax, words, sortByCategory, sortByWriter, 
					sortById, sortByTitle, sortByWrittenDate, sortByPagesNumber,
					sortByQuantityAvailable, 
					pageId, pageLimit);
		}
	}

	@Test
	void given_NullAttributeValue_When_gettingParametersOrCategory_Then_returnEmpty() {
		FilterTest filter = new FilterTest(null,
				"","","","","","","","","","","","","","","","","");
		assertEquals(filter.getCategoryId(), "0");
		assertEquals(filter.toUrlParameters(), "");
	}

	@Test
	void given_EmptyAttributeValue_When_gettingParametersOrCategory_Then_returnEmpty() {
		FilterTest filter = new FilterTest("",
				"","","","","","","","","","","","","","","","","");
		assertEquals(filter.getCategoryId(), "0");
		assertEquals(filter.toUrlParameters(), "");
	}

	@Test
	void given_WordAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
		        		() -> new FilterTest("aepm",
		        			"","","","","","","","","","","","","","","","","") 
		        	);
	}

	@Test
	void given_OutOfRangeAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("999999999999999999999999999999999999999999999999999999999999999999911111111111199999999",
        				"","","","","","","","","","","","","","","","","")
                	);
	}

	@Test
	void given_SpecialCharAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("-3+(>>=",
                		"","","","","","","","","","","","","","","","","") 
                	);
	}

	@Test
	void given_relevantAttributeValue_When_gettingParametersOrCategory_Then_returnValidAttributeOrParameters() {
		FilterTest filter = new FilterTest("12","","","","","","","","","","","","","","","","","");
		assertEquals(filter.getCategoryId(), "12");
		assertEquals(filter.toUrlParameters(), "category_id=12");
	}

}
