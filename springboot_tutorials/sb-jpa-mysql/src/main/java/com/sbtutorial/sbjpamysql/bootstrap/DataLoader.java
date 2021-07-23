package com.sbtutorial.sbjpamysql.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sbtutorial.sbjpamysql.model.Student;
import com.sbtutorial.sbjpamysql.repository.StudentRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
 
    private final StudentRepository repository;
     
     
    public DataLoader(StudentRepository repository) {
        this.repository = repository;
    }
 
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Student student_a = new Student();
        student_a.setFirstName("Anujay");
        student_a.setLastName("Ghosh");
        student_a.setYear("Junior");
        repository.save(student_a);
         
        Student student_b = new Student();
        student_b.setFirstName("Arpita");
        student_b.setLastName("Kumari");
        student_b.setYear("Senior");
        repository.save(student_b);
         
        Student student_c = new Student();
        student_c.setFirstName("Manisha");
        student_c.setLastName("Mahapatrao");
        student_c.setYear("Freshman");
        repository.save(student_c);
    }
}
