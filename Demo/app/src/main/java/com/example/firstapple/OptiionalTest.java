package com.example.firstapple;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class OptiionalTest {

    String classNameWithOutAnnotation;
    @NonNull
    String classNameWithNonNull;
    @Nullable
    String classNameWithNullable;

    @Nullable
    public String setString(@Nullable String name){
        return  name+ "re";
    }
}
