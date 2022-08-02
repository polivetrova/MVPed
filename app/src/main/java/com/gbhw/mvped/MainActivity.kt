package com.gbhw.mvped

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gbhw.mvped.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private val btnNumber1Index: Int = 0
    private val btnNumber2Index: Int = 1
    private val btnNumber3Index: Int = 2

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            btnNumber1.setOnClickListener {
                presenter.onCounterClick(btnNumber1Index)
            }
            btnNumber2.setOnClickListener {
                presenter.onCounterClick(btnNumber2Index)
            }
            btnNumber3.setOnClickListener {
                presenter.onCounterClick(btnNumber3Index)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String, position: Int) {
        with(binding) {
            when (position) {
                btnNumber1Index -> tvText1.text = counter
                btnNumber2Index -> tvText2.text = counter
                btnNumber3Index -> tvText3.text = counter
            }
        }
    }
}
