package org.evobyte.fullstackproject.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getSubjects() {
        return subjectService.getSubjects();
    }

    @PostMapping
    public void addNewSubject (@RequestBody Subject subject){
        subjectService.addNewSubject(subject);
    }

    @PutMapping(path = "{subjectId}")
    public void updateSubject(
            @PathVariable ("subjectId") Long subjectId,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String credits) {
        subjectService.updateSubject(subjectId, name, credits);
    }

    @DeleteMapping(path = "{subjectId}")
    public void deleteSubject(@PathVariable("subjectId") Long subjectId) {
        subjectService.deleteSubject(subjectId);
    }
}


