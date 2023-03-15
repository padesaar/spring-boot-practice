package com.sda.study.springbootpractice;

import com.sda.study.springbootpractice.models.School;
import com.sda.study.springbootpractice.repositories.SchoolRepository;
import com.sda.study.springbootpractice.services.CourseService;
import com.sda.study.springbootpractice.services.SchoolService;
import com.sda.study.springbootpractice.services.implementations.SchoolServiceImpl;

import org.apache.logging.log4j.message.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Mockito tests for SchoolService
 *
 */

@ExtendWith(MockitoExtension.class)
public class SchoolServiceTest {

    @InjectMocks
    private SchoolService schoolService = new SchoolServiceImpl();

    @Mock
    private SchoolRepository schoolRepository;

    @Mock
    private CourseService courseService;

    @Captor
    private ArgumentCaptor<Message> messageArgumentCaptor; //valikuline
    @Test
    public void whenFindAllSchoolCalled_shouldReturnSchoolList () {

        Mockito.verify(schoolService, times(8)).findAllSchools(); //don't have to use

        School school = new School();
        school.setId(1L);
        school.setName("Tartu University");
        school.setPhone("+2345432345");
        school.setAddress("Tartu");
        school.setActive(true);

        School school1 = new School();
        school1.setId(2L);
        school1.setName("Tallinn University");
        school1.setPhone("+234534245");
        school1.setAddress("Tallinn");
        school1.setActive(true);

        List<School> schoolList = Arrays.asList(school, school1);

        Mockito.when(schoolRepository.findAll())
                .thenReturn(schoolList);


        List<School> resultSchool = schoolService.findAllSchools();

        //Message capturedMessage = messageArgumentCaptor.capture();
       // Assertions.assertEquals("", capturedMessage.getFormattedMessage());

        Assertions.assertEquals(schoolList.size(), resultSchool.size());
        Assertions.assertEquals(schoolList.get(0).getName(), resultSchool.get(0).getName());

    }

}
