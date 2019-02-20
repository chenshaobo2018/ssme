package cn.chen.oa.utils;

/**
 * @author BOBO
 * @version 2018年11月14日 下午10:05:31
 */
public class AjaxResult {
	private Boolean success = true;
	private String message = "操作成功！";

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AjaxResult() {
		super();
	}

	public AjaxResult(Exception e) {
		super();
		this.success = false;
		this.message = e.getMessage();
	}

	public AjaxResult(String message) {
		super();
		this.success = false;
		this.message = message;
	}
}
