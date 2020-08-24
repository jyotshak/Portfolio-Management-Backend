package com.dao;

import java.util.List;

import com.pojo.Security;
import com.pojo.Transaction;

public interface TransactionDAO {
	public List<Transaction> getTransactionByCustomerId(int customerId);
	public Transaction updateTransaction(String transactionid,Transaction newtransaction);
	public Transaction deleteTransaction(String transactionid);
	public Transaction addTransaction(Transaction transaction);
	public Transaction getTransactionByTransactionId(String transactionid);
}
