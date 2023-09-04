package com.joaopaulosanttos.fitcalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.icon_calculate,
                txtStringId = R.string.txt_imc,
            )
        )
        mainItems.add(
            MainItem(
                id = 2,
                drawableId = R.drawable.icon_tmb,
                txtStringId = R.string.txt_tmb,
            )
        )
        mainItems.add(
            MainItem(
                id = 3,
                drawableId = R.drawable.icon_kcal,
                txtStringId = R.string.txt_kcal,
            )
        )

        mainItems.add(
            MainItem(
                id = 4,
                drawableId = R.drawable.icon_water,
                txtStringId = R.string.txt_water,
            )
        )

        rvMain = findViewById(R.id.rv_main)
        rvMain.adapter = MainAdapter(mainItems, object : OnItemClickListener {
            override fun onClick(id: Int) {
                when(id) {
                    1 -> {
                        val i = Intent(this@MainActivity, ImcActivity::class.java)
                        startActivity(i)
                    }
                }
            }

        })
        rvMain.layoutManager = GridLayoutManager(this, 2)
    }

    private inner class MainAdapter(
        val mainItems: List<MainItem>,
        val onItemClickListener: OnItemClickListener
        ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)
        }

        override fun getItemCount(): Int {
            return mainItems.size
        }

        inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(item: MainItem) {
                val icon: ImageView = itemView.findViewById(R.id.icon_item)
                val txt: TextView = itemView.findViewById(R.id.txt_item)

                icon.setImageResource(item.drawableId)
                txt.setText(item.txtStringId)

                itemView.setOnClickListener {
                    onItemClickListener.onClick(item.id)
                }
            }
        }
    }
}