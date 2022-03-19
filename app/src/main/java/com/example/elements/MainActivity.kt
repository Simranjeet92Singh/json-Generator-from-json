package com.example.elements

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileWriter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//val face = Typeface.createFromAsset(this.assets,"GurbaniWebThick.ttf")
val text = findViewById<TextView>(R.id.text)

//        text.setTypeface(face)

        val p : ArrayList<String> = ArrayList()
        val q : ArrayList<String> = ArrayList()


        for(l in 1100 ..1199){
//if(l == 72)continue
//            if(l==82 )continue
//            if( l==341) continue
//            if(l== 342)continue
//            if(l== 433)continue
//            if(l== 441)continue
//
//            if(l== 443)continue
//            if(l== 839)continue
//            if(l== 840)continue
//
//            if(l>=918 && l<=922)continue
//            if(l>=930 && l<=937) continue
//                if( l== 1029)continue
//                        if( l== 1046)continue
//            if( l== 1065)continue
//                    if( l== 1079)continue
//            if(l== 1362)continue
//            if(l== 1411)continue
//
//            if(l>=1414 && l<=1420) continue
//            if(l>=1422 && l<=1424) continue


    val obj = JSONArray(loadJSONFromAsset(this, "$l.json"))
    for (i in 0 until obj.length()) {
        val objects: JSONObject = obj.getJSONObject(i)
        val key: Iterator<*> = objects.keys()
        while (key.hasNext()) {
            val k = key.next().toString()

            when(k){

                "lines" -> {
                    val t = objects.getJSONArray(k)

                    for(j in 0 until t.length() ){
                        val t1 : JSONObject = t.getJSONObject(j)
                        val key1 : Iterator<*> = t1.keys()
                        while(key1.hasNext()){
                            val k1 = key1.next().toString()

                            when(k1){
                                "gurmukhi" -> {
                                    p.add(t1.getJSONObject(k1).getString("SGPC"))
                                }
                            }
                        }
                    }

                }}
        }
    }
}


        for(l in 1100 ..1199){

//            if( l==341) continue
//            if(l== 342)continue
//            if(l== 433)continue
//            if(l== 441)continue
//
//            if(l== 443)continue
//            if(l== 839)continue
//            if(l== 840)continue
//
//            if(l>=918 && l<=922)continue
//            if(l>=930 && l<=937) continue
//            if( l== 1029)continue
//            if( l== 1046)continue
//            if( l== 1065)continue
//            if( l== 1079)continue
//            if(l== 1362)continue
//            if(l== 1411)continue

//            if(l>=1414 && l<=1420) continue
//            if(l>=1422 && l<=1424) continue

//            if(  l==72 ) continue
//
//            if(l==82 )continue

//                && l== 341 && l== 342 && l== 443 && (l>=918 && l<=922) && (l>=930 && l<=937) && l== 1029 && l== 1046 && l== 1065 && l== 1079 && l== 1362   && (l>=1414 && l<=1420)) continue

            val obj = JSONArray(loadJSONFromAsset(this, "$l.json"))

            for (i in 0 until obj.length()) {
                val objects: JSONObject = obj.getJSONObject(i)
                val key: Iterator<*> = objects.keys()
                while (key.hasNext()) {
                    val k = key.next().toString()

                    when(k){

                        "lines" -> {
                            val t = objects.getJSONArray(k)

                            for(j in 0 until t.length() ){
                                val t1 : JSONObject = t.getJSONObject(j)
                                val key1 : Iterator<*> = t1.keys()
                                while(key1.hasNext()){
                                    val k1 = key1.next().toString()

                                    when(k1){
                                        "translations" -> {
                                            q.add(t1.getJSONObject(k1).getJSONObject("English").getJSONObject("Dr. Sant Singh Khalsa").getString("translation"))
                                        }
                                    }
                                }
                            }

                        }}
                }
            }
        }


        Log.d("t",p.size.toString())


        j(k((p.size-1),p).toString())

        v(k((p.size-1),q).toString())

//        text.setText(k(q.size-1,q).toString())



    }





    fun k ( t:Int , s : ArrayList<String>):ArrayList<String>{

        val l : ArrayList<String> = ArrayList()
        val l1 : ArrayList<String> = ArrayList()

        for(j in 47308 .. t+47308 ){
            l1.add("${j}")
        }
Log.d("j",l1.size.toString())
        for ( i in 0 .. t){


l.add(" \"${"${l1[i]}"}\"${":"} \"${s[i]}\" ${"\n"}")
        }
    return l

    }




fun j (t:String){
    val file = File(this@MainActivity.filesDir, "text")
    if (!file.exists()) {
        file.mkdir()
    }
    try {
        val gpxfile = File(file, "S12.json")
        val writer = FileWriter(gpxfile)
        writer.append(t)
        writer.flush()
        writer.close()
        Toast.makeText(this@MainActivity, "Saved your text", Toast.LENGTH_LONG).show()
    } catch (e: Exception) {
    }
}


    fun v (t:String){
        val file = File(this@MainActivity.filesDir, "text")
        if (!file.exists()) {
            file.mkdir()
        }
        try {
            val gpxfile = File(file, "se12.json")
            val writer = FileWriter(gpxfile)
            writer.append(t)
            writer.flush()
            writer.close()
            Toast.makeText(this@MainActivity, "Saved your text", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
        }
    }

    fun loadJSONFromAsset(context: Context, fileName:String): String {

        val t = context.assets.open(fileName)

//        val t = resources.openRawResource(R.raw.ardas)
        val size = t.available()
        val buffer = ByteArray(size)
        t.read(buffer)
        t.close()
        return String(buffer, Charsets.UTF_8)
    }

}