package com.zzazzu.ocrfunction_210705

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.AbsSavedState
import com.googlecode.tesseract.android.TessBaseAPI
import java.io.File

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle

//class MainActivity : AppCompatActivity() {
 //   override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)


//    }
//}

    lateinit var tess: TessBaseAPI //tess~ API 객체 생성
    var dataPath: String = "" //데이터경로변수 선언

    override fun onCreate(savedInstantState: Bundle?) {
        super.onCreate(savedInstantState)
        setContentView(R.layout.activity_main)

        dataPath = "$filesDir/tesseract/" //언어데이터 경로 미리 지정

        checkFile(File(dataPath+"tessdata/"),"kor") //사용할 언어파일의 이름 지정
        checkFile(File(dataPath+"tessdata/"),"eng")

        val lang : String = "kor+eng"
        tess = tessBaseAPI() // api 준비
        tess.init(dataPath, lang) //해당 사용할 언어데이터로 초기화

        //OCR 동작 버튼
        val onclickListener = ocr_start_button.setOnclickListener {

            processImage(BitmapFactory.decodeResource(resources,R.drawable.sample_kor)) // 이미지 가공 후 텍스트 뷰에 띄우기

        }

    }
}
