package monpackage;

public class PersonnelCabine extends Employe {

    private String qualification;
    private Vol volAssigne;

    public PersonnelCabine(int identifiant, String nom, String adresse, String contact,
                           int numeroEmploye, String dateEmbauche, String qualification) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    public String getQualification() { return qualification; }
    public Vol getVolAssigne() { return volAssigne; }

    @Override
    public String obtenirRole() { return "Personnel Cabine"; }

    public void affecterVol(Vol vol) {
        this.volAssigne = vol;
        System.out.println("Personnel cabine " + getNom() + " affecte au vol " + vol.getNumeroVol());
    }

    public Vol obtenirVol() { return volAssigne; }

    @Override
    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Qualification : " + qualification);
    }
}
