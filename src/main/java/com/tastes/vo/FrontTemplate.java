package com.tastes.vo;

import lombok.Data;

import java.util.List;

@Data
public class FrontTemplate<T> {
    private Integer code;

    private String msg;

    private T data;
}
