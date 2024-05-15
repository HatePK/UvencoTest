package com.uvencotest.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvencotest.domain.api.DetailsInteractor
import com.uvencotest.domain.entity.ProductDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(
    private val detailsInteractor: DetailsInteractor
): ViewModel() {
    private val _stateLiveData = MutableStateFlow<MainState>(MainState.Loading)
    val stateLiveData: StateFlow<MainState> = _stateLiveData

    private val _temperature = MutableStateFlow(Random.nextInt(85, 95).toFloat())
    val temperature: StateFlow<Float> = _temperature

    private val _time = MutableStateFlow(getCurrentTime())
    val time: StateFlow<String> = _time

    init {
        viewModelScope.launch {
            getProducts()

            while (true) {
                delay(1000)
                trackTemperature()
                trackTime()
            }
        }
    }

    private suspend fun getProducts() {
        delay(1000)
        val card = detailsInteractor.getDetails()
        val listOfCards: MutableList<ProductDetails> = mutableListOf()
        repeat(20) {
            listOfCards.add(card)
        }

        _stateLiveData.value = MainState.Content(listOfCards)
    }

    fun saveDetails(product: ProductDetails) {
        detailsInteractor.saveDetails(product)
        viewModelScope.launch {
            getProducts()
        }
    }

    fun getDetails(): ProductDetails {
        return detailsInteractor.getDetails()
    }

    private suspend fun trackTemperature() {
        _temperature.value = getRandomNumber(_temperature.value)
    }

    private suspend fun trackTime() {
        _time.value = getCurrentTime()
    }

    private fun getRandomNumber(number: Float): Float {
        var startNumber = number
        val step = 0.1f

        if (startNumber == 85.0f) {
            startNumber += step
        } else if (startNumber == 95.0f) {
            startNumber -= step
        } else {
            val shouldIPlusIt = Random.nextBoolean()
            if (shouldIPlusIt) {
                startNumber += step
            } else {
                startNumber -= step
            }
        }
        return "%.1f".format(startNumber).toFloat()
    }

    private fun getCurrentTime(): String {
        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        return dateFormat.format(Date())
    }
}