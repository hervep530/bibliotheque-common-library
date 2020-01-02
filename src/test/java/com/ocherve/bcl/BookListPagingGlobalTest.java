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

/**
 * @author herve_dev
 *
 */
class BookListPagingGlobalTest {

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
		PagingTest paging = new PagingTest("","","","","","","","","");
		assertEquals(paging.getSortByCategory(), "NONE");
		assertEquals(paging.getSortByWriter(), "NONE");
		assertEquals(paging.getSortByTitle(), "NONE");
		assertEquals(paging.getSortById(), "NONE");
		assertEquals(paging.getSortByPagesNumber(), "NONE");
		assertEquals(paging.getSortByQuantityAvailable(), "NONE");
		assertEquals(paging.getSortByWrittenDate(), "NONE");
		assertEquals(paging.getPageId(), "0");
		assertEquals(paging.getPageLimit(), "0");
		assertEquals(paging.toUrlParameters(), "");
	}

	@Test
	void given_DescLowerAttributeValue_When_gettingParametersOrCategory_Then_returnValidAttributeOrParameters() {
		PagingTest paging = new PagingTest("asc","desc","asc","desc","asc","desc","asc","2","30");
		assertEquals(paging.getSortByCategory(), "ASC");
		assertEquals(paging.getSortByWriter(), "DESC");
		assertEquals(paging.getSortById(), "ASC");
		assertEquals(paging.getSortByTitle(), "DESC");
		assertEquals(paging.getSortByWrittenDate(), "ASC");
		assertEquals(paging.getSortByPagesNumber(), "DESC");
		assertEquals(paging.getSortByQuantityAvailable(), "ASC");
		assertEquals(paging.getPageId(), "2");
		assertEquals(paging.getPageLimit(), "30");
		String sortString = "sort_by_id=ASC";
		sortString += "&sort_by_title=DESC";
		sortString += "&sort_by_category=ASC";
		sortString += "&sort_by_writer=DESC";
		sortString += "&sort_by_written_date=ASC";
		sortString += "&sort_by_pages_number=DESC";
		sortString += "&sort_by_quantity_available=ASC";
		sortString += "&page=2";
		sortString += "&limit=30";
		
		assertEquals(paging.toUrlParameters(), sortString);
	}

}
