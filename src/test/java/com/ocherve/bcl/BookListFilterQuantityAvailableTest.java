/**
 * 
 */
package com.ocherve.bcl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ocherve.bcl.dto.book.BookListFilterDvo;
import com.ocherve.bcl.exception.BookFilterException;

/**
 * @author herve_dev
 *
 */
class BookListFilterQuantityAvailableTest {
	
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
	void given_NullMinAttributeValue_When_gettingParametersOrCategory_Then_returnInactive() {
		FilterTest filter = new FilterTest("","","","","","",
				null,
				"","","","","","","","","","","");
		assertEquals(filter.getQuantityAvailableMin(), "0");
		assertEquals(filter.toUrlParameters(), "");
	}

	@Test
	void given_EmptyMinAttributeValue_When_gettingParametersOrCategory_Then_returnInactive() {
		FilterTest filter = new FilterTest("","","","","","",
				"",
				"","","","","","","","","","","");
		assertEquals(filter.getQuantityAvailableMin(), "0");
		assertEquals(filter.toUrlParameters(), "");
	}

	@Test
	void given_SpecialCharMinAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","","","","","",
                		"-3+(>>=",
                		"","","","","","","","","","","") 
                	);
	}

	@Test
	void given_WordMinAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
		        		() -> new FilterTest("","","","","","",
		        			"aepm",
		        			"","","","","","","","","","","") 
		        	);
	}

	@Test
	void given_UnderRangeMinAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","","","","","",
        				"-1",
        				"","","","","","","","","","","")
                	);
	}

	@Test
	void given_OverRangeMinAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","","","","","",
        				"401",
        				"","","","","","","","","","","")
                	);
	}

	@Test
	void given_relevantMinAttributeValue_When_gettingParametersOrCategory_Then_returnValidAttributeOrParameters() {
		FilterTest filter = new FilterTest("","","","","","",
				"27",
				"","","","","","","","","","","");
		assertEquals(filter.getQuantityAvailableMin(), "27");
		assertEquals(filter.toUrlParameters(), "quantity_available_min=27");
	}

	@Test
	void given_NullMaxAttributeValue_When_gettingParametersOrCategory_Then_returnInactive() {
		FilterTest filter = new FilterTest("","","","","","","",
				null,
				"","","","","","","","","","");
		assertEquals(filter.getQuantityAvailableMax(), "0");
		assertEquals(filter.toUrlParameters(), "");
	}

	@Test
	void given_EmptyMaxAttributeValue_When_gettingParametersOrCategory_Then_returnInactive() {
		FilterTest filter = new FilterTest("","","","","","","",
				"",
				"","","","","","","","","","");
		assertEquals(filter.getQuantityAvailableMax(), "0");
		assertEquals(filter.toUrlParameters(), "");
	}

	@Test
	void given_SpecialCharMaxAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","","","","","","",
                		"-3+(>>=",
                		"","","","","","","","","","") 
                	);
	}

	@Test
	void given_WordMaxAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
		        		() -> new FilterTest("","","","","","","",
		        			"aepm",
		        			"","","","","","","","","","") 
		        	);
	}

	@Test
	void given_UnderRangeMaxAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","","","","","","",
        				"-1",
        				"","","","","","","","","","")
                	);
	}

	@Test
	void given_UnderMinMaxAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","","","","","",
        				"23","12",
        				"","","","","","","","","","")
                	);
	}

	@Test
	void given_OverRangeMaxAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","","","","","","",
        				"400",
        				"","","","","","","","","","")
                	);
	}

	@Test
	void given_relevantMaxAttributeValue_When_gettingParametersOrCategory_Then_returnValidAttributeOrParameters() {
		FilterTest filter = new FilterTest("","","","","","","",
				"45",
				"","","","","","","","","","");
		assertEquals(filter.getQuantityAvailableMax(), "45");
		assertEquals(filter.toUrlParameters(), "quantity_available_max=45");
	}


}
