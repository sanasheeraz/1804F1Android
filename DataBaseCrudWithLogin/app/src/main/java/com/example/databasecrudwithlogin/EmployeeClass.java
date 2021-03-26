package com.example.databasecrudwithlogin;

public class EmployeeClass {
    public int id;
    public String name;
    public String email;
    public String password;
    public byte[] img;
    public String dept;

    public EmployeeClass(int id, String name, String email, String password, byte[] img, String dept) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.img = img;
        this.dept = dept;
    }


}
