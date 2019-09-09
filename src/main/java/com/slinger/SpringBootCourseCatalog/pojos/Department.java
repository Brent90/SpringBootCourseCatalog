package com.slinger.SpringBootCourseCatalog.pojos;

public class Department {

    //this class is used for the drop down menu when searching by department


    private String department;

    public Department(String department) {
        this.department = department;
    }

    public Department() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
