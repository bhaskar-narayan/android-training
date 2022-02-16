package com.bhaskar.bigoh.viewpagerproject

class DataClass {
    var allTitle = mutableListOf<String>()
    var allDescription = mutableListOf<String>()
    var allImages = mutableListOf<Int>()

    fun getValues() {
        allTitle.add("Swift and Fast")
        allTitle.add("Security Assured")
        allTitle.add("Vaccinated Staff")

        allDescription.add("Lorem ipsum dolor sit amet consectetur, adipisicing elit. Commodi animi nesciunt magni distinctio blanditiis. Repellat laudantium harum ipsa necessitatibus inventore optio vitae suscipit error animi velit a, tempore eos expedita.")
        allDescription.add("Lorem ipsum dolor sit amet consectetur, adipisicing elit. Commodi animi nesciunt magni distinctio blanditiis. Repellat laudantium harum ipsa necessitatibus inventore optio vitae suscipit error animi velit a, tempore eos expedita.")
        allDescription.add("Lorem ipsum dolor sit amet consectetur, adipisicing elit. Commodi animi nesciunt magni distinctio blanditiis. Repellat laudantium harum ipsa necessitatibus inventore optio vitae suscipit error animi velit a, tempore eos expedita.")

        allImages.add(R.drawable.clock)
        allImages.add(R.drawable.secure)
        allImages.add(R.drawable.vaccine)
    }
}