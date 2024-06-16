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

class SaltiesActivity:AppCompatActivity(){
var salties = ArrayList<Product>()


override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_salties)
    addProducts()
    var listView: ListView = findViewById(R.id.list_view_salties) as ListView
    var adapter: SaltiesActivity.ProductAdapter = SaltiesActivity.ProductAdapter(salties, this)
    listView.adapter = adapter

}

    fun addProducts(){


        salties.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.0))
        salties.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.0))
        salties.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling", 4.0))
        salties.add(Product("Philly cheese steak", R.drawable.phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0))
        salties.add(Product("Nachos", R.drawable.nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7.0))

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