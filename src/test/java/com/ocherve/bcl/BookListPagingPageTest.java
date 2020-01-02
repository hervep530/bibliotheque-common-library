package com.ocherve.bcl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ocherve.bcl.dto.book.BookListPagingDvo;
import com.ocherve.bcl.exception.BookPagingException;

/**
 * 
 * 
 * @author herve_dev
 */
class BookListPagingPageTest {

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
	void given_NullPageIdValue_When_gettingParametersOrPageId_Then_returnZero() {
		PagingTest paging = new PagingTest("","","","","","","",null,"");
		assertEquals(paging.getPageId(), "0");
		assertEquals(paging.toUrlParameters(), "");
	}

	@Test
	void given_EmptyPageIdValue_When_gettingParametersOrPageId_Then_returnZero() {
		PagingTest paging = new PagingTest("","","","","","","","","");
		assertEquals(paging.getPageId(), "0");
		assertEquals(paging.toUrlParameters(), "");
	}

	@Test
	void given_WordPageIdValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookPagingException.class,
		        		() -> new PagingTest("","","","","","","","aepm","")
		        	);
	}

	@Test
	void given_OutOfRangePageIdValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookPagingException.class,
                		() -> new PagingTest("","","","","","","",
                				"999999999999999999999999999999999999999999999999999999",
                				"")
                	);
	}

	@Test
	void given_UnderRangePageIdValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookPagingException.class,
                		() -> new PagingTest("","","","","","","","-1","")
                	);
	}

	@Test
	void given_SpecialCharPageIdValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookPagingException.class,
                		() -> new PagingTest("","","","","","","","-3+(>>=","")
                	);
	}

	@Test
	void given_ZeroPageIdValue_When_gettingParametersOrPageId_Then_returnValidAttributeOrParameters() {
		PagingTest paging = new PagingTest("","","","","","","","0","");
		assertEquals(paging.getPageId(), "0");
		assertEquals(paging.toUrlParameters(), "");
	}

	@Test
	void given_ValidNumberPageIdValue_When_gettingParametersOrPageId_Then_returnValidAttributeOrParameters() {
		PagingTest paging = new PagingTest("","","","","","","","23","");
		assertEquals(paging.getPageId(), "23");
		assertEquals(paging.toUrlParameters(), "page=23");
	}

	@Test
	void given_NullLimitValue_When_gettingParametersOrLimit_Then_returnZero() {
		PagingTest paging = new PagingTest("","","","","","","","",null);
		assertEquals(paging.getPageLimit(), "0");
		assertEquals(paging.toUrlParameters(), "");
	}

	@Test
	void given_EmptyLimitValue_When_gettingParametersOrLimit_Then_returnZero() {
		PagingTest paging = new PagingTest("","","","","","","","","");
		assertEquals(paging.getPageLimit(), "0");
		assertEquals(paging.toUrlParameters(), "");
	}

	@Test
	void given_WordLimitValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookPagingException.class,
		        		() -> new PagingTest("","","","","","","","","aepm")
		        	);
	}

	@Test
	void given_OutOfRangeLimitValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookPagingException.class,
                		() -> new PagingTest("","","","","","","","",
                				"999999999999999999999999999999999999999999999999999")
                	);
	}

	@Test
	void given_UnderRangeLimitValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookPagingException.class,
                		() -> new PagingTest("","","","","","","","","-1")
                	);
	}

	@Test
	void given_SpecialCharLimitValue_When_instanciatingFilter_Then_ThrowFilterException() {
		assertThrows(BookPagingException.class,
                		() -> new PagingTest("","","","","","","","","-3+(>>=")
                	);
	}

	@Test
	void given_ZeroLimitValue_When_gettingParametersOrLimit_Then_returnValidAttributeOrParameters() {
		PagingTest paging = new PagingTest("","","","","","","","","0");
		assertEquals(paging.getPageLimit(), "0");
		assertEquals(paging.toUrlParameters(), "");
	}

	@Test
	void given_ValidNumberLimitValue_When_gettingParametersOrLimit_Then_returnValidAttributeOrParameters() {
		PagingTest paging = new PagingTest("","","","","","","","","40");
		assertEquals(paging.getPageLimit(), "40");
		assertEquals(paging.toUrlParameters(), "limit=40");
	}


}
