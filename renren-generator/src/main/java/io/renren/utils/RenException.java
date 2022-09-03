// powered by 天津理工大学心理辅导团队

package io.renren.utils;

/**
 * 自定义异常
 * 
 * @author Tjut team
 */
public class RenException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public RenException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public RenException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public RenException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public RenException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
