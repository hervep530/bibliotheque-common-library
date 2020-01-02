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

/**
 * @author herve_dev
 *
 */
class BookListFilterGlobalTest {

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
		
		FilterTest(){
			super();
		}
				
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
	void given_filterFromNullAttributes_When_getParametersString_Then_returnEmptyString() {
		FilterTest filter = new FilterTest("","","","","","","","","","","","","","","","","","");
		assertEquals(filter.toUrlParameters(), "");
	}

	@Test
	void given_filterWithRelevantValues_When_getParamterString_Then_returnCorrectParamtersUrl() {
		FilterTest filter = new FilterTest("4","2",
				"1200-01-01","2019-12-29",
				"5","500",
				"1","12",
				"ipsum",
				"asc","asc","desc","desc","desc","desc","desc",
				"2","23");
		String checkingString = "category_id=4&writer_id=2";
		checkingString += "&written_date_min=1200-01-01&written_date_max=2019-12-29&pages_number_min=5";
		checkingString += "&pages_number_max=500&quantity_available_min=1&quantity_available_max=12&words=ipsum";
		checkingString += "&sort_by_category=ASC&sort_by_writer=ASC&sort_by_id=DESC&sort_by_title=DESC";
		checkingString += "&sort_by_written_date=DESC&sort_by_pages_number=DESC&sort_by_quantity_available=DESC";
		checkingString += "&page=2&limit=23";
		
		assertEquals(filter.toUrlParameters(), checkingString);
	}



	@Test
	void given_FilterWithoutAttribute_when_gettingParametersOrCategory_Then_returnInactiveAttribute() {
		FilterTest filter = new FilterTest();
		assertEquals(filter.getCategoryId(), "0");
		assertEquals(filter.getWriterId(), "0");
		assertEquals(filter.getWrittenDateMin(), "0001-01-01");
		assertEquals(filter.getWrittenDateMax(), "0001-01-01");
		assertEquals(filter.getPagesNumberMin(), "0");
		assertEquals(filter.getPagesNumberMax(), "0");
		assertEquals(filter.getQuantityAvailableMin(), "0");
		assertEquals(filter.getQuantityAvailableMax(), "0");
		assertEquals(filter.getWords(), "");
		assertEquals(filter.toUrlParameters(), "");				
	}


}
