package monpackage;

import java.util.ArrayList;

public class Main {

    // Listes globales (CRUD)
    static ArrayList<Vol> vols                 = new ArrayList<>();
    static ArrayList<Avion> avions             = new ArrayList<>();
    static ArrayList<Passager> passagers       = new ArrayList<>();
    static ArrayList<Employe> employes         = new ArrayList<>();
    static ArrayList<Aeroport> aeroports       = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();

    // CRUD Vols
    static void ajouterVol(Vol vol) {
        vols.add(vol);
        System.out.println("Vol " + vol.getNumeroVol() + " ajoute.");
    }

    static Vol chercherVol(int numeroVol) {
        for (Vol v : vols) {
            if (v.getNumeroVol() == numeroVol) return v;
        }
        System.out.println("Vol " + numeroVol + " introuvable.");
        return null;
    }

    static void supprimerVol(int numeroVol) {
        for (int i = 0; i < vols.size(); i++) {
            if (vols.get(i).getNumeroVol() == numeroVol) {
                vols.remove(i);
                System.out.println("Vol " + numeroVol + " supprime.");
                return;
            }
        }
        System.out.println("Vol " + numeroVol + " introuvable.");
    }

    // CRUD Passagers
    static void ajouterPassager(Passager passager) {
        passagers.add(passager);
        System.out.println("Passager " + passager.getNom() + " ajoute.");
    }

    static Passager chercherPassager(int identifiant) {
        for (Passager p : passagers) {
            if (p.getIdentifiant() == identifiant) return p;
        }
        System.out.println("Passager " + identifiant + " introuvable.");
        return null;
    }

    static void supprimerPassager(int identifiant) {
        for (int i = 0; i < passagers.size(); i++) {
            if (passagers.get(i).getIdentifiant() == identifiant) {
                passagers.remove(i);
                System.out.println("Passager " + identifiant + " supprime.");
                return;
            }
        }
        System.out.println("Passager " + identifiant + " introuvable.");
    }

    // CRUD Avions
    static void ajouterAvion(Avion avion) {
        avions.add(avion);
        System.out.println("Avion " + avion.getImmatriculation() + " ajoute.");
    }

    static Avion chercherAvion(String immatriculation) {
        for (Avion a : avions) {
            if (a.getImmatriculation().equals(immatriculation)) return a;
        }
        System.out.println("Avion " + immatriculation + " introuvable.");
        return null;
    }

    static void supprimerAvion(String immatriculation) {
        for (int i = 0; i < avions.size(); i++) {
            if (avions.get(i).getImmatriculation().equals(immatriculation)) {
                avions.remove(i);
                System.out.println("Avion " + immatriculation + " supprime.");
                return;
            }
        }
        System.out.println("Avion " + immatriculation + " introuvable.");
    }

    // CRUD Employes
    static void ajouterEmploye(Employe employe) {
        employes.add(employe);
        System.out.println("Employe " + employe.getNom() + " ajoute.");
    }

    static Employe chercherEmploye(int numeroEmploye) {
        for (Employe e : employes) {
            if (e.getNumeroEmploye() == numeroEmploye) return e;
        }
        System.out.println("Employe " + numeroEmploye + " introuvable.");
        return null;
    }

    static void supprimerEmploye(int numeroEmploye) {
        for (int i = 0; i < employes.size(); i++) {
            if (employes.get(i).getNumeroEmploye() == numeroEmploye) {
                employes.remove(i);
                System.out.println("Employe " + numeroEmploye + " supprime.");
                return;
            }
        }
        System.out.println("Employe " + numeroEmploye + " introuvable.");
    }

    // ===============================
    // MAIN
    // ===============================

    public static void main(String[] args) {

        System.out.println("=== Compagnie aerienne ISEP Air ===\n");

        // Aeroports
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aeroport Charles de Gaulle");
        Aeroport jfk = new Aeroport("JFK", "New York", "John F. Kennedy International");
        aeroports.add(cdg);
        aeroports.add(jfk);

        // Avions
        Avion a1 = new Avion("F-GKXA", "Airbus A320", 180);
        Avion a2 = new Avion("F-GKXB", "Boeing 777", 350);
        ajouterAvion(a1);
        ajouterAvion(a2);

        // Employes
        Pilote pilote1 = new Pilote(1, "Jean Dupont", "Paris", "0601020304",
                                    101, "2010-03-15", "ATP-001", 5000);
        PersonnelCabine cabine1 = new PersonnelCabine(2, "Marie Martin", "Lyon", "0607080910",
                                                      102, "2015-06-01", "Steward Senior");
        PersonnelCabine cabine2 = new PersonnelCabine(3, "Lucas Bernard", "Marseille", "0611121314",
                                                      103, "2018-09-10", "Hotesse");
        ajouterEmploye(pilote1);
        ajouterEmploye(cabine1);
        ajouterEmploye(cabine2);

        // Passagers
        Passager p1 = new Passager(4, "Alice Durand", "Bordeaux", "0620212223", "PP123456");
        Passager p2 = new Passager(5, "Bob Leroy", "Toulouse", "0624252627", "PP789012");
        ajouterPassager(p1);
        ajouterPassager(p2);

        // Planification vol
        System.out.println("\n=== Planification du vol ===");
        Vol vol1 = new Vol(1001, "Paris CDG", "New York JFK", "2025-06-01 10:00", "2025-06-01 13:00");
        ajouterVol(vol1);
        vol1.planifierVol();
        cdg.affecterVol(vol1);
        jfk.affecterVol(vol1);

        // Affectation equipage
        System.out.println("\n=== Affectation equipage ===");
        ArrayList<PersonnelCabine> equipeCabine = new ArrayList<>();
        equipeCabine.add(cabine1);
        equipeCabine.add(cabine2);
        vol1.affecterVol(pilote1, equipeCabine, a1);

        // Reservations
        System.out.println("\n=== Reservations ===");
        Reservation r1 = p1.reserverVol(vol1);
        Reservation r2 = p2.reserverVol(vol1);
        reservations.add(r1);
        reservations.add(r2);

        // Infos vol
        System.out.println("\n=== Infos vol ===");
        vol1.obtenirInfos();

        // Listing passagers
        System.out.println("\n=== Listing passagers ===");
        vol1.listingPassagers();

        // Annulation reservation
        System.out.println("\n=== Annulation reservation ===");
        p1.annulerReservation(r1.getNumeroReservation());

        // Infos passager
        System.out.println("\n=== Infos passager ===");
        p2.obtenirInfos();

        // Infos pilote
        System.out.println("\n=== Infos pilote ===");
        pilote1.obtenirInfos();

        // Annulation vol
        System.out.println("\n=== Annulation vol ===");
        vol1.annulerVol();
    }
}
