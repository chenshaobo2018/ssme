package cn.chen.oa.po;

/**
 * @author BOBO
 * @version 2018年11月14日 下午9:20:20
 */
public class Department {
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer department_parent_id;

	public Department() {
		super();
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}

	public Integer getDepartment_parent_id() {
		return department_parent_id;
	}

	public void setDepartment_parent_id(Integer department_parent_id) {
		this.department_parent_id = department_parent_id;
	}

	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name + ", manager_id="
				+ manager_id + ", department_parent_id=" + department_parent_id + "]";
	}
	
}
