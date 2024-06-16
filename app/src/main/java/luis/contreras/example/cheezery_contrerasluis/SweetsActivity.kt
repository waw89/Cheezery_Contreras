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

class SweetsActivity: AppCompatActivity() {

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
        sweets.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.0))
        sweets.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.0))
        sweets.add(Product("Peanut milkshake", R.drawable.peanutmilshake, "Pastry shell with a lemon flavored filling", 4.0))
        sweets.add(Product("Muffin", R.drawable.muffin, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.0))
        sweets.add(Product("Caramel frap", R.drawable.caramel_frap, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.0))
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
            var description = view.findViewById(R.id.productDescription) as TextView
            var price = view.findViewById(R.id.productPrice) as TextView


            image.setImageResource(prod.image)
            name.setText(prod.name)
            description.setText(prod.description)
            price.setText("$${prod.price}")

            return view
        }
    }
}