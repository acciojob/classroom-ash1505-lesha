package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class repository {
    public int rollNo;
    public int teacherId;
    public repository(){
        rollNo=1;
        teacherId=1;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public HashMap<String,Student> studentDB=new HashMap<>();
    public HashMap<String,Teacher> teacherDB=new HashMap<>();

    public HashMap<String, List<String>> StudentTeacherAssociationDB=new HashMap<>();

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

}
