package org.evobyte.fullstackproject.subject;

import jakarta.transaction.Transactional;
import org.evobyte.fullstackproject.student.Student;
import org.evobyte.fullstackproject.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }
    public void addNewSubject(Subject subject){
        Optional<Subject> subjectOptional = subjectRepository.findSubjectByName(subject.getTeacherName());
        if (subjectOptional.isPresent()) {
            throw new IllegalStateException("This name is taken.");
        }
        subjectRepository.save(subject);
    }

    @Transactional
    public void updateSubject(Long subjectId, String name, String teacherName) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new IllegalStateException(
                "Subject with id " + subjectId + " does not exist."));
        if (name != null && name.length() > 0 && !Objects.equals(subject.getName(), name)) {
            subject.setName(name);
        }
        if (teacherName != null && teacherName.length() > 0 && !Objects.equals(subject.getTeacherName(), teacherName)) {
            Optional<Subject> subjectOptional = subjectRepository.findSubjectByName(teacherName);
            if (subjectOptional.isPresent()) {
                throw new IllegalStateException("This teacher name is taken.");
            }
            subject.setTeacherName(teacherName);
        }
    }


    public void deleteSubject(Long subjectId) {
        boolean exists = subjectRepository.existsById(subjectId);
        if (!exists) {
            throw new IllegalStateException("Subject with id " + subjectId + " does not exist");
        }
        subjectRepository.deleteById(subjectId);
    }
}