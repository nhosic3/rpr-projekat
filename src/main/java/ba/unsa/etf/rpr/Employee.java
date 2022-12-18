package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.Objects;

public class Employee {
    private String employee_id;
    private String first_name, last_name;
    private Date brith_date, hire_date;
    private int salary;
    private String service_id;

    public Employee(String employee_id, String first_name, String last_name, Date brith_date, Date hire_date, int salary, String service_id) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.brith_date = brith_date;
        this.hire_date = hire_date;
        this.salary = salary;
        this.service_id = service_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBrith_date() {
        return brith_date;
    }

    public void setBrith_date(Date brith_date) {
        this.brith_date = brith_date;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(employee_id, employee.employee_id) && Objects.equals(first_name, employee.first_name) && Objects.equals(last_name, employee.last_name) && Objects.equals(brith_date, employee.brith_date) && Objects.equals(hire_date, employee.hire_date) && Objects.equals(service_id, employee.service_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, first_name, last_name, brith_date, hire_date, salary, service_id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id='" + employee_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", brith_date=" + brith_date +
                ", hire_date=" + hire_date +
                ", salary=" + salary +
                ", service_id='" + service_id + '\'' +
                '}';
    }
}
