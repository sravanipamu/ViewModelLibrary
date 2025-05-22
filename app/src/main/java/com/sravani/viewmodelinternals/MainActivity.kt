package com.sravani.viewmodelinternals

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sravani.myviewmodel.MyViewModel
import com.sravani.myviewmodel.MyViewModelProvider
import com.sravani.myviewmodel.MyViewModelStore
import com.sravani.myviewmodel.MyViewModelStoreOwner

class MainActivity : AppCompatActivity(), MyViewModelStoreOwner {

    lateinit var countBtn : AppCompatButton
    lateinit var countText : AppCompatTextView
    lateinit var countViewModel: CountViewModel
    private var myViewModelStore: MyViewModelStore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countViewModel = MyViewModelProvider(this, object : MyViewModelProvider.Factory {
            override fun <T : MyViewModel> create(modelClass: Class<T>): T {
                  return  CountViewModel() as T
            }
        }).get(CountViewModel::class.java)

        countBtn = findViewById(R.id.count_btn)
        countText = findViewById(R.id.count_tv)
        countBtn.setOnClickListener {
             countViewModel.incrementCount()
        }

        countViewModel.count.observe(this, object : Observer<Int>{
            override fun onChanged(value: Int) {
                countText.setText("Count $value")
            }

        })
    }

    // Retain ViewModelStore across configuration changes
    override fun onRetainCustomNonConfigurationInstance(): Any {
        Log.v("MainActivity", "onRetainCustomNonConfigurationInstance")
        return myViewModelStore!!
    }

    // Return the current ViewModelStore
    override fun getMyViewModelStore(): MyViewModelStore {
        // Restore or create ViewModelStore
        val retained = lastCustomNonConfigurationInstance as? MyViewModelStore
        if (retained != null) {
            myViewModelStore = retained
        } else {
            myViewModelStore = MyViewModelStore()
        }
        return myViewModelStore ?: throw IllegalStateException("ViewModelStore not initialized")
    }

    override fun onDestroy() {
        super.onDestroy()
        // Clear ViewModelStore only if Activity is finishing (not rotating)
        if (isFinishing) {
            myViewModelStore?.clear()
        }
    }

}


