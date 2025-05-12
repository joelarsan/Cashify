package com.ken.cashify.repository

import com.ken.cashify.data.ExpenseDao
import com.ken.cashify.model.Expense
import kotlinx.coroutines.flow.Flow


class ExpenseRepository(private val dao :ExpenseDao) {

    val expenses: Flow<List<Expense>> = dao.getAllExpenses()

    suspend fun insert(expense: Expense) = dao.insertExpense(expense)

    suspend fun delete(expense: Expense) = dao.deleteExpense(expense)
}
