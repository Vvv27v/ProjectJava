package org.example;

import java.util.ArrayDeque;

public class Block {

    private final ArrayDeque<Transaction> transactions;

    public Block() {
        this.transactions = new ArrayDeque<>();
    }

    public ArrayDeque<Transaction> getTransactions() { return transactions; }

    public Block add(Transaction transaction) {
        transactions.add(transaction);

        if (transactions.size() == 10) {
            System.out.println("\n=== Bloc plein - Traitement des transactions ===");
            for (Transaction t : transactions) {
                t.pay();
                System.out.println("  " + t);
            }
            Block newBlock = new Block();
            Main.blockchain.add(newBlock);
            System.out.println("Nouveau bloc cree. Total blocs : " + Main.blockchain.size());
            return newBlock;
        }
        return this;
    }

    @Override
    public String toString() {
        String result = "Bloc (" + transactions.size() + " transactions) :\n";
        for (Transaction t : transactions) {
            result += "  " + t + "\n";
        }
        return result;
    }
}
