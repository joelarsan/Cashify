package com.ken.cashify.repository

import com.ken.cashify.data.TransactionDao
import com.ken.cashify.model.Transaction
import kotlinx.coroutines.flow.Flow

class TransactionRepository(private val dao: TransactionDao) {
    val transactions: Flow<List<Transaction>> = dao.getAllTransactions()

    suspend fun insert(transaction: Transaction) {
        dao.insertTransaction(transaction)
    }

    suspend fun delete(transaction: Transaction) {
        dao.deleteTransaction(transaction)
    }
}
