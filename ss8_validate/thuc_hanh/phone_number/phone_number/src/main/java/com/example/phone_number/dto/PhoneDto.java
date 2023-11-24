package com.example.phone_number.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDto implements Validator {

    private String numberPhone;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneDto phoneDto = (PhoneDto) target;
        String number = phoneDto.getNumberPhone();
        ValidationUtils.rejectIfEmpty(errors, "numberPhone", "numberPhone.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("numberPhone", "numberPhone.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("numberPhone", "numberPhone.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("numberPhone", "numberPhone.matches");
        }
    }
}
