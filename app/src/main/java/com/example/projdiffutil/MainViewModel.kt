package com.example.projdiffutil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _items = MutableLiveData<List<Item>>()

    val items: LiveData<List<Item>> = _items

    init{
        _items.value = listOf(
            Item(1, "Пример 1"),
            Item(2, "Пример 2"),
            Item(3, "Пример 3")
        )
    }

    fun updateItems() {
        _items.value = listOf(
            Item(1, "Пример 1 обновлён"),
            Item(2, "Пример 2"),
            Item(4, "Пример 4")
        )
    }
}