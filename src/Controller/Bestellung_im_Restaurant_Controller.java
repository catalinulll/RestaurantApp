package Controller;
import Domain.Bestellung_im_Restaurant;
import Repository.Repository;

public class Bestellung_im_Restaurant_Controller extends Controller<Bestellung_im_Restaurant> {
    public Bestellung_im_Restaurant_Controller(Repository<Bestellung_im_Restaurant> repository) {
        super(repository);
    }
}