package com.gbhw.mvped

class CountersPresenter(
    private val view: MainView
) {
    private val model = CountersModel()

    fun onCounterClick(position: Int) {
        val newValue = model.next(position)
        view.setText(newValue.toString(), position)
    }
}
