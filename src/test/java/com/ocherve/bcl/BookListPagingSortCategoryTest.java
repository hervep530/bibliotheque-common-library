/**
 * 
 */
package com.ocherve.bcl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ocherve.bcl.dto.book.BookListPagingDvo;
import com.ocherve.bcl.exception.BookPagingException;

/**
 * @author herve_dev
 *
 */
class BookListPagingSortCategoryTest {

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
	
	private class PagingTest extends BookListPagingDvo {
				
		PagingTest(String sortByCategory, String sortByWriter, 
				String sortById, String sortByTitle, String sortByWrittenDate, String sortByPagesNumber,
				String sortByQuantityAvailable, 
				String pageId, String pageLimit) {
			super(sortByCategory, sortByWriter, 
					sortById, sortByTitle, sortByWrittenDate, sortByPagesNumber,
					sortByQuantityAvailable, 
					pageId, pageLimit);
		}
	}

	@Test
	void given_NullAttributeValue_When_gettingParametersOrCategory_Then_returnEmpty() {
		PagingTest paging = new PagingTest(null,
				"","","","","","","","");
		assertEquals(paging.getSortByCategory(), "NONE");
		assertEquals(paging.toUrlParameters(), "");
	}

	@Test
	void given_EmptyAttributeValue_When_gettingParametersOrCategory_Then_returnEmpty() {
		PagingTest paging = new PagingTest("",
				"","","","","","","","");
		assertEquals(paging.getSortByCategory(), "NONE");
		assertEquals(paging.toUrlParameters(), "");
	}

	@Test
	void given_WordAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookPagingException.class,
		        		() -> new PagingTest("aepm",
		        				"","","","","","","","")
		        	);
	}

	@Test
	void given_OutOfRangeAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookPagingException.class,
                		() -> new PagingTest("99999999",
		        				"","","","","","","","")
                	);
	}

	@Test
	void given_SpecialCharAttributeValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookPagingException.class,
                		() -> new PagingTest("-3+(>>=",
		        				"","","","","","","","")
                	);
	}

	@Test
	void given_AscAttributeValue_When_gettingParametersOrCategory_Then_returnValidAttributeOrParameters() {
		PagingTest paging = new PagingTest("asc","","","","","","","","");
		assertEquals(paging.getSortByCategory(), "ASC");
		assertEquals(paging.toUrlParameters(), "sort_by_category=ASC");
	}

	@Test
	void given_DescLowerAttributeValue_When_gettingParametersOrCategory_Then_returnValidAttributeOrParameters() {
		PagingTest paging = new PagingTest("desc","","","","","","","","");
		assertEquals(paging.getSortByCategory(), "DESC");
		assertEquals(paging.toUrlParameters(), "sort_by_category=DESC");
	}

	@Test
	void given_DescUpperAttributeValue_When_gettingParametersOrCategory_Then_returnValidAttributeOrParameters() {
		PagingTest paging = new PagingTest("DESC","","","","","","","","");
		assertEquals(paging.getSortByCategory(), "DESC");
		assertEquals(paging.toUrlParameters(), "sort_by_category=DESC");
	}

	@Test
	void given_NoneAttributeValue_When_gettingParametersOrCategory_Then_returnValidAttributeOrParameters() {
		PagingTest paging = new PagingTest("none","","","","","","","","");
		assertEquals(paging.getSortByCategory(), "NONE");
		assertEquals(paging.toUrlParameters(), "");
	}


}
