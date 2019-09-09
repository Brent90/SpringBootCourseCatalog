package com.slinger.SpringBootCourseCatalog.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "position")
    private String position;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = " location")
    private String location;

    @Column(name = "bio")
    private String bio;

    public InstructorDetail() {
    }

    public InstructorDetail(String position, String phone, String email, String location, String bio) {
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPosition() {
        if(position == null) {
            System.out.println("true");
            return "position is currently not set";
        }

        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        if(phone == null) {
            System.out.println("true");
            return "phone is currently not set";
        }


        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        if(email == null) {
            System.out.println("true");
            return "email is currently not set";
        }

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        if(location == null) {
            System.out.println("true");
            return "location is currently not set";
        }

        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        if(bio == null) {
            System.out.println("true");
            return "bio is currently not set";
        }

        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
