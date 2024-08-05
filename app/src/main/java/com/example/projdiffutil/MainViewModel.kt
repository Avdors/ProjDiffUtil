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
            Item(3, "Пример 3"),
            Item(5, "Пример 5"),
            Item(6, "Пример 6"),
            Item(7, "Пример 7"),
            Item(8, "Пример 8"),
            Item(9, "Пример 9"),
            Item(10, "Пример 10"),
            Item(11, "Пример 11"),
            Item(12, "Пример 12"),
            Item(13, "Пример 13"),
            Item(14, "Пример 14"),
            Item(15, "Пример 15"),
            Item(16, "Пример 16"),
        )
    }

    fun updateItems(random: Int) {

        if(random == 2){
            _items.value = listOf(
                Item(1, "Пример 1 обновлён"),
                Item(2, "Пример 2"),
                Item(4, "Пример 4"),
                Item(5, "Пример 5"),
                Item(6, "Пример 6"),
                Item(7, "Пример 7"),
                Item(8, "Пример 8"),
                Item(9, "Пример 9"),
                Item(10, "Пример 10"),
                Item(11, "Пример 11"),
                Item(12, "Пример 12"),
                Item(13, "Пример 13"),
                Item(14, "Пример 14"),
                Item(15, "Пример 15"),
                Item(16, "Пример 16 тоже изменили"),
            )
        } else {
            _items.value = listOf(
                Item(1, "Пример 1 обновлён"),
                Item(2, "Пример 2"),
                Item(4, "Пример 4"),
                Item(5, "Пример 5"),
                Item(6, "Пример 6"),
                Item(7, "Пример 7"),
                Item(8, "Пример 8"),
                Item(9, "Пример 9"),
                Item(10, "Пример 10"),
                Item(11, "Пример 11"),
                Item(12, "Пример 12"),
                Item(13, "Пример 13"),
                Item(14, "Пример 14"),
                Item(15, "Пример 15"),
                Item(16, "Пример 16"),
            )
        }
    }
}