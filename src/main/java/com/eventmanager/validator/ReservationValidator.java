package com.eventmanager.validator;

import com.eventmanager.model.Reservation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ReservationValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Reservation.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Reservation reservation = (Reservation) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.reservation.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.reservation.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.reservation.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephone", "NotEmpty.reservation.telephone");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "NotEmpty.reservation.amount");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "finalPrice", "NotEmpty.reservation.finalPrice");

        if (reservation.getAmount() == null || reservation.getAmount() <= 0) {
            errors.rejectValue("amount", "Zero.reservation.amount");
        }
        if (reservation.getFinalPrice() == null || reservation.getFinalPrice() <= 0) {
            errors.rejectValue("finalPrice", "Zero.reservation.finalPrice");
        }
        if (reservation.getEvent() == null || reservation.getEvent().getFreeAmount() < reservation.getAmount()) {
            errors.rejectValue("amount", "Event.reservation.amount");
        }
    }
}
