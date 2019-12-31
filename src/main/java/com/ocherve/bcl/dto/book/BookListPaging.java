/**
 * 
 */
package com.ocherve.bcl.dto.book;


import com.ocherve.bcl.exception.BookPagingException;

/**
 * Building paging arguments with validating given value
 * Can be used in controllers or in sorting forms
 * 
 * @author herve_dev
 *
 */
public class BookListPaging {
	
	protected String sortByCategory = "NONE";
	
	protected String sortByWriter = "NONE";
	
	protected String sortById = "NONE";
	
	protected String sortByTitle = "NONE";
	
	protected String sortByWrittenDate = "NONE";
	
	protected String sortByPagesNumber = "NONE";
	
	protected String sortByQuantityAvailable = "NONE";
	
	protected String pageId = "0";
	
	protected String pageLimit = "0";
	
	protected String messagePrefix = "bcl.book.paging.error";
	
	/**
	 * 
	 */
	public BookListPaging() {
		super();
	}
	
	/**
	 * Constructor with all fields
	 * 
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
	public BookListPaging(String sortByCategory, String sortByWriter, 
			String sortById, String sortByTitle, String sortByWrittenDate, String sortByPagesNumber,
			String sortByQuantityAvailable, 
			String pageId, String pageLimit) {
		super();
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
	 * @return the sortByCategory
	 */
	public String getSortByCategory() {
		return sortByCategory;
	}

	/**
	 * @param sortByCategory the sortByCategory to set
	 */
	public void setSortByCategory(String sortByCategory) {
		if ( sortByCategory.isEmpty() ) return;
		this.sortByCategory = sortByCategory;
		if ( ! this.sortByCategory.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortByCategory.invalidValue");		
	}

	/**
	 * @return the sortByWriter
	 */
	public String getSortByWriter() {
		return sortByWriter;
	}

	/**
	 * @param sortByWriter the sortByWriter to set
	 */
	public void setSortByWriter(String sortByWriter) {
		if ( sortByWriter.isEmpty() ) return;
		this.sortByWriter = sortByWriter;
		if ( ! this.sortByWriter.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortByWriter.invalidValue");		
	}

	/**
	 * @return the sortById
	 */
	public String getSortById() {
		return sortById;
	}

	/**
	 * @param sortById the sortById to set
	 */
	public void setSortById(String sortById) {
		if ( sortById.isEmpty() ) return;
		this.sortById = sortByCategory;
		if ( ! this.sortById.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortById.invalidValue");		
	}

	/**
	 * @return the sortByTitle
	 */
	public String getSortByTitle() {
		return sortByTitle;
	}

	/**
	 * @param sortByTitle the sortByTitle to set
	 */
	public void setSortByTitle(String sortByTitle) {
		if ( sortByTitle.isEmpty() ) return;
		this.sortByTitle = sortByTitle;
		if ( ! this.sortByTitle.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortByTitle.invalidValue");		
	}

	/**
	 * @return the sortByWrittenDate
	 */
	public String getSortByWrittenDate() {
		return sortByWrittenDate;
	}

	/**
	 * @param sortByWrittenDate the sortByWrittenDate to set
	 */
	public void setSortByWrittenDate(String sortByWrittenDate) {
		if ( sortByWrittenDate.isEmpty() ) return;
		this.sortByWrittenDate = sortByWrittenDate;
		if ( ! this.sortByWrittenDate.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortByWrittenDate.invalidValue");		
	}

	/**
	 * @return the sortByPagesNumber
	 */
	public String getSortByPagesNumber() {
		return sortByPagesNumber;
	}

	/**
	 * @param sortByPagesNumber the sortByPagesNumber to set
	 */
	public void setSortByPagesNumber(String sortByPagesNumber) {
		if ( sortByPagesNumber.isEmpty() ) return;
		this.sortByPagesNumber = sortByPagesNumber;
		if ( ! this.sortByPagesNumber.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortByPagesNumber.invalidValue");		
	}

	/**
	 * @return the sortByQuantityAvailable
	 */
	public String getSortByQuantityAvailable() {
		return sortByQuantityAvailable;
	}

	/**
	 * @param sortByQuantityAvailable the sortByQuantityAvailable to set
	 */
	public void setSortByQuantityAvailable(String sortByQuantityAvailable) {
		if ( sortByQuantityAvailable.isEmpty() ) return;
		this.sortByQuantityAvailable = sortByQuantityAvailable;
		if ( ! this.sortByQuantityAvailable.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortByQuantityAvailable.invalidValue");		
	}

	/**
	 * @return the pageId
	 */
	public String getPageId() {
		return pageId;
	}

	/**
	 * @param pageId the pageId to set
	 */
	public void setPageId(String pageId) {
		if ( pageId.isEmpty() ) return;
		this.pageId = pageId;
		if ( ! this.pageId.matches("^[0-9]{1,9}$") )
			throw new BookPagingException(this.messagePrefix + ".pageId.invalidValue");
	}

	/**
	 * @return the pageLimit
	 */
	public String getPageLimit() {
		return pageLimit;
	}

	/**
	 * @param pageLimit the pageLimit to set
	 */
	public void setPageLimit(String pageLimit) {
		if ( pageLimit.isEmpty() ) return;
		this.pageLimit = pageLimit;
		if ( ! this.pageLimit.matches("^[0-9]{1,3}$") )
			throw new BookPagingException(this.messagePrefix + ".pageLimit.invalidValue");
	}

	/**
	 * Extracting string needed to add parameters in url from this object (usefull to build request on api)
	 * 
	 * @return url parameters
	 */
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
				+ "sortByCategory=" + this.sortByCategory 
				+ ", sortByWriter=" + this.sortByWriter 
				+ ", sortById=" + this.sortById 
				+ ", sortByTitle=" + this.sortByTitle 
				+ ", sortByWrittenDate=" + this.sortByWrittenDate 
				+ ", sortByPagesNumber=" + this.sortByPagesNumber
				+ ", sortByQuantityAvailable=" + this.sortByQuantityAvailable 
				+ ", pageId=" + this.pageId 
				+ ", pageLimit=" + this.pageLimit 
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
