package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import android.widget.GridLayout
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Create data class
        // Create list from data class type
        // Create Adapter
        // Set Adapter
        // Linear Layout manager
        // Submeter a Lista
        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
            //  .apply {
            //    orientation = LinearLayoutManager.HORIZONTAL
            //  }

        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)

        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)

            Log.d("Marcos", contact.toString())
        }
    }
}

private val contacts = listOf(
    Contact(
        "Marcos",
        "(55) 27 99803-6366",
         R.drawable.sample9,
    ),
    Contact(
        "Lais",
        "(55) 21 99781-1109",
        R.drawable.sample1,
    ),
    Contact(
        "Kayke",
        "(55) 12 99854-5485",
        R.drawable.sample2,
    ),
    Contact(
        "Lisa",
        "(55) 27 99876-2145",
        R.drawable.sample3,
    ),
    Contact(
        "Julia",
        "(55) 74 99960-7521",
        R.drawable.sample4,
    ),
    Contact(
        "Michele",
        "(55) 35 99990-1046",
        R.drawable.sample5,
    ),
    Contact(
        "Monica",
        "(55) 48 99910-5002",
        R.drawable.sample6,
    ),
    Contact(
        "Livia",
        "(55) 35 99543-6136",
        R.drawable.sample7,
    ),
    Contact(
        "Francisco",
        "(55) 12 99890-7745",
        R.drawable.sample8,
    ),
    Contact(
        "Artur",
        "(55) 67 99940-6553",
        R.drawable.sample10,
    ),
    Contact(
        "Natália",
        "(55) 27 99902-2011",
        R.drawable.sample11,
    ),
    Contact(
        "Alan",
        "(55) 11 99999-4476",
        R.drawable.sample12,
    ),
    Contact(
        "Carla",
        "(55) 34 99603-2266",
        R.drawable.sample13,
    ),
    Contact(
        "Tales",
        "(55) 98 99803-6776",
        R.drawable.sample14,
    ),
    Contact(
        "Karen",
        "(55) 44 99893-9966",
        R.drawable.sample15,
    ),
    Contact(
        "Paula",
        "(55) 22 99903-8899",
        R.drawable.sample16,
    )
)