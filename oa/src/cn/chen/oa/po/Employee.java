package cn.chen.oa.po;

/**
 * @author BOBO
 * @version 2018年11月14日 下午9:19:55
 */
public class Employee {
	private Employee employee_id;
	private String employee_name;
	private String password;
	private Integer department_id;

	public Employee getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Employee employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", password=" + password
				+ ", department_id=" + department_id + "]";
	}

}
