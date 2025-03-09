package com.zihenzzz.register.api.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String message;
    private Integer code;
    private Boolean success;
    private T data;
//TODO 可以使用枚举优化
    public static Result ok(){
       return new Result("操作成功",200,true,null);
    }
    public static <T>Result ok(T data){
        return new Result("操作成功",200,true,data);
    }
    public static Result fail(){
        return new Result("操作失败",500,false,null );
    }
    public static <T>Result fail(T data){
        return new Result("操作失败",500,false,data );
    }
}
