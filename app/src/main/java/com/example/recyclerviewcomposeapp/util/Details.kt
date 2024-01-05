package com.example.recyclerviewcomposeapp.util

import com.example.recyclerviewcomposeapp.R
import com.example.recyclerviewcomposeapp.model.EmployDetails

object Details {
    val EmployDetailsList = listOf(
        EmployDetails(
            id = 1,
            title = "Rohan",
            sex = "Male",
            age = 24,
            description = " Don't judge each day by the harvest you reap but by the seeds that you plant.” - ...",
            ImageId = R.drawable.ic_launcher_foreground
        ),
        EmployDetails(
            id = 2,
            title = "Roy",
            sex = "male",
            age = 25,
            description = " Don't judge each day by the harvest you reap but by the seeds that you plant.” - ...",
            ImageId = R.drawable.ic_launcher_foreground
        ),
        EmployDetails(
            id = 3,
            title = "Vishal",
            sex = "Male",
            age = 29,
            description = " Don't judge each day by the harvest you reap but by the seeds that you plant.” - ...",
            ImageId = R.drawable.ic_launcher_foreground
        ),
        EmployDetails(
            id = 4,
            title = "Nikhil",
            sex = "Male",
            age = 27,
            description = " Don't judge each day by the harvest you reap but by the seeds that you plant.” - ...",
            ImageId = R.drawable.ic_launcher_foreground
        )
    )
}