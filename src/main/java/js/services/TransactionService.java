package js.services;

import js.model.Transaction;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionService {

    List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public List<Transaction> findAll() {
        return transactions;
    }

    public Transaction create(Integer amount, Timestamp date, String references) {

        Transaction currentTransaction = new Transaction(amount, date, references);

        transactions.add(currentTransaction);

        return currentTransaction;
    }
}
