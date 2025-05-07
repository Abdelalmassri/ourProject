package com.abdel.mijnproject.repository;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.service.autofill.SaveCallback;

import com.abdel.mijnproject.repository.UserRepositoryInterface;
import com.abdel.mijnproject.data.dao.UserDao;
import com.abdel.mijnproject.data.database.AppDatabase;
import com.abdel.mijnproject.data.entities.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocalLoginRepository implements UserRepositoryInterface {

    private final UserDao userDao;
    private final ExecutorService executorService;


    public LocalLoginRepository(Context context) {
        AppDatabase db=AppDatabase.getINSTANCE(context);
        userDao=db.userDao();
        executorService= Executors.newSingleThreadExecutor();
    }






    @Override
    public void login(String email, String password, ValidateCallBack validateCallBack) {
        executorService.execute(() ->{
            User user=userDao.getUserByIdAndPassword(email,password);
            if(user != null){
                new Handler(Looper.getMainLooper()).post(()-> validateCallBack.onSuccess(user));
            }
            else {
                new Handler(Looper.getMainLooper()).post(()->validateCallBack.onError("Invalid credentials"));
            }
        });
    }

    @Override
    public void validateUser(String emailId, String dob, ValidateCallBack validateCallBack) {
        executorService.execute(() ->{
            User user=userDao.getUserByEmailIDAndDob(emailId,dob);
            if(user != null){
                new Handler(Looper.getMainLooper()).post(()-> validateCallBack.onSuccess(user));
            }
            else {
                new Handler(Looper.getMainLooper()).post(()->validateCallBack.onError("Invalid credentials"));
            }
        });
    }

    @Override
    public void changePassword(String emailid, String newPassword, SaveCallBack callback) {
        executorService.execute(() ->{
            int  updateCount=userDao.updateUserPassword(emailid,newPassword);
            if(updateCount > 0){
                new Handler(Looper.getMainLooper()).post(()-> callback.onSuccess());
            }
            else {
                new Handler(Looper.getMainLooper()).post(()->callback.onError("Failed to change password"));
            }
        });
    }

    @Override
    public void signUp(User user, SaveCallBack saveCallBack) {
        executorService.execute(() -> {
            // Check if user with the same passportId already exists
            User existingUser = userDao.getUserByEmailId(user.getEmailId());
            if (existingUser != null) {
                // User already exists
                new Handler(Looper.getMainLooper()).post(() -> saveCallBack.onError("A user with this ID already exists."));

            } else {
                // Insert new user into the database
                long newUserId = userDao.insertUser(user);
                if (newUserId != -1) {
                    new Handler(Looper.getMainLooper()).post(() -> saveCallBack.onSuccess());
                } else {
                    new Handler(Looper.getMainLooper()).post(() -> saveCallBack.onError("Failed to sign up. Please try again."));

                }
            }
        });
    }
}
