package org.evobyte.fullstackproject.subject;
import jakarta.persistence.*;
import org.evobyte.fullstackproject.student.Student;
import java.util.List;

@Entity
@Table
public class Subject {

    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )
    private Long id;
    private String name;
    private String teacherName;
    private Long credits;
    private String examType;
    private List<Student> listOfStudents;

    public Subject() {
    }

    public Subject(Long id, String name, String teacherName, Long credits, String examType, List<Student> listOfStudents) {
        this.id = id;
        this.name = name;
        this.teacherName = teacherName;
        this.credits = credits;
        this.examType = examType;
        this.listOfStudents = listOfStudents;
    }

    public Subject(String name, String teacherName, Long credits, String examType, List<Student> listOfStudents) {
        this.name = name;
        this.teacherName = teacherName;
        this.credits = credits;
        this.examType = examType;
        this.listOfStudents = listOfStudents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Long getCredits() {
        return credits;
    }

    public void setCredits(Long credits) {
        this.credits = credits;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", credits=" + credits +
                ", examType='" + examType + '\'' +
                ", listOfStudents=" + listOfStudents +
                '}';
    }
}
