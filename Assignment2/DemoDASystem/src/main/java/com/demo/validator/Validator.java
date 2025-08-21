package com.demo.validator;

import com.demo.exception.DemoDASystemException;
import com.demo.model.TraineeDTO;

public class Validator {

    // Message text expected by the assignment/UI
    public static final String INVALID_DETAILS = "Invalid trainee details";

    private Validator() {}

    // Master validate method
    public static void validate(TraineeDTO trainee) throws DemoDASystemException {
        if (trainee == null
            || trainee.getId() == null
            || trainee.getId() <= 0
            || trainee.getPhoneNo() == null
            || !validateTraineePhoneNo(trainee.getPhoneNo())) {
            throw new DemoDASystemException(INVALID_DETAILS);
        }
    }

    // Phone number must be exactly 10 digits and start with 7/8/9
    public static boolean validateTraineePhoneNo(String phoneNo) {
        if (phoneNo == null) return false;
        return phoneNo.matches("^[789][0-9]{9}$");
    }
}
