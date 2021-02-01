
public class Employee {
    public String employeeCode;
    public String NRIC;
    public String phone;

    public Employee(String employeeCode, String NRIC, String phone){
        this.employeeCode = employeeCode;
        this.NRIC = NRIC;
        this.phone = phone;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getNRIC() {
        return NRIC;
    }

    public void setNRIC(String NRIC) {
        this.NRIC = NRIC;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
