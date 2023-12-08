package Controller;
import Domain.Gericht_im_Bestellung_im_Restaurant;
import DAO.Repo_DAO;

public class Gericht_im_Bestellung_im_Restaurant_Controller extends Controller<Gericht_im_Bestellung_im_Restaurant> {
    public Gericht_im_Bestellung_im_Restaurant_Controller(Repo_DAO<Gericht_im_Bestellung_im_Restaurant> repository) {
        super(repository);
    }
}