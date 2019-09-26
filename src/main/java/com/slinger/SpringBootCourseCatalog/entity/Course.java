package com.slinger.SpringBootCourseCatalog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "course_id")
    private String CourseId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "credit_hours")
    private String creditHours;

    @Column(name = "department")
    private String department;


    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    private Instructor instructor;




//    @ManyToMany(
//            fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//    @JoinTable(
//            name = "course_instructor",
//            joinColumns = @JoinColumn(name="course_join_id"),
//            inverseJoinColumns = @JoinColumn(name = "instructor_id")
//    )
//    private List<Instructor> instructors;



    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;




    public Course() {
    }

    public Course(String courseId, String title, String description, String creditHours, String department) {
        CourseId = courseId;
        this.title = title;
        this.description = description;
        this.creditHours = creditHours;
        this.department = department;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(String creditHours) {
        this.creditHours = creditHours;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


//    public List<Instructor> getInstructors() {
//        return instructors;
//    }
//
//    public void setInstructors(List<Instructor> instructors) {
//        this.instructors = instructors;
//    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        if(students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }


//    public List<String> getInstructorName() {
//        List<String> instructorNames = new ArrayList<>();
//
//        for(Instructor in : instructors) {
//            instructorNames.add(in.getFullName());
//        }
//        return instructorNames;
//    }
//
//    public void addInstructor(Instructor instructor) {
//        if(instructors == null) {
//            instructors = new ArrayList<>();
//        }
//        instructors.add(instructor);
//    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", CourseId='" + CourseId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creditHours='" + creditHours + '\'' +
                ", department='" + department + '\'' +
                ", instructor=" + instructor +
                ", students=" + students +
                '}';
    }
}
