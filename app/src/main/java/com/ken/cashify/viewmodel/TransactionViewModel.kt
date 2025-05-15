package com.ken.cashify.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ken.cashify.data.TransactionDatabase
import com.ken.cashify.model.Transaction
import com.ken.cashify.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TransactionViewModel(application: Application) : AndroidViewModel(application) {

    private val db = TransactionDatabase.getDatabase(application)
    private val repo = TransactionRepository(dao = db.transactionDao())

    val transactions: Flow<List<Transaction>> = repo.transactions

    fun addTransaction(description: String, amount: Double) {
        viewModelScope.launch {
            val transaction = Transaction(description = description, amount = amount)
            repo.insert(transaction)
        }
    }

    fun deleteTransaction(transaction: Transaction) {
        viewModelScope.launch {
            repo.delete(transaction)
        }
    }
}




class TransactionViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransactionViewModel::class.java)) {
            return TransactionViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

