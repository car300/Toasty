package com.xhe.toastdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import com.xhe.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv1.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:4008587585,,3"))
            startActivity(phoneIntent)
//            Toasty.with(this)
//                    .message(tv1.text.toString())
//                    .duration(Toasty.LENGTH_LONG) //持续时间
//                    .gravity(Gravity.BOTTOM) //位置
//                    .replaceType(Toasty.REPLACE_NOW)//立即替换当前显示中的
//                    .show()
        }

        tv2.setOnClickListener {

            Toasty.with(this)
                    .message(tv2.text.toString())
                    .gravity(Gravity.TOP)
                    .replaceType(Toasty.REPLACE_BEHIND)//等待当前显示正常结束
                    .show()
        }

        tv3.setOnClickListener {
            //            PToast.makeText(this, tv3.text.toString()).replace(false).show()
            startActivity(Intent(this, SecondsActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("PToast", javaClass.simpleName + "-------onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("PToast", javaClass.simpleName + "-------onRestart")
    }

    override fun onPause() {
        Log.d("PToast", javaClass.simpleName + "-------onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("PToast", javaClass.simpleName + "-------onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("PToast", javaClass.simpleName + "-------onDestroy")
        super.onDestroy()
    }
}
