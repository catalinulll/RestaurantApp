    package Controller;
    import Domain.Lebensmittel_im_Essen;
    import Repository.Repository;

    public class Lebensmittel_im_Essen_Controller extends Controller<Lebensmittel_im_Essen> {
        public Lebensmittel_im_Essen_Controller(Repository<Lebensmittel_im_Essen> repository) {
            super(repository);
        }
    }