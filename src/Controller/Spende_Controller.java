package Controller;
import Domain.Spende;
import Repository.Repository;
public class Spende_Controller extends Controller<Spende> {
    public Spende_Controller(Repository<Spende> repository) {
        super(repository);
    }
}