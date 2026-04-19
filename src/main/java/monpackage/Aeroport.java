package monpackage;

import java.util.ArrayList;

public class Aeroport {

    private String nom;
    private String ville;
    private String description;
    private ArrayList<Vol> vols;

    public Aeroport(String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
        this.vols = new ArrayList<>();
    }

    public String getNom() { return nom; }
    public String getVille() { return ville; }
    public String getDescription() { return description; }
    public ArrayList<Vol> getVols() { return vols; }

    public void affecterVol(Vol vol) {
        vols.add(vol);
        System.out.println("Vol " + vol.getNumeroVol() + " affecte a l'aeroport " + nom);
    }

    public void obtenirInfos() {
        System.out.println("Aeroport : " + nom + " | Ville : " + ville);
        System.out.println("Description : " + description);
        System.out.println("Nombre de vols : " + vols.size());
    }
}
