package com.abdel.mijnproject.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.abdel.mijnproject.data.entities.User;
import com.abdel.mijnproject.data.entities.User;

@Dao
public interface UserDao {

    @Insert
    long insertUser(User user);

    @Query("SELECT * FROM users where emailId=:emailId limit 1")
    User getUserByEmailId(String emailId);

    @Query("SELECT * FROM users WHERE emailId = :emailId AND dob = :dob")
    User getUserByEmailIDAndDob(String emailId, String dob);

    @Query("SELECT * FROM users where emailId=:emailId and password=:password limit 1")
    User getUserByIdAndPassword(String emailId,String password);

    @Query("UPDATE users SET password = :newPassword WHERE emailId = :emailId")
    int updateUserPassword(String emailId, String newPassword);

}
