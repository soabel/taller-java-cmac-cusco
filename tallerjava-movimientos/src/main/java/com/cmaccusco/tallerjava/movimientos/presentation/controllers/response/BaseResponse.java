package com.cmaccusco.tallerjava.movimientos.presentation.controllers.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseResponse {
    private String message;
    private Object data;
}
