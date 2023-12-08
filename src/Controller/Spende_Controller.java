package Controller;
import Domain.Spende;
import DAO.Repo_DAO;
public class Spende_Controller extends Controller<Spende> {
    public Spende_Controller(Repo_DAO<Spende> repository) {
        super(repository);
    }
}