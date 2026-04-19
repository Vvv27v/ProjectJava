package monpackage;

public class Avion {

    private String immatriculation;
    private String modele;
    private int capacite;
    private boolean disponible;

    public Avion(String immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
        this.disponible = true;
    }

    public String getImmatriculation() { return immatriculation; }
    public String getModele() { return modele; }
    public int getCapacite() { return capacite; }
    public boolean isDisponible() { return disponible; }

    public boolean verifierDisponibilite() { return disponible; }

    public void affecterVol(Vol vol) {
        if (!disponible) {
            System.out.println("Avion " + immatriculation + " non disponible.");
            return;
        }
        disponible = false;
        System.out.println("Avion " + immatriculation + " affecte au vol " + vol.getNumeroVol());
    }

    public void liberer() {
        disponible = true;
        System.out.println("Avion " + immatriculation + " libere.");
    }

    public void obtenirInfos() {
        System.out.println("Immatriculation : " + immatriculation);
        System.out.println("Modele : " + modele);
        System.out.println("Capacite : " + capacite);
        System.out.println("Disponible : " + disponible);
    }
}
