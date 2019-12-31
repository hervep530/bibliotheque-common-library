/**
 * 
 */
package com.ocherve.bcl.dto.book;

import java.sql.Date;

import com.ocherve.bcl.exception.BookFilterException;
import com.ocherve.util.format.DateConverter;

/**
 * @author herve_dev
 *
 */
public class BookListFilter extends BookListPaging {

	
	protected String categoryId = "0";
	
	protected String writerId = "0";
	
	protected String writtenDateMin = "0001-01-01";
	
	protected String writtenDateMax = DateConverter.sqlNow().toString();
	
	protected String pagesNumberMin = "0";
	
	protected String pagesNumberMax = "0";
	
	protected String quantityAvailableMin = "0";
	
	protected String quantityAvailableMax = "0";
	
	protected String words = "";
				
	/**
	 * 
	 */
	public BookListFilter() {
		super();
		this.messagePrefix = "bcl.book.filter.error";
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
	public BookListFilter(String categoryId, String writerId, String writtenDateMin, String writtenDateMax,
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
		this.setSortById(sortById);
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
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		if ( categoryId.isEmpty() ) return;
		this.categoryId = categoryId;
		if ( ! this.categoryId.matches("^[0-9]{1,15}$") )
			throw new BookFilterException(this.messagePrefix + ".categoryId.invalidValue");
	}

	/**
	 * @return the writerId
	 */
	public String getWriterId() {
		return writerId;
	}

	/**
	 * @param writerId the writerId to set
	 */
	public void setWriterId(String writerId) {
		if ( writerId.isEmpty() ) return;
		this.writerId = writerId;
		if ( ! this.writerId.matches("^[0-9]{1,15}$") )
			throw new BookFilterException(this.messagePrefix + ".writerId.invalidValue");
	}

	/**
	 * @return the writtenDateMin
	 */
	public String getWrittenDateMin() {
		return writtenDateMin;
	}

	/**
	 * @param writtenDateMin the writtenDateMin to set
	 */
	public void setWrittenDateMin(String writtenDateMin) {
		if ( writtenDateMin.isEmpty() ) return;
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
		return writtenDateMax;
	}

	/**
	 * @param writtenDateMax the writtenDateMax to set
	 */
	public void setWrittenDateMax(String writtenDateMax) {
		if ( writtenDateMax.isEmpty() ) return;
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
		return pagesNumberMin;
	}

	/**
	 * @param pagesNumberMin the pagesNumberMin to set
	 */
	public void setPagesNumberMin(String pagesNumberMin) {
		if ( pagesNumberMin.isEmpty() ) return;
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
		return pagesNumberMax;
	}

	/**
	 * @param pagesNumberMax the pagesNumberMax to set
	 */
	public void setPagesNumberMax(String pagesNumberMax) {
		if ( pagesNumberMax.isEmpty() ) return;
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
		return quantityAvailableMin;
	}

	/**
	 * @param quantityAvailableMin the quantityAvailableMin to set
	 */
	public void setQuantityAvailableMin(String quantityAvailableMin) {
		if ( quantityAvailableMin.isEmpty() ) return;
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
		return quantityAvailableMax;
	}

	/**
	 * @param quantityAvailableMax the quantityAvailableMax to set
	 */
	public void setQuantityAvailableMax(String quantityAvailableMax) {
		if ( quantityAvailableMax.isEmpty() ) return;
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
		return words;
	}

	/**
	 * @param words the words to set
	 */
	public void setWords(String words) {
		if ( categoryId.isEmpty() ) return;
		this.words = words;
	}

	@Override
	public String toUrlParameters() {
		String urlParameters = "";
		if ( ! this.sortById.isEmpty() ) urlParameters += "sortById=" + this.sortById;
		if ( ! this.sortByTitle.isEmpty() ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sortByTitle=" + this.sortByTitle;
		}
		if ( ! this.sortByCategory.isEmpty() ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sortByCategory=" + this.sortByCategory;
		}
		if ( ! this.sortByWriter.isEmpty() ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sortByWriter=" + this.sortByWriter;
		}
		if ( ! this.sortByWrittenDate.isEmpty() ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sortByWrittenDate=" + this.sortByWrittenDate;
		}
		if ( ! this.sortByPagesNumber.isEmpty() ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sortByPagesNumber=" + this.sortByPagesNumber;
		}
		if ( ! this.sortByQuantityAvailable.isEmpty() ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sortByQuantityAvailable=" + this.sortByQuantityAvailable;
		}
		if ( ! this.pageId.contentEquals("0") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "page=" + this.pageId;
		}
		if ( ! this.pageLimit.contentEquals("0") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "limit=" + this.pageLimit;
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
