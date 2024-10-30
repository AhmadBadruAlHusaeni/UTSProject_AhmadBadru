package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Ayam Geprek", "Hidangan ayam goreng yang dihancurkan atau diulek bersama sambal pedas ", R.drawable.ayamgepreks),
            Food("Ayam Kecap", "Masakan ayam yang dimasak dengan saus kecap manis sebagai bahan utama", R.drawable.ayamkecap),
            Food("Ayam Rendang", "Hidangan khas Minangkabau yang dimasak dengan bumbu rempah-rempah seperti lengkuas, serai, daun jeruk, dan santan", R.drawable.ayamrendang),
            Food("Ayam Rica-rica", "Ayam dimasak dengan bumbu khas seperti cabai, bawang merah, bawang putih, jahe, serai, dan daun jeruk", R.drawable.ayamricarica),
            Food("Ayam Katsu", "Hidangan Jepang yang berupa potongan dada ayam yang dilapisi tepung roti (panko) dan digoreng hingga renyah", R.drawable.ayamkatsu),
            Food("Es Teh", "Es teh adalah minuman teh yang disajikan dingin dengan es batu, populer di Indonesia", R.drawable.esteh)
        )

        adapter = FoodAdapter(foodList, this::onFoodItemClick)
        recyclerView.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun onFoodItemClick(food: Food) {
        val intent = Intent(this, OrderActivity::class.java)
        intent.putExtra("foodName", food.name)
        startActivity(intent)
    }
}