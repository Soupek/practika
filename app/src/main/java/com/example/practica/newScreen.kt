package com.example.practica

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class newScreen : AppCompatActivity() {
    //private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

//    override fun onResume() {
//        super.onResume()
//        val bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.layoutBottomSheet))
//
//        bottomSheetBehavior.setBottomSheetCallback(object :
//            BottomSheetBehavior.BottomSheetCallback() {
//
//            override fun onStateChanged(view: View, state: Int) {
//                when (state) {
//                    BottomSheetBehavior.STATE_EXPANDED -> {
//                        findViewById<Button>(R.id.floatingActionButton).visibility = View.GONE
//                    }
//                    BottomSheetBehavior.STATE_COLLAPSED -> {
//                        findViewById<Button>(R.id.floatingActionButton).visibility =
//                            View.VISIBLE
//                    }
//                }
//            }
//
//            override fun onSlide(view: View, p1: Float) {
//            }
//        })
//        findViewById<Button>(R.id.floatingActionButton).setOnClickListener {
//            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
//                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
//            } else {
//                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
//            }
//        }
//    }

    lateinit var btnShowBottomSheet: Button
//    @SuppressLint("MissingInflatedId")

    private lateinit var dialog: BottomSheetDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_screen)
//        showBottomSheet()

        btnShowBottomSheet = findViewById(R.id.floatingActionButton);

        // adding on click listener for our button.
        btnShowBottomSheet.setOnClickListener {

            // on below line we are creating a new bottom sheet dialog.
            dialog = BottomSheetDialog(this)

            // on below line we are inflating a layout file which we have created.
            val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
            dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)

            // on below line we are creating a variable for our button
            // which we are using to dismiss our dialog.
            val btnClose = view.findViewById<Button>(R.id.btnclose)

            // on below line we are adding on click listener
            // for our dismissing the dialog button.
            btnClose.setOnClickListener {
                // on below line we are calling a dismiss
                // method to close our dialog.
                dialog.dismiss()
            }
            // below line is use to set cancelable to avoid
            // closing of dialog box when clicking on the screen.
            dialog.setCancelable(false)

            // on below line we are setting
            // content view to our view.
            dialog.setContentView(view)

            // on below line we are calling
            // a show method to display a dialog.
            dialog.show()
        }

    }

//    private fun showBottomSheet(){
//        val dialogView = layoutInflater.inflate(R.layout.bottom_sheet, null)
//        dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
//        dialog.setContentView(dialogView)
//    }
}