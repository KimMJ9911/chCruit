package com.recruit.chCruit.infra.DTO;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GenericApiResponse<T> {
    private String status;
    private String message;
    private T data;

    public static <T> GenericApiResponse<T> success(T data) {
        return new GenericApiResponse<>("success" , null , data);
    }

    public static <T> GenericApiResponse<T> fail(String message) {
        return new GenericApiResponse<>("fail" , message , null);
    }

    public static <T> GenericApiResponse<T> success(String message, T data) {
        return new GenericApiResponse<>("success" , message , data);
    }

    public static <T> GenericApiResponse<T> successMessage(String message) {
        return new GenericApiResponse<>("success" , message , null);
    }
}
