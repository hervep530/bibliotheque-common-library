/**
 * 
 */
package com.ocherve.bcl.dto.book;

import java.sql.Date;

import com.ocherve.bcl.exception.BookFilterException;
import com.ocherve.util.format.DateConverter;

/**
 * Kind of DTO defining Filter for Book List
 * 
 * DVO instead of DTO : Data Validating Object
 * Objective : 
 * - Implementing accessor with logical in order to validate input data (attributes as String)
 * - Making this object ready to convert to model 
 * 
 * @author herve_dev
 *
 */
public abstract class BookListFilterDvo extends BookListPagingDvo {

	
	private String categoryId = "0";
	
	private String writerId = "0";
	
	private String writtenDateMin = "0001-01-01";
	
	private String writtenDateMax = "0001-01-01";
	
	private String pagesNumberMin = "0";
	
	private String pagesNumberMax = "0";
	
	private String quantityAvailableMin = "0";
	
	private String quantityAvailableMax = "0";
	
	private String words = "";
	
	private String sortByCategory = "NONE";
	
	private String sortByWriter = "NONE";
	
	private String sortById = "NONE";
	
	private String sortByTitle = "NONE";
	
	private String sortByWrittenDate = "NONE";
	
	private String sortByPagesNumber = "NONE";
	
	private String sortByQuantityAvailable = "NONE";
	
	private String pageId = "0";
	
	private String pageLimit = "0";
	
	private final String messagePrefix = "bcl.book.filter.error";
	
				
	/**
	 * 
	 */
	public BookListFilterDvo() {
		super();
	}
	
	/**
	 * @param categoryId
	 * @param writerId
	 * @param writtenDateMin
	 * @param writtenDateMax
	 * @param pagesNumberMin
	 * @param pagesNumberMax
	 * @param quantityAvailableMin
	 * @param quantityAvailableMax
	 * @param words
	 * @param sortByCategory 
	 * @param sortByWriter 
	 * @param sortById
	 * @param sortByTitle
	 * @param sortByWrittenDate
	 * @param sortByPagesNumber
	 * @param sortByQuantityAvailable
	 * @param pageId
	 * @param pageLimit
	 */
	public BookListFilterDvo(String categoryId, String writerId, String writtenDateMin, String writtenDateMax,
			String pagesNumberMin, String pagesNumberMax, String quantityAvailableMin,
			String quantityAvailableMax, String words, String sortByCategory, String sortByWriter, 
			String sortById, String sortByTitle, String sortByWrittenDate, String sortByPagesNumber,
			String sortByQuantityAvailable, 
			String pageId, String pageLimit) {
		super();
		this.setCategoryId(categoryId);
		this.setWriterId(writerId);
		this.setWrittenDateMin(writtenDateMin);
		this.setWrittenDateMax(writtenDateMax);
		this.setPagesNumberMin(pagesNumberMin);
		this.setPagesNumberMax(pagesNumberMax);
		this.setQuantityAvailableMin(quantityAvailableMin);
		this.setQuantityAvailableMax(quantityAvailableMax);
		this.setWords(words);
		this.setSortByCategory(sortByCategory);
		this.setSortByWriter(sortByWriter);
		// Mauvais
		this.setSortById(sortById);
		// Fin Mauvais
		this.setSortByTitle(sortByTitle);
		this.setSortByWrittenDate(sortByWrittenDate);
		this.setSortByPagesNumber(sortByPagesNumber);
		this.setSortByQuantityAvailable(sortByQuantityAvailable);
		this.setPageId(pageId);
		this.setPageLimit(pageLimit);
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		try {
			return this.categoryId;
		} catch (Exception e) { return "0"; }
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		// Excluding null or empty value 
		if (categoryId == null) return;
		if ( categoryId.isEmpty() ) return;
		// Setting value and validate or throw exception
		this.categoryId = categoryId;
		if ( ! this.categoryId.matches("^[0-9]{1,15}$") )
			throw new BookFilterException(this.messagePrefix + ".categoryId.invalidValue");
	}

	/**
	 * @return the writerId
	 */
	public String getWriterId() {
		try {
			return this.writerId;
		} catch (Exception e) { return "0"; }
	}

	/**
	 * @param writerId the writerId to set
	 */
	public void setWriterId(String writerId) {
		// Excluding null or empty value 
		if (writerId == null) return;
		if ( writerId.isEmpty() ) return;
		// Setting value and validate or throw exception
		this.writerId = writerId;
		if ( ! this.writerId.matches("^[0-9]{1,15}$") )
			throw new BookFilterException(this.messagePrefix + ".writerId.invalidValue");
	}

	/**
	 * @return the writtenDateMin
	 */
	public String getWrittenDateMin() {
		try {
			return this.writtenDateMin;
		} catch (Exception e) { return "0001-01-01"; }
	}

	/**
	 * @param writtenDateMin the writtenDateMin to set
	 */
	public void setWrittenDateMin(String writtenDateMin) {
		// Excluding null or empty value 
		if (writtenDateMin == null) return;
		if ( writtenDateMin.isEmpty() ) return;
		// Setting value and validate or throw exception
		this.writtenDateMin = writtenDateMin;
		Date dateMin = DateConverter.stringToSqlDate("yyy-MM-dd", this.writtenDateMin);
		if ( dateMin == null )
			throw new BookFilterException(this.messagePrefix + ".writtenDateMin.null");
		if ( dateMin.before(DateConverter.stringToSqlDate("yyyy-MM-dd", "0001-01-01")) )
			throw new BookFilterException(this.messagePrefix + ".writtenDateMin.beforeJC");
		if ( dateMin.after(DateConverter.sqlNow()) )
			throw new BookFilterException("this.messagePrefix + .writtenDateMin.afterNow");
	}

	/**
	 * @return the writtenDateMax
	 */
	public String getWrittenDateMax() {
		try {
			return this.writtenDateMax;
		} catch (Exception e) { return "0001-01-01"; }
	}

	/**
	 * @param writtenDateMax the writtenDateMax to set
	 */
	public void setWrittenDateMax(String writtenDateMax) {
		// Excluding null or empty value 
		if (writtenDateMax == null) return;
		if ( writtenDateMax.isEmpty() ) return;
		// Setting value and validate or throw exception
		this.writtenDateMax = writtenDateMax;
		Date dateMax = DateConverter.stringToSqlDate("yyy-MM-dd", this.writtenDateMax);
		Date dateMin = DateConverter.stringToSqlDate("yyy-MM-dd", this.writtenDateMin);
		if ( dateMax == null ) 
			throw new BookFilterException(this.messagePrefix + ".writtenDateMax.null");
		if ( dateMax.before(DateConverter.stringToSqlDate("yyyy-MM-dd", "0001-01-01")) )
			throw new BookFilterException(this.messagePrefix + ".writtenDateMax.beforeJC");
		if ( dateMax.before(dateMin) )
			throw new BookFilterException(this.messagePrefix + ".writtenDateMax.beforeMin");
		if ( dateMax.after(DateConverter.sqlNow()) )
			throw new BookFilterException(this.messagePrefix + ".writtenDateMax.afterNow");
	}

	/**
	 * @return the pagesNumberMin
	 */
	public String getPagesNumberMin() {
		try {
			return this.pagesNumberMin;
		} catch (Exception e) { return "0"; }
	}

	/**
	 * @param pagesNumberMin the pagesNumberMin to set
	 */
	public void setPagesNumberMin(String pagesNumberMin) {
		// Excluding null or empty value 
		if (pagesNumberMin == null) return;
		if ( pagesNumberMin.isEmpty() ) return;
		// Setting value and validate or throw exception
		this.pagesNumberMin = pagesNumberMin;
		if ( ! this.pagesNumberMin.matches("^[0-9]{1,4}$") )
			throw new BookFilterException(this.messagePrefix + ".pagesNumberMin.invalidValue");
		if ( Integer.valueOf(this.pagesNumberMin) > 2000 )
			throw new BookFilterException(this.messagePrefix + ".pagesNumberMin.moreThan2000");
	}

	/**
	 * @return the pagesNumberMax
	 */
	public String getPagesNumberMax() {
		try {
			return this.pagesNumberMax;
		} catch (Exception e) { return "0"; }
	}

	/**
	 * @param pagesNumberMax the pagesNumberMax to set
	 */
	public void setPagesNumberMax(String pagesNumberMax) {
		// Excluding null or empty value 
		if (pagesNumberMax == null) return;
		if ( pagesNumberMax.isEmpty() ) return;
		// Setting value and validate or throw exception
		this.pagesNumberMax = pagesNumberMax;
		if ( ! this.pagesNumberMax.matches("^[0-9]{1,4}$") )
			throw new BookFilterException(this.messagePrefix + ".pagesNumberMax.invalidValue");
		if ( Integer.valueOf(this.pagesNumberMax) < Integer.valueOf(this.pagesNumberMin) )
			throw new BookFilterException(this.messagePrefix + ".pagesNumberMax.lessThanMin");
		if ( Integer.valueOf(this.pagesNumberMax) > 2000 )
			throw new BookFilterException(this.messagePrefix + ".pagesNumberMax.moreThan2000");
	}

	/**
	 * @return the quantityAvailableMin
	 */
	public String getQuantityAvailableMin() {
		try {
			return this.quantityAvailableMin;
		} catch (Exception e) { return "0"; }
	}

	/**
	 * @param quantityAvailableMin the quantityAvailableMin to set
	 */
	public void setQuantityAvailableMin(String quantityAvailableMin) {
		// Excluding null or empty value 
		if (quantityAvailableMin == null) return;
		if ( quantityAvailableMin.isEmpty() ) return;
		// Setting value and validate or throw exception
		this.quantityAvailableMin = quantityAvailableMin;
		if ( ! this.quantityAvailableMin.matches("^[0-9]{1,3}$") )
			throw new BookFilterException(this.messagePrefix + ".quantityAvailableMin.invalidValue");
		if ( Integer.valueOf(this.quantityAvailableMin) > 200 )
			throw new BookFilterException(this.messagePrefix + ".quantityAvailableMin.moreThan200");
	}

	/**
	 * @return the quantityAvailableMax
	 */
	public String getQuantityAvailableMax() {
		try {
			return this.quantityAvailableMax;
		} catch (Exception e) { return "0"; }
	}

	/**
	 * @param quantityAvailableMax the quantityAvailableMax to set
	 */
	public void setQuantityAvailableMax(String quantityAvailableMax) {
		// Excluding null or empty value 
		if (quantityAvailableMax == null) return;
		if ( quantityAvailableMax.isEmpty() ) return;
		// Setting value and validate or throw exception
		this.quantityAvailableMax = quantityAvailableMax;
		if ( ! this.quantityAvailableMax.matches("^[0-9]{1,3}$") )
			throw new BookFilterException(this.messagePrefix + ".quantityAvailableMax.invalidValue");
		if ( Integer.valueOf(this.quantityAvailableMax) < Integer.valueOf(this.quantityAvailableMin) )
			throw new BookFilterException(this.messagePrefix + ".quantityAvailableMax.lessThanMin");
		if ( Integer.valueOf(this.quantityAvailableMax) > 200 )
			throw new BookFilterException(this.messagePrefix + ".quantityAvailableMax.moreThan200");
	}

	/**
	 * @return the words
	 */
	public String getWords() {
		try {
			return this.words;
		} catch (Exception e) { return ""; }
	}

	/**
	 * @param words the words to set
	 */
	public void setWords(String words) {
		// Excluding null or empty value 
		if (words == null) return;
		if ( words.isEmpty() ) return;
		// Setting value and validate or throw exception
		this.words = words;
	}	

	@Override
	public String toUrlParameters() {
		String urlParameters = "";
		if ( ! this.getCategoryId().contentEquals("0") ) urlParameters += "category_id=" + this.getCategoryId();
		if ( ! this.getWriterId().contentEquals("0") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "writer_id=" + this.getWriterId();
		}
		if ( ! this.getWrittenDateMin().contentEquals("0001-01-01") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "written_date_min=" + this.getWrittenDateMin();
		}
		if ( ! this.getWrittenDateMax().contentEquals("0001-01-01") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "written_date_max=" + this.getWrittenDateMax();
		}
		if ( ! this.getPagesNumberMin().contentEquals("0") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "pages_number_min=" + this.getPagesNumberMin();
		}
		if ( ! this.getPagesNumberMax().contentEquals("0") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "pages_number_max=" + this.getPagesNumberMax();
		}
		if ( ! this.getQuantityAvailableMin().contentEquals("0") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "quantity_available_min=" + this.getQuantityAvailableMin();
		}
		if ( ! this.getQuantityAvailableMax().contentEquals("0") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "quantity_available_max=" + this.getQuantityAvailableMax();
		}
		if ( ! this.getWords().isEmpty() ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "words=" + this.getWords();
		}
		if ( ! this.getSortByCategory().toLowerCase().contentEquals("none") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sort_by_category=" + this.getSortByCategory();
		}
		if ( ! this.getSortByWriter().toLowerCase().contentEquals("none") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sort_by_writer=" + this.getSortByWriter();
		}
// Mauvais
		if ( ! this.getSortById().toLowerCase().contentEquals("none") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sort_by_id=" + this.getSortById();
		}
// Fin Mauvais
		if ( ! this.getSortByTitle().toLowerCase().contentEquals("none") ) {
			if ( ! urlParameters.contentEquals("0") ) urlParameters += "&";
			urlParameters += "sort_by_title=" + this.getSortByTitle();
		}
		if ( ! this.getSortByWrittenDate().toLowerCase().contentEquals("none") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sort_by_written_date=" + this.getSortByWrittenDate();
		}
		if ( ! this.getSortByPagesNumber().toLowerCase().contentEquals("none") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sort_by_pages_number=" + this.getSortByPagesNumber();
		}
		if ( ! this.getSortByQuantityAvailable().toLowerCase().contentEquals("none") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sort_by_quantity_available=" + this.getSortByQuantityAvailable();
		}
		if ( ! this.getPageId().contentEquals("0") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "page=" + this.getPageId();
		}
		if ( ! this.getPageLimit().contentEquals("0") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "limit=" + this.getPageLimit();
		}

		return urlParameters;

	}

	@Override
	public String toString() {
		return "BookSearchDto {"
					+ "categoryId:" + categoryId 
					+ ", writerId:" + writerId 
					+ ", writtenDateMin:" + writtenDateMin 
					+ ", writtenDateMax:" + writtenDateMax 
					+ ", pagesNumberMin:" + pagesNumberMin
					+ ", pagesNumberMax:" + pagesNumberMax 
					+ ", quantityAvailableMin:" + quantityAvailableMin
					+ ", quantityAvailableMax:" + quantityAvailableMax 
					+ ", words:" + words 
					+ ", sortByCategory:" + sortByCategory 
					+ ", sortByWriter:" + sortByWriter 
					+ ", sortById:" + sortById 
					+ ", sortByTitle:" + sortByTitle 
					+ ", sortByWrittenDate:" + sortByWrittenDate 
					+ ", sortByPagesNumber:" + sortByPagesNumber
					+ ", sortByQuantityAvailable:" + sortByQuantityAvailable 
					+ ", pageId:" + pageId 
					+ ", pageLimit:" + pageLimit 
				+ "}";
	} 
	
	/**
	 * Providing toString with adding end of lines
	 * 
	 * @return toString() with end of lines
	 */
	public String toStringWithEOL() {
		return String.format(this.toString().replaceAll("\\{", "{%n")
											.replaceAll("\\}", "%n}")
											.replaceAll(", ", ", %n"));
	}	

}
