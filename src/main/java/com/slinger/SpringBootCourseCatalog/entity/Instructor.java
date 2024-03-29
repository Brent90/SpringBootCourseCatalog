package com.slinger.SpringBootCourseCatalog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "department")
    private String department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    @OneToMany(mappedBy="instructor",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course> courses;


//    @ManyToMany(
//            fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//    @JoinTable(
//            name = "course_instructor",
//            joinColumns = @JoinColumn(name="instructor_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_join_id")
//    )
//    private List<Course> courses;


    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public InstructorDetail getInstructorDetail() {
        if(instructorDetail == null) {
            return new InstructorDetail();
        }
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void addCourse(Course course) {
        if(this.courses == null) {
            this.courses = new ArrayList<>();
        }
        this.courses.add(course);
    }


    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getFullName() {
        if(firstName == null && lastName == null || firstName.isEmpty() && lastName.isEmpty()) {
            return "No Instructor Set";
        }

        return this.firstName +  " " + this.lastName;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", instructorDetail=" + instructorDetail +
                ", courses=" +
                '}';
    }
}
