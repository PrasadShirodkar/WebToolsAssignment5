package pshirodkar.edu.neu.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.digester.rss.Channel;
import org.apache.commons.digester.rss.Item;
import org.apache.commons.digester.rss.RSSDigester;

import pshirodkar.edu.neu.constants.ReferenceConstants;
import pshirodkar.edu.neu.model.SearchCriteria;

/**
 * This service class provides the methods to retrieve the list of search
 * results for the given search criteria.
 * 
 * @author Prasad
 * 
 */
public class VerticalSearchEngineService {

	/**
	 * This method retrieves the search results for the given search criteria.
	 * 
	 * @param searchCriteria
	 * @return
	 * @throws Exception
	 */
	public List<Item> searchResults(SearchCriteria searchCriteria)
			throws Exception {

		RSSDigester digester = new RSSDigester();
		URL url = new URL(ReferenceConstants.WEBMD_MEDICINENET_PIPE_URL
				+ searchCriteria.getSearchText());
		HttpURLConnection httpSource = (HttpURLConnection) url.openConnection();
		Channel channel = (Channel) digester.parse(httpSource.getInputStream());
		if (channel == null) {
			throw new Exception("Cannot communicate with " + url);
		}

		Item rssItems[] = channel.findItems();

		List<Item> itemList = Arrays.asList(rssItems);

		return itemList;
	}
}