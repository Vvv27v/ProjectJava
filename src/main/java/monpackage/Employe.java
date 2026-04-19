package monpackage;

public class Employe extends Personne {

    private int numeroEmploye;
    private String dateEmbauche;

    public Employe(int identifiant, String nom, String adresse, String contact,
                   int numeroEmploye, String dateEmbauche) {
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }

    public int getNumeroEmploye() { return numeroEmploye; }
    public String getDateEmbauche() { return dateEmbauche; }

    public String obtenirRole() { return "Employe"; }

    @Override
    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Numero employe : " + numeroEmploye);
        System.out.println("Date embauche : " + dateEmbauche);
        System.out.println("Role : " + obtenirRole());
    }
}
