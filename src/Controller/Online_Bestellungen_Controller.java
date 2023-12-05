    package Controller;
    import Domain.Online_Bestellungen;
    import Repository.Repository;

    public class Online_Bestellungen_Controller extends Controller<Online_Bestellungen> {
        public Online_Bestellungen_Controller(Repository<Online_Bestellungen> repository) {
            super(repository);
        }
    }