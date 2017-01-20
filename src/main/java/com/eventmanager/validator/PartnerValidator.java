package com.eventmanager.validator;

import com.eventmanager.model.Partner;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PartnerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Partner.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.partner.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.partner.description");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "website", "NotEmpty.partner.website");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.partner.address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephone", "NotEmpty.partner.telephone");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.partner.email");
    }
}
