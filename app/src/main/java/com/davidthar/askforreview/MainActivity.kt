package com.davidthar.askforreview

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.davidthar.askforreview.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAskForReview.setOnClickListener {
            createReviewDialog()
        }

    }

    private fun createReviewDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_review)

        var stars = 1

        val btnCancel = dialog.findViewById(R.id.btnCancel) as Button
        val btnOk = dialog.findViewById(R.id.btnOk) as Button
        val arrayStars = arrayOf(
                dialog.findViewById(R.id.star1),
                dialog.findViewById(R.id.star2),
                dialog.findViewById(R.id.star3),
                dialog.findViewById(R.id.star4),
                dialog.findViewById<ImageView>(R.id.star5))

        arrayStars.forEach { it ->
            when(it){
                arrayStars[0] -> {
                    it.setOnClickListener {
                        arrayStars.forEach { star ->
                            stars = 1
                            if (star == arrayStars[0]) {
                                star.setImageResource(R.drawable.star)
                            } else {
                                star.setImageResource(R.drawable.star_border)
                            }
                        }
                    }
                }
                arrayStars[1] -> {
                    it.setOnClickListener {
                        arrayStars.forEach { star ->
                            stars = 2
                            if (star == arrayStars[0] || star == arrayStars[1]) {
                                star.setImageResource(R.drawable.star)
                            } else {
                                star.setImageResource(R.drawable.star_border)
                            }
                        }
                    }
                }
                arrayStars[2] -> {
                    it.setOnClickListener {
                        arrayStars.forEach { star ->
                            stars = 3
                            if (star == arrayStars[0] || star == arrayStars[1] || star == arrayStars[2]) {
                                star.setImageResource(R.drawable.star)
                            } else {
                                star.setImageResource(R.drawable.star_border)
                            }
                        }
                    }
                }
                arrayStars[3] -> {
                    it.setOnClickListener {
                        arrayStars.forEach { star ->
                            stars = 4
                            if (star == arrayStars[0] || star == arrayStars[1] || star == arrayStars[2] || star == arrayStars[3]) {
                                star.setImageResource(R.drawable.star)
                            } else {
                                star.setImageResource(R.drawable.star_border)
                            }
                        }
                    }
                }
                arrayStars[4] -> {
                    it.setOnClickListener {
                        stars = 5
                        arrayStars.forEach {
                            it.setImageResource(R.drawable.star)
                        }
                    }
                }
            }
        }

        btnOk.setOnClickListener {
            if(stars>3){
                rateIntent()
                dialog.cancel()
            }else dialog.cancel()
        }

        btnCancel.setOnClickListener {
            dialog.cancel()
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.show()
    }

    private fun rateIntent() {
            try {
                val playstoreuri1: Uri = Uri.parse("market://details?id=" + packageName)
                val playstoreIntent1 = Intent(Intent.ACTION_VIEW, playstoreuri1)
                startActivity(playstoreIntent1)
            }catch (exp:Exception){
                val playstoreuri2: Uri = Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)
                val playstoreIntent2 = Intent(Intent.ACTION_VIEW, playstoreuri2)
                startActivity(playstoreIntent2)
            }
    }


}