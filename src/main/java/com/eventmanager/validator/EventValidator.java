package com.eventmanager.validator;

import com.eventmanager.model.Event;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Event event = (Event) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.event.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.event.description");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.event.price");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "NotEmpty.event.amount");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "freeAmount", "NotEmpty.event.freeAmount");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventDate", "NotEmpty.event.eventDate");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishedAt", "NotEmpty.event.publishedAt");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "closedAt", "NotEmpty.event.closedAt");

        if (event.getPrice() == null || event.getPrice() <= 0) {
            errors.rejectValue("price", "Zero.event.price");
        }
        if (event.getPrice() == null || event.getAmount() <= 0) {
            errors.rejectValue("amount", "Zero.event.amount");
        }
        if (event.getPrice() == null || event.getFreeAmount() < 0) {
            errors.rejectValue("freeAmount", "Zero.event.freeAmount");
        }
    }
}
