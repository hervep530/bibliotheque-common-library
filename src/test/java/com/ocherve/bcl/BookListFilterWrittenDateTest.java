package com.ocherve.bcl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ocherve.bcl.dto.book.BookListFilterDvo;
import com.ocherve.bcl.exception.BookFilterException;

class BookListFilterWrittenDateTest {
	
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
	void given_NullMinAttributeValue_When_gettingParametersOrCategory_Then_returnEmpty() {
		FilterTest filter = new FilterTest("","",
				null,
				"","","","","","","","","","","","","","","");
		assertEquals(filter.getWrittenDateMin(), "0001-01-01");
		assertEquals(filter.toUrlParameters(), "");
	}

	@Test
	void given_EmptyMinAttributeValue_When_gettingParametersOrCategory_Then_returnEmpty() {
		FilterTest filter = new FilterTest("","",
				"",
				"","","","","","","","","","","","","","","");
		assertEquals(filter.getWrittenDateMin(), "0001-01-01");
		assertEquals(filter.toUrlParameters(), "");
	}

	@Test
	void given_SpecialCharMinAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","",
                		"-3+(>>=",
                		"","","","","","","","","","","","","","","") 
                	);
	}

	@Test
	void given_WordMinAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
		        		() -> new FilterTest("","",
		        			"aepm",
		        			"","","","","","","","","","","","","","","") 
		        	);
	}

	@Test
	void given_NumberMinAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
		        		() -> new FilterTest("","",
		        			"83",
		        			"","","","","","","","","","","","","","","") 
		        	);
	}

	@Test
	void given_InvalidDateMinAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
		        		() -> new FilterTest("","",
		        			"2012-18-42",
		        			"","","","","","","","","","","","","","","") 
		        	);
	}

	@Test
	void given_beforeJCMinAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","",
        				"-1403-02-09",
        				"","","","","","","","","","","","","","","")
                	);
	}

	@Test
	void given_afterNowMinAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","",
        				"2040-01-01",
        				"","","","","","","","","","","","","","","")
                	);
	}

	@Test
	void given_relevantMinAttributeValue_When_gettingParametersOrCategory_Then_returnValidAttributeOrParameters() {
		FilterTest filter = new FilterTest("","",
				"2017-08-25",
				"","","","","","","","","","","","","","","");
		assertEquals(filter.getWrittenDateMin(), "2017-08-25");
		assertEquals(filter.toUrlParameters(), "written_date_min=2017-08-25");
	}

	@Test
	void given_NullMaxAttributeValue_When_gettingParametersOrCategory_Then_returnEmpty() {
		FilterTest filter = new FilterTest("","","",
				null,
				"","","","","","","","","","","","","","");
		assertEquals(filter.getWrittenDateMax(), "0001-01-01");
		assertEquals(filter.toUrlParameters(), "");
	}

	@Test
	void given_EmptyMaxAttributeValue_When_gettingParametersOrCategory_Then_returnEmpty() {
		FilterTest filter = new FilterTest("","","",
				"",
				"","","","","","","","","","","","","","");
		assertEquals(filter.getWrittenDateMax(), "0001-01-01");
		assertEquals(filter.toUrlParameters(), "");
	}

	@Test
	void given_SpecialCharMaxAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","","",
                		"-3+(>>=",
                		"","","","","","","","","","","","","","") 
                	);
	}

	@Test
	void given_WordMaxAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
		        		() -> new FilterTest("","","",
		        			"aepm",
		        			"","","","","","","","","","","","","","") 
		        	);
	}

	@Test
	void given_NumberMaxAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
		        		() -> new FilterTest("","","",
		        			"83",
		        			"","","","","","","","","","","","","","") 
		        	);
	}

	@Test
	void given_InvalidDateMaxAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
		        		() -> new FilterTest("","","",
		        			"2012-18-42",
		        			"","","","","","","","","","","","","","") 
		        	);
	}

	@Test
	void given_beforeJCMaxAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","","",
        				"-1403-02-09",
        				"","","","","","","","","","","","","","")
                	);
	}

	@Test
	void given_beforeMinMaxAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","",
        				"1403-02-09","1201-05-16",
        				"","","","","","","","","","","","","","")
                	);
	}

	@Test
	void given_afterNowMaxAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookFilterException.class,
                		() -> new FilterTest("","","",
        				"2040-01-01",
        				"","","","","","","","","","","","","","")
                	);
	}

	@Test
	void given_relevantMaxAttributeValue_When_gettingParametersOrCategory_Then_returnValidAttributeOrParameters() {
		FilterTest filter = new FilterTest("","","",
				"2017-08-25",
				"","","","","","","","","","","","","","");
		assertEquals(filter.getWrittenDateMax(), "2017-08-25");
		assertEquals(filter.toUrlParameters(), "written_date_max=2017-08-25");
	}


}
