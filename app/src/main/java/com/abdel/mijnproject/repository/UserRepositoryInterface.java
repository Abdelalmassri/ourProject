package com.abdel.mijnproject.repository;

import com.abdel.mijnproject.data.entities.User;

public interface UserRepositoryInterface {

    void login(String email, String password, ValidateCallBack validateCallBack);

    void validateUser(String emailId,String dob,ValidateCallBack validateCallBack);

    void changePassword(String emailid, String newPassword, SaveCallBack callback);
    void signUp(User user, SaveCallBack saveCallBack);
    interface ValidateCallBack{
        void onSuccess(User user);
        void onError(String errormessage);
    }
    interface SaveCallBack {
        void onSuccess();
        void onError(String errorMessage);
    }

}
