package Controller;
import Domain.Gericht_im_Bestellung_im_Restaurant;
import Repository.Repository;

public class Gerichten_im_Bestellung_im_Restaurant_Controller extends Controller<Gericht_im_Bestellung_im_Restaurant> {
    public Gerichten_im_Bestellung_im_Restaurant_Controller(Repository<Gericht_im_Bestellung_im_Restaurant> repository) {
        super(repository);
    }
}