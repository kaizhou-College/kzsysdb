package com.kz.kzsys.core.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.io.Serializable;

/**
 * @Title: ServerResponse.java 
 * @Package com.kz.core.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 凯舟.陈超  
 * @date 2017年12月29日 上午10:45:57 
 * @version V1.0
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class ServerResponse<T> implements Serializable {

    private int code;
    private String msg;
    private int  count;
    private int pageNum;
    private int pageSize;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
    private T data;

    private ServerResponse(int code){
        this.code = code;
    }
    private ServerResponse(int code,T data){
        this.code = code;
        this.data = data;
    }

    private ServerResponse(int code,String msg,T data,int pageNum,int pageSize,int count){
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count =count;
    }

    private ServerResponse(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

   /* @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.code == ResponseCode.SUCCESS.getCode();
    }*/
    @JsonIgnore
    //使之不在json序列化结果当中
    public int getcode() {
		return code;
	}
	public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }


    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg,T data,int pageNum,int pageSize,int count){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data,pageNum,pageSize,count);
    }


    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }


    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }
}
