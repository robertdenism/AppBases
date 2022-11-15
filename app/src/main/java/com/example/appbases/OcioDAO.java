package com.example.appbases;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OcioDAO {
    @Query("SELECT * FROM Ocio")
    List<User> getAll();

    @Query("SELECT * FROM Ocio WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Ocio WHERE ocio LIKE :first AND " +
            "direccion LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}