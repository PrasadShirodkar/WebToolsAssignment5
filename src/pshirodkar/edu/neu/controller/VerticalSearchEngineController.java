package pshirodkar.edu.neu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.digester.rss.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pshirodkar.edu.neu.model.SearchCriteria;
import pshirodkar.edu.neu.service.VerticalSearchEngineService;
import pshirodkar.edu.neu.validator.SearchCriteriaValidator;

/**
 * The purpose of this controller is to retrieve the list of search results for
 * the given search criteria.
 * 
 * @author Prasad
 * 
 */
@Controller
public class VerticalSearchEngineController {

	@Autowired
	private VerticalSearchEngineService verticalSearchEngineService;

	public void setPipesSearchService(
			VerticalSearchEngineService verticalSearchEngineService) {
		this.verticalSearchEngineService = verticalSearchEngineService;
	}

	@RequestMapping(value = "/Search", method = RequestMethod.POST)
	public ModelAndView displaySearchResults(
			@ModelAttribute("command") SearchCriteria searchCriteria,
			BindingResult result, HttpServletRequest request) throws Exception {

		new SearchCriteriaValidator().validate(searchCriteria, result);
		if (result.hasErrors()) {
			return new ModelAndView("search", "command", searchCriteria);
		}
		
		//Retrieve search results for the search criteria
		List<Item> itemList = verticalSearchEngineService
				.searchResults(searchCriteria);
		
		//If the search does not yield search results, then note this condition
		//and accordingly display an appropriate message to the user
		if (itemList == null || itemList.isEmpty()) {
			request.setAttribute("noSearchResults", true);
		}
		
		return new ModelAndView("search", "searchResults", itemList);
	}

	@RequestMapping(value = "/DisplaySearch", method = RequestMethod.GET)
	public ModelAndView displayLogin() {

		return new ModelAndView("search", "command", new SearchCriteria());
	}
}