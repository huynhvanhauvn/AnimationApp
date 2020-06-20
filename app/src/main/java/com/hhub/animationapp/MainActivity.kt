package com.hhub.animationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.widget.ImageView
import androidx.core.view.isVisible
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    lateinit var img1 : ImageView
    lateinit var img2 : ImageView
    lateinit var img3 : ImageView
    lateinit var img4 : ImageView
    lateinit var img5 : ImageView
    lateinit var img6 : ImageView
    lateinit var timer : Timer
    lateinit var fadeIn : AlphaAnimation
    lateinit var fadeOut : AlphaAnimation
    lateinit var fadeInAnimationSet: AnimationSet
    lateinit var fadeOutAnimationSet: AnimationSet
    var n : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);

        fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.duration = 300
        fadeInAnimationSet = AnimationSet(false)
        fadeInAnimationSet.addAnimation(fadeIn)

        fadeOut = AlphaAnimation(1f, 0f)
        fadeOut.interpolator = AccelerateInterpolator()
        fadeOut.duration = 300
        fadeOutAnimationSet = AnimationSet(false)
        fadeOutAnimationSet.addAnimation(fadeOut)
    }

    override fun onStart() {
        super.onStart()
        var view : View
        timer = Timer();
        timer.schedule(0, 400) {
            runOnUiThread {
                when(n) {
                    1 -> {
                        if (img1.visibility === View.INVISIBLE) {
                            img1.startAnimation(fadeInAnimationSet)
                        }
                        img1.visibility = View.VISIBLE
                    }
                    2 -> {
                        img2.startAnimation(fadeInAnimationSet)
                        img2.visibility = View.VISIBLE
                    }
                    3 -> {
                        img3.startAnimation(fadeInAnimationSet)
                        img3.visibility = View.VISIBLE
                    }
                    4 -> {
                        img4.startAnimation(fadeInAnimationSet)
                        img4.visibility = View.VISIBLE
                    }
                    5 -> {
                        img5.startAnimation(fadeInAnimationSet)
                        img5.visibility = View.VISIBLE
                    }
                    6 -> {
                        img6.startAnimation(fadeInAnimationSet)
                        img6.visibility = View.VISIBLE
                    }
                    7 -> {
                        img1.startAnimation(fadeOutAnimationSet)
                        img1.visibility = View.INVISIBLE
                    }
                    8 -> {
                        img2.startAnimation(fadeOutAnimationSet)
                        img2.visibility = View.INVISIBLE
                    }
                    9 -> {
                        img3.startAnimation(fadeOutAnimationSet)
                        img3.visibility = View.INVISIBLE
                    }
                    10 -> {
                        img4.startAnimation(fadeOutAnimationSet)
                        img4.visibility = View.INVISIBLE
                    }
                    11 -> {
                        img5.startAnimation(fadeOutAnimationSet)
                        img5.visibility = View.INVISIBLE
                    }
                    12 -> {
                        img6.startAnimation(fadeOutAnimationSet)
                        img6.visibility = View.INVISIBLE
                    }
                }
                if(n==12) {
                    n = 0
                } else {
                    n++
                }
            }
        }
    }
}
