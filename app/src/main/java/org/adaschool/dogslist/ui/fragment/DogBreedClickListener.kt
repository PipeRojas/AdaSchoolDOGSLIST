package org.adaschool.dogslist.ui.fragment

import org.adaschool.dogslist.data.entity.Breed

interface DogBreedClickListener {
    fun onDogBreedClicked(breed: Breed)
}