package Controller;
import Domain.Tische;
import DAO.Repo_DAO;

public class Tische_Controller extends Controller<Tische> {
    public Tische_Controller(Repo_DAO<Tische> repository) {
        super(repository);
    }
}