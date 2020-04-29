package co.edu.unal.software_engineering.labs.service;

import co.edu.unal.software_engineering.labs.model.Course;
import co.edu.unal.software_engineering.labs.repository.CourseRepository;
import org.springframework.stereotype.Service;


@Service
public class CourseService{

    private CourseRepository courseRepository;

    public CourseService( CourseRepository courseRepository ){
        this.courseRepository = courseRepository;
    }

    public Course findById( Integer id ){
        return courseRepository.findById( id ).orElse( null );
    }

    public void save( Course course ){
        courseRepository.save( course );
    }

    public boolean isRightCourse( Course course ){
        return course.getId( ) == null && !course.getCourseName( ).trim( ).isEmpty( ) &&
                course.getDurationHours( ) != null;
    }
}
