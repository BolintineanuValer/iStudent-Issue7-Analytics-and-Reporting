package ro.ubb.istudent.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.converters.CourseConverter;
import ro.ubb.istudent.dto.CourseDto;
import ro.ubb.istudent.repository.CourseRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CourseService {

    private CourseRepository repository;

    private CourseConverter courseConverter;

    public CourseDto save(CourseDto studentDto) {
        return courseConverter.createFromEntity(repository.save(courseConverter.createFromDto(studentDto)));
    }

    public Optional<CourseDto> findByCourseName(String name) {
        return repository.findByName(name)
                .map(courseConverter::createFromEntity);
    }

}
