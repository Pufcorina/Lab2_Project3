package Lab2_Project3MV.Repository.MemoryRepository;
import Lab2_Project3MV.Validator.IValidator;
import Lab2_Project3MV.Domain.Student;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}