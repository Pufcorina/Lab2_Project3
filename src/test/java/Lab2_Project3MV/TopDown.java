package Lab2_Project3MV;

import Lab2_Project3MV.Exceptions.ValidatorException;
import Lab2_Project3MV.Repository.XMLFileRepository.NotaXMLRepo;
import Lab2_Project3MV.Repository.XMLFileRepository.StudentXMLRepo;
import Lab2_Project3MV.Repository.XMLFileRepository.TemaLabXMLRepo;
import Lab2_Project3MV.Service.XMLFileService.NotaXMLService;
import Lab2_Project3MV.Service.XMLFileService.StudentXMLService;
import Lab2_Project3MV.Service.XMLFileService.TemaLabXMLService;
import Lab2_Project3MV.Validator.NotaValidator;
import Lab2_Project3MV.Validator.StudentValidator;
import Lab2_Project3MV.Validator.TemaLabValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;

public class TopDown {
    private TemaLabXMLService xmlService;
    private StudentXMLService studentXMLService;
    private NotaXMLService gradeXMLService;

    @Before
    public void setUp(){
        TemaLabValidator validator = new TemaLabValidator();
        TemaLabXMLRepo xmlRepo = new TemaLabXMLRepo(validator, "assign-test.xml");
        xmlService = new TemaLabXMLService(xmlRepo);

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo studentXMLRepo = new StudentXMLRepo(studentValidator, "StudentiXML_test.xml");
        studentXMLService = new StudentXMLService(studentXMLRepo);

        NotaValidator gradeValidator = new NotaValidator();
        NotaXMLRepo gradeXMLRepo = new NotaXMLRepo(gradeValidator, "gradeiXML_test.xml");
        gradeXMLService = new NotaXMLService(gradeXMLRepo);
    }

    @Test
    public void studentAssignment(){
        try{
            test_addStudent();
            test_addHomework();
        }catch (Error e){
            Assert.fail();
        }
    }

    @Test
    public void studentAssignmentGrade(){
        try{
            test_addStudent();
            test_addHomework();
            test_addGrade();
        }catch (Error e){
            Assert.fail();
        }
    }



    @Test
    public void test_addHomework() {
        String[] params={"123", "Ana", "14", "12"};
        try {
            xmlService.add(params);
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void test_addStudent() {
        String[] params={"2234", "Todoran Ana-Corina", "932", "asan@gmail.com", "Zsu"};
        try {
            studentXMLService.add(params);
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }


    @Test
    public void test_addGrade() {
        String[] params={"2234", "2234", "123", "9.5", LocalDateTime.now().toString()};
        try {
            gradeXMLService.add(params);
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }
}
