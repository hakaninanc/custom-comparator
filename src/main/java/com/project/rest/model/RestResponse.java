package com.project.rest.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Custom Rest Response model
 * @param <T>
 */
@Data
public class RestResponse<T> implements Serializable {
    private T data;
    private Date date;

    public static <T> RestResponse<T> of(T t) {
        return new RestResponse<>(t);
    }

    public RestResponse(T data) {
        this.data = data;
        this.date = new Date();
    }

}