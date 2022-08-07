package org.adaschool.dogslist.ui.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.adaschool.dogslist.R
import org.adaschool.dogslist.data.entity.Breed
import org.adaschool.dogslist.ui.fragment.DogBreedClickListener

class DogsListAdapter(private val dataSet: List<Breed>, private val clickListener: DogBreedClickListener) :
    RecyclerView.Adapter<DogsListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val photo: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.name)
            photo = view.findViewById(R.id.photo)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.dog_breed_row, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val breed = dataSet[position]
        viewHolder.name.text = breed.name

        viewHolder.itemView.setOnClickListener { clickListener.onDogBreedClicked(breed) }

        if (breed.imageUrl?.isNotEmpty() == true)
            Picasso.get().load(breed.imageUrl).into(viewHolder.photo);

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}