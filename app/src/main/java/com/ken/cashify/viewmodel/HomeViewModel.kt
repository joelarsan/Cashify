package com.ken.cashify.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ken.cashify.data.ExpenseDatabase
import com.ken.cashify.model.Expense
import com.ken.cashify.repository.ExpenseRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val db = ExpenseDatabase.getDatabase(application)
    private val repo = ExpenseRepository( db.expenseDao())

    val expenses = repo.expenses.asLiveData()

    fun addExpense(description: String, amount: Double) {
        viewModelScope.launch {
            val expense = Expense(description = description, amount = amount)
            repo.insert(expense)
        }
    }

    fun deleteExpense(expense: Expense) {
        viewModelScope.launch {
            repo.delete(expense)
        }
    }
}