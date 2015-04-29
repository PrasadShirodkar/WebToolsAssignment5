package pshirodkar.edu.neu.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pshirodkar.edu.neu.model.SearchCriteria;

public class SearchCriteriaValidator implements Validator {

	@Override
	public boolean supports(Class<?> obj) {
		return SearchCriteria.class.equals(obj);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "searchText",
				"validation.searchText.required");
	}
}