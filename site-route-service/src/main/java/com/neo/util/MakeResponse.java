package com.neo.util;


import com.neo.entity.ResponseMessage;

public interface MakeResponse {
    ResponseMessage success();
    ResponseMessage error(int code, String message);
}