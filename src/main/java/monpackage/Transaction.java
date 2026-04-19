package org.example;

public class Transaction {

    private final Wallet originWallet;
    private final Wallet destinationWallet;
    private final int isepCoins;
    private boolean payed;

    public Transaction(Wallet originWallet, Wallet destinationWallet, int isepCoins) {
        this.originWallet = originWallet;
        this.destinationWallet = destinationWallet;
        this.isepCoins = isepCoins;
        this.payed = false;
    }

    public Wallet getOriginWallet() { return originWallet; }
    public Wallet getDestinationWallet() { return destinationWallet; }
    public int getIsepCoins() { return isepCoins; }
    public boolean isPayed() { return payed; }

    public void pay() {
        // Refus si meme portefeuille
        if (originWallet.getToken() == destinationWallet.getToken()) {
            System.out.println("Transaction refusee : meme portefeuille");
            return;
        }
        // Refus si solde insuffisant
        if (originWallet.getIsepCoins() - isepCoins < 0) {
            System.out.println("Transaction refusee : solde insuffisant pour " + originWallet.getOwner());
            return;
        }
        originWallet.setIsepCoins(originWallet.getIsepCoins() - isepCoins);
        destinationWallet.setIsepCoins(destinationWallet.getIsepCoins() + isepCoins);
        this.payed = true;
    }

    @Override
    public String toString() {
        return originWallet.getOwner() + " -> " + destinationWallet.getOwner()
               + " : " + isepCoins + " ISEP Coins"
               + " [" + (payed ? "OK" : "En attente") + "]";
    }
}
