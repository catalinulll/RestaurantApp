package Controller;
import Domain.Mitarbeiter;
import DAO.Repo_DAO;

public class Mitarbeiter_Controller extends Controller<Mitarbeiter> {
    public Mitarbeiter_Controller(Repo_DAO<Mitarbeiter> repository) {
        super(repository);
    }
}