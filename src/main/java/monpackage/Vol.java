package monpackage;

import java.util.ArrayList;

public class Vol {

    private int numeroVol;
    private String origine;
    private String destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat;
    private Avion avion;
    private Pilote pilote;
    private ArrayList<PersonnelCabine> equipeCabine;
    private ArrayList<Passager> passagers;

    public Vol(int numeroVol, String origine, String destination,
               String dateHeureDepart, String dateHeureArrivee) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = "Planifie";
        this.equipeCabine = new ArrayList<>();
        this.passagers = new ArrayList<>();
    }

    public int getNumeroVol() { return numeroVol; }
    public String getOrigine() { return origine; }
    public String getDestination() { return destination; }
    public String getDateHeureDepart() { return dateHeureDepart; }
    public String getDateHeureArrivee() { return dateHeureArrivee; }
    public String getEtat() { return etat; }
    public Avion getAvion() { return avion; }
    public Pilote getPilote() { return pilote; }
    public ArrayList<PersonnelCabine> getEquipeCabine() { return equipeCabine; }
    public ArrayList<Passager> getPassagers() { return passagers; }
    public void setEtat(String etat) { this.etat = etat; }
    public void setDateHeureDepart(String d) { this.dateHeureDepart = d; }
    public void setDateHeureArrivee(String d) { this.dateHeureArrivee = d; }

    public void ajouterPassager(Passager passager) { passagers.add(passager); }

    public void planifierVol() {
        this.etat = "Planifie";
        System.out.println("Vol " + numeroVol + " planifie : " + origine
            + " -> " + destination + " | Depart : " + dateHeureDepart);
    }

    public void affecterVol(Pilote pilote, ArrayList<PersonnelCabine> cabine, Avion avion) {
        if (!avion.verifierDisponibilite()) {
            System.out.println("Avion indisponible, affectation impossible.");
            return;
        }
        this.pilote = pilote;
        this.equipeCabine = cabine;
        this.avion = avion;
        pilote.affecterVol(this);
        for (PersonnelCabine pc : cabine) {
            pc.affecterVol(this);
        }
        avion.affecterVol(this);
    }

    public void annulerVol() {
        this.etat = "Annule";
        if (avion != null) avion.liberer();
        System.out.println("Vol " + numeroVol + " annule.");
    }

    public void modifierVol(String dateHeureDepart, String dateHeureArrivee) {
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        System.out.println("Vol " + numeroVol + " modifie.");
    }

    public void listingPassagers() {
        System.out.println("Passagers du vol " + numeroVol + " :");
        for (Passager p : passagers) {
            System.out.println("  " + p.getNom() + " (passeport : " + p.getPasseport() + ")");
        }
    }

    public void obtenirInfos() {
        System.out.println("Vol " + numeroVol + " : " + origine + " -> " + destination);
        System.out.println("Depart : " + dateHeureDepart + " | Arrivee : " + dateHeureArrivee);
        System.out.println("Etat : " + etat);
        if (avion != null) System.out.println("Avion : " + avion.getImmatriculation());
        if (pilote != null) System.out.println("Pilote : " + pilote.getNom());
        System.out.println("Nb passagers : " + passagers.size());
    }
}
