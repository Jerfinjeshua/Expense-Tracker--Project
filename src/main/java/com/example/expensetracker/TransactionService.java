package com.example.expensetracker;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;
      
    public List<Transaction> getTransactionsByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }
    
    public Transaction addTransaction(Map<String, Object> transactionData) {
        try {
            // Cast userId to Long to match repository's findById method signature
            Long userId = ((Integer) ((Map<String, Object>) transactionData.get("user")).get("id")).longValue();
            String type = (String) transactionData.get("type");
            String category = (String) transactionData.get("category");
            Double amount = (Double) transactionData.get("amount");

            // Log extracted values
            System.out.println("User ID: " + userId);
            System.out.println("Type: " + type);
            System.out.println("Category: " + category);
            System.out.println("Amount: " + amount);

            if (amount == null) {
                throw new IllegalArgumentException("Amount cannot be null");
            }

            // Fetch the user entity
            User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

            // Create and save the transaction
            Transaction transaction = new Transaction();
            transaction.setUser(user);
            transaction.setType(type);
            transaction.setCategory(category);
            transaction.setAmount(amount);

            return transactionRepository.save(transaction);  // Return the saved transaction
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while adding transaction: " + e.getMessage());
        }
    }
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
