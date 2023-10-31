package Controller;
import Domain.Bestellungen_im_Restaurant;
import Repository.Repository;

public class Bestellungen_im_Restaurant_Controller extends Controller<Bestellungen_im_Restaurant> {
    public Bestellungen_im_Restaurant_Controller(Repository<Bestellungen_im_Restaurant> repository) {
        super(repository);
    }
}
