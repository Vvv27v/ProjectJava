package monpackage;

public class Reservation {

    private int numeroReservation;
    private Vol vol;
    private Passager passager;
    private String dateReservation;
    private String statut;

    public Reservation(int numeroReservation, Vol vol, Passager passager) {
        this.numeroReservation = numeroReservation;
        this.vol = vol;
        this.passager = passager;
        this.dateReservation = "2025-01-01";
        this.statut = "Confirmee";
    }

    public int getNumeroReservation() { return numeroReservation; }
    public Vol getVol() { return vol; }
    public Passager getPassager() { return passager; }
    public String getStatut() { return statut; }

    public void confirmerReservation() {
        this.statut = "Confirmee";
        System.out.println("Reservation " + numeroReservation + " confirmee.");
    }

    public void annulerReservation() {
        this.statut = "Annulee";
        System.out.println("Reservation " + numeroReservation + " annulee.");
    }

    public void modifierReservation(Vol nouveauVol) {
        this.vol = nouveauVol;
        System.out.println("Reservation " + numeroReservation + " modifiee.");
    }

    public void obtenirInfos() {
        System.out.println("Reservation " + numeroReservation);
        System.out.println("Vol : " + vol.getNumeroVol());
        System.out.println("Passager : " + passager.getNom());
        System.out.println("Date : " + dateReservation);
        System.out.println("Statut : " + statut);
    }
}
