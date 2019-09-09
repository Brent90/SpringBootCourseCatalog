package com.slinger.SpringBootCourseCatalog.pojos;

import java.util.ArrayList;
import java.util.List;

public class IDHolder {

    //this class holds the ids of a course and instructor so that the two can be linked
    //this is either clever or needs to be redone in a more spring way. come back to it later.

    private int courseId;

    private int instructorId;

    private List<Integer> idHolder;

    public IDHolder() {
            idHolder = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public List<Integer> getIdHolder() {
        return idHolder;
    }

    public void setIdHolder(List<Integer> idHolder) {
        this.idHolder = idHolder;
    }


}
