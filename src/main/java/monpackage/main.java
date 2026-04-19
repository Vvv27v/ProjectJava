package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static HashMap<Integer, Wallet> wallets = new HashMap<>();

    public static void main(String[] args) {

        // 3.2 : Creation des portefeuilles
        wallets = creerPortefeuilles();
        System.out.println("=== Portefeuilles crees ===");
        for (Wallet w : wallets.values()) {
            System.out.println("  " + w);
        }

        // 3.3 : Premier bloc vide
        blockchain.add(new Block());

        // 3.3 : Simulation
        simulation();

        // 3.4 Q1 : 3 derniers blocs en ordre antéchronologique
        System.out.println("\n=== 3.4 Q1 : 3 derniers blocs ===");
        afficherDerniersBlocs(3);

        // 3.4 Q2 : Activite par utilisateur
        System.out.println("\n=== 3.4 Q2 : Activite par utilisateur ===");
        analyserActivite();
    }

    // 3.2 : Dictionnaire de 5 portefeuilles
    static HashMap<Integer, Wallet> creerPortefeuilles() {
        String[] noms = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        HashMap<Integer, Wallet> map = new HashMap<>();
        for (String nom : noms) {
            Wallet w = new Wallet(nom);
            w.setIsepCoins(10);
            map.put(w.getToken(), w);
        }
        return map;
    }

    // 3.3 : 55 transactions aleatoires
    static void simulation() {
        System.out.println("\n=== Simulation de 55 transactions ===");
        Random random = new Random();
        ArrayList<Wallet> liste = new ArrayList<>(wallets.values());
        Block blocCourant = blockchain.get(blockchain.size() - 1);

        for (int i = 0; i < 55; i++) {
            Wallet origin      = liste.get(random.nextInt(liste.size()));
            Wallet destination = liste.get(random.nextInt(liste.size()));
            int montant        = random.nextInt(5) + 1;

            Transaction transaction = new Transaction(origin, destination, montant);
            blocCourant = blocCourant.add(transaction);
        }
    }

    // 3.4 Q1 : Afficher les N derniers blocs en antéchronologique
    static void afficherDerniersBlocs(int n) {
        int debut = blockchain.size() - n;
        if (debut < 0) debut = 0;
        for (int i = blockchain.size() - 1; i >= debut; i--) {
            System.out.println("Bloc n°" + i + " :");
            System.out.println(blockchain.get(i));
        }
    }

    // 3.4 Q2 : Nombre de transactions et ISEP Coins par utilisateur
    static void analyserActivite() {
        ArrayList<String> noms          = new ArrayList<>();
        ArrayList<Integer> nbTransactions = new ArrayList<>();
        ArrayList<Integer> totalCoins    = new ArrayList<>();

        for (Block bloc : blockchain) {
            for (Transaction t : bloc.getTransactions()) {
                if (!t.isPayed()) continue;

                String nom = t.getOriginWallet().getOwner();

                // Chercher si le nom est deja dans la liste
                int index = -1;
                for (int i = 0; i < noms.size(); i++) {
                    if (noms.get(i).equals(nom)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    // Nouvel utilisateur
                    noms.add(nom);
                    nbTransactions.add(1);
                    totalCoins.add(t.getIsepCoins());
                } else {
                    // Utilisateur existant
                    nbTransactions.set(index, nbTransactions.get(index) + 1);
                    totalCoins.set(index, totalCoins.get(index) + t.getIsepCoins());
                }
            }
        }

        System.out.println("Activite par utilisateur :");
        for (int i = 0; i < noms.size(); i++) {
            System.out.println("  " + noms.get(i)
                + " : " + nbTransactions.get(i) + " transactions, "
                + totalCoins.get(i) + " ISEP Coins envoyes");
        }

        // Etudiant malveillant = premier portefeuille cree
        String malveillant = new ArrayList<>(wallets.values()).get(0).getOwner();
        System.out.println("\nEtudiant malveillant : " + malveillant);
        for (int i = 0; i < noms.size(); i++) {
            if (noms.get(i).equals(malveillant)) {
                System.out.println("  Transactions : " + nbTransactions.get(i));
                System.out.println("  ISEP Coins envoyes : " + totalCoins.get(i));
            }
        }
    }
}
