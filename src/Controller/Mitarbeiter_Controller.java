package Controller;
import Domain.Mitarbeiter;
import Repository.Repository;

public class Mitarbeiter_Controller extends Controller<Mitarbeiter> {
    public Mitarbeiter_Controller(Repository<Mitarbeiter> repository) {
        super(repository);
    }
}