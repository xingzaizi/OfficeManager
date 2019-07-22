package org.accp.office.util;

import java.util.HashMap;
import java.util.Map;

public class MsgUtil {
	private Integer code;//状态码
	private String info;//提示信息
	private Map<String,Object> data;
	private String path;//成功之后将要跳转的页面

	public MsgUtil(Integer code, String info, String path) {
		this.code = code;
		this.info = info;
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @return the data
	 */
	public Map<String, Object> getData() {
		return data;
	}

	/**
	 *
	 */
	public void setData(String key,Object value) {
		if (this.data==null){
			this.data=new HashMap<String, Object>();
		}
		this.data.put(key,value);
	}



	public MsgUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public MsgUtil(Integer code, String msg) {
		this.code = code;
		this.info = msg;
	}
	
	@Override
	public String toString() {
		return "{\"code\":\"" + code + "\", \"info\":\"" + info + "\", \"data\":\"" + data + "\"}";
	}
	
	public static MsgUtil success() {
		return new MsgUtil(200,"处理成功！");
	}

	public static MsgUtil success(String path) {return new MsgUtil(200,"处理成功！",path); }
	
	public static MsgUtil fail() {
		return new MsgUtil(500,"出现错误！");
	}

	public static MsgUtil fail(String path) {
		return new MsgUtil(500,"出现错误！",path);
	}
	
	public static MsgUtil custom(Integer code,String info) {
		return new MsgUtil(code,info);
	}

	public static MsgUtil custom(Integer code,String info,String path) {
		return new MsgUtil(code,info,path);
	}
	
	public void add(Map<String,Object> data) {
		this.data=data;
	}
}
