package Lab2_Project3MV.Repository.MemoryRepository;
import Lab2_Project3MV.Validator.IValidator;
import Lab2_Project3MV.Domain.Nota;

public class NotaRepo extends AbstractCrudRepo<Integer,Nota > {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}