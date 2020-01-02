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
public abstract class BookListPagingDvo {
	
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
	public BookListPagingDvo() {
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
	public BookListPagingDvo(String sortByCategory, String sortByWriter, 
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
		if (this.sortByCategory == null) return "";
		return this.sortByCategory;
	}

	/**
	 * @param sortByCategory the sortByCategory to set
	 */
	public void setSortByCategory(String sortByCategory) {
		if ( sortByCategory == null ) return;
		if ( sortByCategory.isEmpty() ) return;
		this.sortByCategory = sortByCategory.toUpperCase();
		if ( ! this.sortByCategory.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortByCategory.invalidValue");		
	}

	/**
	 * @return the sortByWriter
	 */
	public String getSortByWriter() {
		if (this.sortByWriter == null) return "";
		return this.sortByWriter;
	}

	/**
	 * @param sortByWriter the sortByWriter to set
	 */
	public void setSortByWriter(String sortByWriter) {
		if ( sortByWriter == null ) return;
		if ( sortByWriter.isEmpty() ) return;
		this.sortByWriter = sortByWriter.toUpperCase();
		if ( ! this.sortByWriter.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortByWriter.invalidValue");		
	}

	/**
	 * @return the sortById
	 */
	public String getSortById() {
		if (this.sortById == null) return "";
		return this.sortById;
	}

	/**
	 * @param sortById the sortById to set
	 */
	public void setSortById(String sortById) {
		if ( sortById == null ) return;
		if ( sortById.isEmpty() ) return;
		this.sortById = sortById.toUpperCase();
		if ( ! this.sortById.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortById.invalidValue");		
	}

	/**
	 * @return the sortByTitle
	 */
	public String getSortByTitle() {
		if (this.sortByTitle == null) return "";
		return this.sortByTitle;
	}

	/**
	 * @param sortByTitle the sortByTitle to set
	 */
	public void setSortByTitle(String sortByTitle) {
		if ( sortByTitle == null ) return;
		if ( sortByTitle.isEmpty() ) return;
		this.sortByTitle = sortByTitle.toUpperCase();
		if ( ! this.sortByTitle.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortByTitle.invalidValue");		
	}

	/**
	 * @return the sortByWrittenDate
	 */
	public String getSortByWrittenDate() {
		if (this.sortByWrittenDate == null) return "";
		return this.sortByWrittenDate;
	}

	/**
	 * @param sortByWrittenDate the sortByWrittenDate to set
	 */
	public void setSortByWrittenDate(String sortByWrittenDate) {
		if ( sortByWrittenDate == null ) return;
		if ( sortByWrittenDate.isEmpty() ) return;
		this.sortByWrittenDate = sortByWrittenDate.toUpperCase();
		if ( ! this.sortByWrittenDate.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortByWrittenDate.invalidValue");		
	}

	/**
	 * @return the sortByPagesNumber
	 */
	public String getSortByPagesNumber() {
		if (this.sortByPagesNumber == null) return "";
		return this.sortByPagesNumber;
	}

	/**
	 * @param sortByPagesNumber the sortByPagesNumber to set
	 */
	public void setSortByPagesNumber(String sortByPagesNumber) {
		if ( sortByPagesNumber == null ) return;
		if ( sortByPagesNumber.isEmpty() ) return;
		this.sortByPagesNumber = sortByPagesNumber.toUpperCase();
		if ( ! this.sortByPagesNumber.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortByPagesNumber.invalidValue");		
	}

	/**
	 * @return the sortByQuantityAvailable
	 */
	public String getSortByQuantityAvailable() {
		if (this.sortByQuantityAvailable == null) return "";
		return this.sortByQuantityAvailable;
	}

	/**
	 * @param sortByQuantityAvailable the sortByQuantityAvailable to set
	 */
	public void setSortByQuantityAvailable(String sortByQuantityAvailable) {
		if ( sortByQuantityAvailable == null ) return;
		if ( sortByQuantityAvailable.isEmpty() ) return;
		this.sortByQuantityAvailable = sortByQuantityAvailable.toUpperCase();
		if ( ! this.sortByQuantityAvailable.toUpperCase().matches("^(|NONE|ASC|DESC)$") )
			throw new BookPagingException(this.messagePrefix + ".sortByQuantityAvailable.invalidValue");		
	}

	/**
	 * @return the pageId
	 */
	public String getPageId() {
		if (this.pageId == null) return "";
		return this.pageId;
	}

	/**
	 * @param pageId the pageId to set
	 */
	public void setPageId(String pageId) {
		if ( pageId == null ) return;
		if ( pageId.isEmpty() ) return;
		this.pageId = pageId;
		if ( ! this.pageId.matches("^[0-9]{1,9}$") )
			throw new BookPagingException(this.messagePrefix + ".pageId.invalidValue");
	}

	/**
	 * @return the pageLimit
	 */
	public String getPageLimit() {
		if (this.pageLimit == null) return "";
		return this.pageLimit;
	}

	/**
	 * @param pageLimit the pageLimit to set
	 */
	public void setPageLimit(String pageLimit) {
		if ( pageLimit == null ) return;
		if ( pageLimit.isEmpty() ) return;
		this.pageLimit = pageLimit.toUpperCase();
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
		if ( this.getSortById().toUpperCase().matches("ASC|DESC") ) 
			urlParameters += "sort_by_id=" + this.getSortById();
		if ( this.getSortByTitle().toUpperCase().matches("ASC|DESC") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sort_by_title=" + this.getSortByTitle();
		}
		if ( this.getSortByCategory().toUpperCase().matches("ASC|DESC") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sort_by_category=" + this.getSortByCategory();
		}
		if ( this.getSortByWriter().toUpperCase().matches("ASC|DESC") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sort_by_writer=" + this.getSortByWriter();
		}
		if ( this.getSortByWrittenDate().toUpperCase().matches("ASC|DESC") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sort_by_written_date=" + this.getSortByWrittenDate();
		}
		if ( this.getSortByPagesNumber().toUpperCase().matches("ASC|DESC") ) {
			if ( ! urlParameters.isEmpty() ) urlParameters += "&";
			urlParameters += "sort_by_pages_number=" + this.getSortByPagesNumber();
		}
		if ( this.getSortByQuantityAvailable().toUpperCase().matches("ASC|DESC") ) {
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
