package org.accp.office.util;

import java.util.*;

public class Msg {
	private Integer code;//状态码
	private String msg;//提示信息
	
	private Object data;

	public Msg(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}	
	
	
	
	@Override
	public String toString() {
		return "{\"code\":\"" + code + "\", \"msg\":\"" + msg + "\", \"data\":  "+this.data+"}";
	}



	public static Msg succeed() {
		return new Msg(200,"处理成功！");
	}
	
	public static Msg failed() {
		return new Msg(500,"出现错误！");
	}
	
	public static Msg custom(Integer code,String msg) {
		return new Msg(code,msg);
	}
	
	public Msg add(Object data) {
		this.data=data;
		return this;
	}


	public Integer getCode() {
		return code;
	}
	


	public String getMsg() {
		return msg;
	}



	public Object getData() {
		return data;
	}
	
}
