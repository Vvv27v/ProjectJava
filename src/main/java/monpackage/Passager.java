package monpackage;

import java.util.ArrayList;
import java.util.Random;

public class Passager extends Personne {

    private String passeport;
    private ArrayList<Reservation> reservations;

    public Passager(int identifiant, String nom, String adresse, String contact, String passeport) {
        super(identifiant, nom, adresse, contact);
        this.passeport = passeport;
        this.reservations = new ArrayList<>();
    }

    public String getPasseport() { return passeport; }
    public ArrayList<Reservation> getReservations() { return reservations; }

    public Reservation reserverVol(Vol vol) {
        Reservation reservation = new Reservation(new Random().nextInt(10000), vol, this);
        reservations.add(reservation);
        vol.ajouterPassager(this);
        System.out.println("Reservation " + reservation.getNumeroReservation()
            + " creee pour " + getNom() + " sur le vol " + vol.getNumeroVol());
        return reservation;
    }

    public void annulerReservation(int numeroReservation) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getNumeroReservation() == numeroReservation) {
                reservations.get(i).annulerReservation();
                reservations.remove(i);
                return;
            }
        }
        System.out.println("Reservation " + numeroReservation + " introuvable.");
    }

    public void obtenirReservations(int numeroReservation) {
        for (Reservation r : reservations) {
            if (r.getNumeroReservation() == numeroReservation) {
                r.obtenirInfos();
                return;
            }
        }
        System.out.println("Reservation " + numeroReservation + " introuvable.");
    }

    @Override
    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Passeport : " + passeport);
        System.out.println("Nombre de reservations : " + reservations.size());
    }
}
