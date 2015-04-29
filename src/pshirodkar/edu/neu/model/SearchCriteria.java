package pshirodkar.edu.neu.model;

/**
 * This domain class represents the information for the search operation.
 * 
 * @author Prasad
 *
 */
public class SearchCriteria {

	private String searchText;

	private String searchURL;
	
	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getSearchURL() {
		return searchURL;
	}

	public void setSearchURL(String searchURL) {
		this.searchURL = searchURL;
	}
}