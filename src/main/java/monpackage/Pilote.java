package monpackage;

public class Pilote extends Employe {

    private String licence;
    private int heuresDeVol;
    private Vol volAssigne;

    public Pilote(int identifiant, String nom, String adresse, String contact,
                  int numeroEmploye, String dateEmbauche, String licence, int heuresDeVol) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    public String getLicence() { return licence; }
    public int getHeuresDeVol() { return heuresDeVol; }
    public Vol getVolAssigne() { return volAssigne; }

    @Override
    public String obtenirRole() { return "Pilote"; }

    public void affecterVol(Vol vol) {
        this.volAssigne = vol;
        System.out.println("Pilote " + getNom() + " affecte au vol " + vol.getNumeroVol());
    }

    public Vol obtenirVol() { return volAssigne; }

    @Override
    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Licence : " + licence);
        System.out.println("Heures de vol : " + heuresDeVol);
    }
}
