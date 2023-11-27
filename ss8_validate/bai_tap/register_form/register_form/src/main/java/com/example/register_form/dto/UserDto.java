package com.example.register_form.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Validator {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if("".equals(userDto.firstName)){
            errors.rejectValue("firstName",null,"Not empty");
        }else if(userDto.firstName.length()<3 || userDto.firstName.length()>=45 ){
            errors.rejectValue("firstName",null,"First Name have more 3 symbol");
        }else if(!userDto.firstName.trim().matches("^[A-Z][a-z]*$")){
            errors.rejectValue("firstName",null,"First Name not format");
        }
        if("".equals(userDto.lastName)){
            errors.rejectValue("lastName",null,"Not empty");
        }else if(userDto.lastName.length()<3 || userDto.lastName.length()>=45){
            errors.rejectValue("lastName",null,"Last Name have more 3 symbol");
        }else if(!userDto.lastName.trim().matches("^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$")){
            errors.rejectValue("lastName",null,"Last Name not format");
        }
        if (!userDto.phoneNumber.trim().matches("^0\\d{9,10}$")) {
            errors.rejectValue("phoneNumber",null,"Phone number not format");
        }
        if(userDto.age<18 || userDto.age>100){
            errors.rejectValue("age",null,"age >=18 and <=100");
        }
        if(!userDto.email.trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            errors.rejectValue("email",null,"email not format");
        }
    }
}
