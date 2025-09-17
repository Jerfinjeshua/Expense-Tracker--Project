package com.example.expensetracker;

import com.example.expensetracker.Transaction;
import com.example.expensetracker.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{userId}")
    public List<Transaction> getTransactionsByUserId(@PathVariable Long userId) {
        return transactionService.getTransactionsByUserId(userId);
    }
    @PostMapping
    public String addTransaction(@RequestBody Map<String, Object> transactionData) {

         transactionService.addTransaction(transactionData);  // Pass Map to service
         return "Created Succesfully";
    }

    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "Deleted Succesfully";
    }
}
