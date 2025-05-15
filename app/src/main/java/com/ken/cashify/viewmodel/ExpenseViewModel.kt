package com.ken.cashify.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ken.cashify.data.ExpenseDao
import com.ken.cashify.model.Expense
import kotlinx.coroutines.launch

// ViewModel to handle Expense operations
class ExpenseViewModel(private val dao: ExpenseDao) : ViewModel() {

    // Function to insert a new expense
    fun insertExpense(expense: Expense) {
        viewModelScope.launch {
            dao.insertExpense(expense)
        }
    }
}

// Factory for creating ExpenseViewModel with the DAO injected
class ExpenseViewModelFactory(private val dao: ExpenseDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExpenseViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ExpenseViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
