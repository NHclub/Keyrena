package com.nhclub.keyrena.domain.auth.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MsgDto {

    private String msg;
    private Object result;

    public MsgDto(String msg, Object result) {
        this.msg = msg;
        this.result  = result;
    }
}