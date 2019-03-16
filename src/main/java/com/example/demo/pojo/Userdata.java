package com.example.demo.pojo;


public class Userdata {
    private String name;
    private String password;
    private String realName;

    private String birth;

    private String email;
    private String phone;
    private String address;
    private int postcode;

    @Override
    public String toString() {
        return "Userdata{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", postcode=" + postcode +
                '}';
    }

    public Userdata(String name, String password, String realName, String birth, String email, String phone, String address, int postcode) {
        this.name = name;
        this.password = password;
        this.realName = realName;
        this.birth = birth;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
