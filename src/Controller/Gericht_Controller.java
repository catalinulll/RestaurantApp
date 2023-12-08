package Controller;
import Domain.Gericht;
import DAO.Repo_DAO;

public class Gericht_Controller extends Controller<Gericht> {
    public Gericht_Controller(Repo_DAO<Gericht> repository) {
        super(repository);
    }
}