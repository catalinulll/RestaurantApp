package Controller;
import Domain.Kunden;
import DAO.Repo_DAO;

public class Kunden_Controller extends Controller<Kunden> {
    public Kunden_Controller(Repo_DAO<Kunden> repository) {
        super(repository);
    }
}