package Lab2_Project3MV;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

import Lab2_Project3MV.Exceptions.ValidatorException;
import Lab2_Project3MV.Repository.XMLFileRepository.TemaLabXMLRepo;
import Lab2_Project3MV.Service.XMLFileService.TemaLabXMLService;
import Lab2_Project3MV.Validator.TemaLabValidator;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private TemaLabValidator validator;
    private TemaLabXMLRepo xmlRepo;
    private TemaLabXMLService xmlService;

    @Before
    public void setUp(){
        validator = new TemaLabValidator();
        xmlRepo = new TemaLabXMLRepo(validator, "assign-test.xml");
        xmlService = new TemaLabXMLService(xmlRepo);
    }

    @Test
    public void addHomeworkValid() {
        String[] params={"asa", "Ana", "932", "Zsu"};
        try {
            xmlService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            TestCase.assertTrue(true);
        }
    }

    @Test
    public void addHomeworkInvalid() {
        String[] params={"asa", "Ana", "932", "Zsu"};
        try {
            xmlService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            TestCase.assertFalse(false);
        }
    }
}
