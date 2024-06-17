package luis.contreras.example.cheezery_contrerasluis

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SweetsActivity : AppCompatActivity() {

    var sweets = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sweets)

        addProducts()

        var listView: ListView = findViewById(R.id.list_view_sweets) as ListView

        var adapter: SweetsActivity.ProductAdapter =
            SweetsActivity.ProductAdapter(sweets, this)

        listView.adapter = adapter
    }
    fun addProducts(){
        sweets.add(Product("Hot Chocolate", R.drawable.hotchocolate, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
        sweets.add(Product("Capuccino", R.drawable.capuccino, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
        sweets.add(Product("Chai Latte", R.drawable.chailatte, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
        sweets.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
        sweets.add(Product("Espresso", R.drawable.espresso, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
        sweets.add(Product("Americano", R.drawable.americano, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0))


    }
    class ProductAdapter: BaseAdapter {

        var productos = ArrayList<Product>()
        var context: Context? = null
        constructor(productos:ArrayList<Product>, context: Context){
            this.productos=productos
            this.context = context
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            var prod = productos[p0]
            var inflador = LayoutInflater.from(context)
            var view = inflador.inflate(R.layout.producto_view, null)

            var image = view.findViewById(R.id.productImg) as ImageView
            var name = view.findViewById(R.id.productName) as TextView
            var description = view.findViewById(R.id.productName) as TextView
            var price = view.findViewById(R.id.productName) as TextView


            image.setImageResource(prod.image)
            name.setText(prod.name)
            description.setText(prod.description)
            price.setText("$${prod.price}")

            return view
        }
    }

}