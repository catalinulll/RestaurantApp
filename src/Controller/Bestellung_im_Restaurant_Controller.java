package Controller;
import Domain.Bestellung_im_Restaurant;
import DAO.Repo_DAO;

public class Bestellung_im_Restaurant_Controller extends Controller<Bestellung_im_Restaurant> {
    public Bestellung_im_Restaurant_Controller(Repo_DAO<Bestellung_im_Restaurant> repository) {
        super(repository);
    }
}