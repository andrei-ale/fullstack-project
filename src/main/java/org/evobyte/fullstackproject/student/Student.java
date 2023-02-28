package org.evobyte.fullstackproject.student;

import jakarta.persistence.*;
import org.evobyte.fullstackproject.subject.Subject;

import java.util.List;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String name;
    private String cnp;
    private String email;
    private String dateOfBirth;
    private String placeOfBirth;


    public Student() {
    }

    public Student(Long id, String name, String cnp, String email, String dateOfBirth, String placeOfBirth,
                   List<Subject> listOfSubjects) {
        this(name, cnp, email, dateOfBirth, placeOfBirth, listOfSubjects);
        this.id = id;

    }

    public Student(String name, String cnp, String email, String dateOfBirth, String placeOfBirth, List<Subject> listOfSubjects) {
        this.name = name;
        this.cnp = cnp;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cnp='" + cnp + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                '}';
    }
}
