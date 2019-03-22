package Lab2_Project3MV.Service.TxtFileService;
import Lab2_Project3MV.Domain.*;
import Lab2_Project3MV.Repository.TxtFileRepository.StudentFileRepo;

public class StudentService extends AbstractService<String,Student> {
    //StudentFileRepo stdRepo;
    public StudentService(StudentFileRepo stdRepo){
        super(stdRepo);
    }
    /*
    @Override
    public Student extractEntity(String[] info){
        return new Student("","",2,"","");
    }
    */
}


