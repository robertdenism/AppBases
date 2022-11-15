package com.example.appbases;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;


@Entity(tableName = "Ocio")
public class User {
    @PrimaryKey
    @NotNull
    public String uid;

    @ColumnInfo(name = "ocio")
    public String ocio;

    @ColumnInfo(name = "categoria")
    public String categoria;

    @ColumnInfo(name ="descripcion")
    public String descripcion;

    @ColumnInfo(name = "direccion")
    public String direccion;

    public User(){
        uid = UUID.randomUUID().toString();
    }
}
