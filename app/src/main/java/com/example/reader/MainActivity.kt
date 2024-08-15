package com.example.reader

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.reader.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private var books : MutableList<Book> = mutableListOf()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view : View = binding.root
        setContentView(view)



        books = mutableListOf(
            Book("one hundred year of solitude", "By Gabrial Garcia Marquez", R.drawable.solitude ,1.3F),
            Book("Terra Nostra", "By Calios Fuentes", R.drawable.nostra, 3.5F),
            Book("Angles & Demons", "By Dan Brown", R.drawable.angels , 2.2F),
            Book("The Sword Thief", "By Peter Lerangis", R.drawable.sword , 1.3F),
            Book("Bloodline", "By james Rollin", R.drawable.blood , 2.2F),
            Book("The house of Spirits", "By isabel Allende", R.drawable.spirits ,4.5F),
            Book("The Hummingbirds daughter", "By luis alberto Urrea", R.drawable.humming, 4.9F)
        )

        val bookAdapter = BookAdapter(books)
        binding.rvBooks.adapter = bookAdapter

        binding.topAppBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.notify -> {Toast.makeText(this, R.string.NotifyClicked ,Toast.LENGTH_SHORT).show()
                true
                }
                else -> false
            }
        }
        binding.topAppBar.setNavigationOnClickListener {
            binding.drawer.open()
        }
        binding.navigationview.setNavigationItemSelectedListener {
          when(it.itemId){
               R.id.settings ->{ Toast.makeText(this , R.string.SettingClicked , Toast.LENGTH_SHORT).show()
              true}
              R.id.profilemenu ->{ Toast.makeText(this , R.string.profileclicked ,Toast.LENGTH_SHORT).show()
                  true}
              R.id.favorite ->{ Toast.makeText(this , R.string.favouriteclicked , Toast.LENGTH_SHORT).show()
                  true}
              R.id.Rewiew ->{ Toast.makeText(this , R.string.Rewiewclicked , Toast.LENGTH_SHORT).show()
                  true}

              R.id.search ->{ Toast.makeText(this , R.string.Searchclicked , Toast.LENGTH_SHORT).show()
                  true}
              else -> false

          }
        }


    }
}
