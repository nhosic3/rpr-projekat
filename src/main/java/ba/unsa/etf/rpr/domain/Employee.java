package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Employee data
 */

public class Employee implements Idable {
    private int ID;
    private String first_name, last_name;
    private Date brith_date;
    private Date hire_date;
    private int salary;
    private int service_id;

    public Employee(){

    }
    public Employee(int ID, String first_name, String last_name, Date brith_date, Date hire_date, int salary, int service_id) {
        this.ID = ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.brith_date = brith_date;
        this.hire_date = hire_date;
        this.salary = salary;
        this.service_id = service_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ID == employee.ID && salary == employee.salary && service_id == employee.service_id && Objects.equals(first_name, employee.first_name) && Objects.equals(last_name, employee.last_name) && Objects.equals(brith_date, employee.brith_date) && Objects.equals(hire_date, employee.hire_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, first_name, last_name, brith_date, hire_date, salary, service_id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + ID +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", brith_date=" + brith_date +
                ", hire_date=" + hire_date +
                ", salary=" + salary +
                ", service_id=" + service_id +
                '}';
    }
}
