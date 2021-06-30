package com.example.ngncurrencyconverter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.ngncurrencyconverter.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    var selectedOption: String = "AED - UAE Dirham"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner: Spinner = binding.currency
        ArrayAdapter.createFromResource(
            this,
            R.array.currency_array,
            android.R.layout.simple_expandable_list_item_1
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1)
            spinner.adapter = adapter
        }
        spinner.setSelection(0)
        spinner.onItemSelectedListener = this
        binding.convert.setOnClickListener{ convertAmount()}
    }

    @SuppressLint("StringFormatInvalid")
    private fun convertAmount() {
        val stringInTextField = binding.enter.text.toString()
        val exchangeRate: Double
        if (stringInTextField.isNotEmpty()) {
            exchangeRate = when (selectedOption) {
                    "AED - UAE Dirham"-> { 112.03 }
                    "AFN- Afghani"-> { 5.18 }
                    "ALL - Lek"-> { 4.00 }
                    "AMD - Armenian Dram"-> { 0.82 }
                    "AOA - Kwanza"-> { 0.64 }
                    "ARS - Argentine Peso"-> { 4.30 }
                    "AUD - Australian Dollar"-> { 312.68 }
                    "AWG - Aruban Guilder/Florin"-> { 228.61 }
                    "AZN - Azerbaijanian Manat"-> { 242.06}
                    "BAM - Konvertibilna Marka"-> { 251.32 }
                    "BBD - Barbados Dollar"-> { 203.86 }
                    "BDT - Taka"-> { 4.86 }
                    "BGN - Bulgarian Lev"-> { 251.54 }
                    "BHD - Bahraini Dinar"-> { 1091.67 }
                    "BIF - Burundi Franc"-> { 0.21 }
                    "BMD - Bermudian Dollar"-> { 411.50 }
                    "BND - Brunei Dollar"-> { 306.70 }
                    "BOB - Boliviano"-> { 59.62 }
                    "BRL - Brazilian Real"-> { 83.53 }
                    "BSD - Bahamian Dollar"-> { 411.45}
                    "BTN - Ngultrum"-> { 5.55}
                    "BWP - Pula"-> { 38.02 }
                    "BYN - Belarusian Ruble"-> { 162.89 }
                    "BZD - Belize Dollar"-> { 204.22 }
                    "CAD - Canadian Dollar"-> { 334.65 }
                    "CDF - Congolese Franc"-> { 0.21 }
                    "CHF - Swiss Franc"-> { 448.49 }
                    "CLP - Chilean Peso"-> { 0.56 }
                    "CNY - Yuan"-> { 63.74 }
                    "COP - Colombian Peso"-> { 0.11 }
                    "CRC - Costa Rican Colon"-> { 0.66 }
                    "CUP - Cuban Peso"-> { 17.14 }
                    "CEV - Cape Verde Escudo"-> { 4.44 }
                    "CZK- Czech Koruna"-> { 19.28 }
                    "DJF - Djibouti Franc"-> { 2.31 }
                    "DKK - Danish Krone"-> { 66.05 }
                    "DOP - Dominican Peso"-> { 7.21 }
                    "DZD - Algerian Dinar"-> { 3.07 }
                    "EGP - Egyptian Pound"-> { 26.25 }
                    "ERN - Nakfa"-> { 27.397 }
                    "ETB- Ethiopian Birr"-> { 9.43}
                    "EUR - Euro"-> { 491.21 }
                    "FJD - Fuji Dollar"-> { 199.54 }
                    "FKP - Falkland Islands Pound"-> { 549.99 }
                    "GBP - Pound Sterling"-> { 571.93 }
                    "GEL - Lari"-> { 131.26 }
                    "GHS - Cedi"-> { 70.58}
                    "GIP - Gibraltar Pound"-> { 566.28 }
                    "GMD - Dalasi"-> { 8.05 }
                    "GNF - Guinea Franc"-> { 0.042 }
                    "GTQ - Quetzal"-> { 53.15 }
                    "GYD - Guyana Dollar"-> { 1.97 }
                    "HKD - Hong Kong Dollar"-> { 53.02 }
                    "HNL - Lempira"-> { 17.16 }
                    "HRK - Croatian Kuna"-> { 65.51 }
                    "HTG - Gourde"-> { 4.44 }
                    "HUF - Forint"-> { 1.40 }
                    "IDR - Rupiah"-> { 0.028 }
                    "ILS - New Israeli Shekel"-> { 126.55 }
                    "INR - Indian Rupee"-> { 5.55 }
                    "IQD - Iraqi Dinar"-> { 0.28 }
                    "IRR - Iranian Rial"-> { 0.0098 }
                    "ISK - Iceland Krona"-> { 3.34 }
                    "JMD - Jamaican Dollar"-> { 2.74 }
                    "JOD - Jordanian Dinar"-> { 580.40 }
                    "JPY - Yen"-> { 3.71 }
                    "KES - Kenyan Shilling"-> { 3.82 }
                    "KGS - Som"-> { 4.86}
                    "KHR - Riel"-> { 0.10 }
                    "KPW - North Korean Won"-> { 0.4566 }
                    "KRW - South Korean Won"-> { 0.36 }
                    "KWD - Kuwaiti Dinar"-> { 1365.75 }
                    "KYD- Cayman Islands Dollar"-> { 493.94 }
                    "KZT - Tenge"-> { 0.96 }
                    "LAK - Kip"-> { 0.043 }
                    "LBP - Lebanese Pound"-> { 0.27 }
                    "LKR - Sri Lanka Rupee"-> { 2.07 }
                    "LRD - Liberian Dollar"-> { 2.40 }
                    "LSL - Loti"-> { 28.94 }
                    "LYD - Libyan Dinar"-> { 91.34 }
                    "MAD - Moroccan Dirham"-> { 46.30 }
                    "MDL - Moldovan Leu"-> { 22.92 }
                    "MGA - Malagasy Ariary"-> { 0.11 }
                    "MKD - Denar"-> { 7.98 }
                    "MMK - Kyat"-> { 0.25 }
                    "MNT - Tugrik"-> { 0.14	 }
                    "MOP -Pataca"-> { 51.49 }
                    "MRU - Ouguiya"-> { 11.38}
                    "MUR - Mauritius Rupee"-> { 10.06 }
                    "MVR - Rufiyaa"-> { 26.62 }
                    "MWK - Kwacha"-> { 0.51 }
                    "MXN - Mexican Peso"-> { 20.79 }
                    "MYR - Malaysian Ringgit"-> { 98.92 }
                    "MZN - Metical"-> { 6.50 }
                    "NAD - Namibia Dollar"-> { 28.94 }
                    "NIO - Cordoba Oro"-> { 11.67 }
                    "NOK - Norwegian Krone"-> { 48.46 }
                    "NPR - Nepalese Rupee"-> { 3.47 }
                    "NZD - New Zealand Dollar"-> { 290.99 }
                    "OMR - Rial Omani"-> { 1068.98 }
                    "PAB - Balboa"-> { 411.62 }
                    "PEN - Nuevo Sol"-> { 103.02 }
                    "PGK - Kina"-> { 117.49 }
                    "PHP - Philippine Peso"-> {8.48 }
                    "PKR - Pakistan Rupee"-> { 2.61 }
                    "PLN - PZloty"-> {108.89 }
                    "PYG - Guarani"-> { 0.061 }
                    "QAR - Qatari Rial"-> { 113.02 }
                    "RON - Leu"-> { 99.67 }
                    "RSD - Serbian Dinar"-> { 4.18 }
                    "RUB - Russian Ruble"-> { 5.70 }
                    "RWF - Rwanda Franc"-> { 0.42 }
                    "SAR - Saudi Riyal"-> { 109.72 }
                    "SBD - Solomon Islands Dollar"-> { 51.29 }
                    "SCR - Seychelles Rupee"-> { 27.67 }
                    "SDG - Sudanese Pound"-> { 0.92 }
                    "SEK - Swedish Krona"-> { 48.50}
                    "SGD - Singapore Dollar" -> { 306.61 }
                    "SHP - Saint Helena Pound" -> { 572.19 }
                    "SLL - Leone" -> { 0.040 }
                    "SOS - Somali Shilling"-> { 0.70 }
                    "SRD - Suriname Dollar" -> { 19.85 }
                    "STN - Dobra" -> { 20.0127 }
                    "SYP - Syrian Pound"-> { 0.87 }
                    "SZL - Lilangeni"-> { 28.94 }
                    "THB - Baht"-> { 12.95 }
                    "TJS - Somoni"-> { 36.08 }
                    "TMT - Manat"-> { 117.79 }
                    "TND - Tunisian Dinar"-> {149.18}
                    "TOP - Pa’anga" -> { 183.53 }
                    "TRY - Turkish Lira" -> { 46.98 }
                    "TTD - Trinidad and Tobago Dollar" -> { 60.64 }
                    "TWD - Taiwan Dollar" -> { 14.74 }
                    "TZS - Tanzanian Shilling" -> { 0.18 }
                    "UAH - Hryvnia" -> { 15.05 }
                    "UGX - Uganda Shilling" -> { 0.12 }
                    "USD - US Dollar" ->{ 411.50 }
                    "UYU - Peso Uruguayo" -> { 9.47 }
                    "UZS - Uzbekistan Sum" -> { 0.039 }
                    "VEF - Bolivar Fuerte" -> { 0.00000000128728 }
                    "VND - Dong" -> { 0.018 }
                    "VUV - Vatu" -> { 3.74 }
                    "WST - Tala" -> { 161.112 }
                    "XAF - CFA Franc BCEAO" -> { 0.75 }
                    "XCD - East Caribbean Dollar" ->{ 152.26 }
                    "XPF - CFP Franc" -> { 4.11 }
                    "YER - Yemeni Rial" -> { 1.64 }
                    "ZAR - Rand" -> { 29.19 }
                    "ZMW- Zambian Kwacha" -> { 18.21 }
                else -> {
                    // Change it to the exchange rate
                    1.13567
                }
            }
            val cost = stringInTextField.toDouble()
            val total = cost/exchangeRate
            val formattedTotal = NumberFormat.getCurrencyInstance().format(total)
            binding.rate.text = getString(R.string.total, formattedTotal)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
       selectedOption = parent?.getItemAtPosition(position).toString()
    }
}


