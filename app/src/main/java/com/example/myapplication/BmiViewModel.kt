package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class BmiViewModel : ViewModel() {
    // Input states
    private val _heightInput = mutableStateOf("")
    val heightInput: State<String> = _heightInput

    private val _weightInput = mutableStateOf("")
    val weightInput: State<String> = _weightInput

    // Function to update height input
    fun onHeightInputChanged(newHeight: String) {
        _heightInput.value = newHeight
    }

    // Function to update weight input
    fun onWeightInputChanged(newWeight: String) {
        _weightInput.value = newWeight
    }

    // Function to calculate BMI
    fun calculateBmi(): Float {
        val height = _heightInput.value.toFloatOrNull() ?: 0.0f
        val weight = _weightInput.value.toFloatOrNull() ?: 0.0f
        return if (weight > 0 && height > 0) weight / (height * height) else 0.0f
    }
}
