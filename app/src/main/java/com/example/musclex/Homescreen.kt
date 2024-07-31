package com.example.musclex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.musclex.navigation.Screens
import com.example.musclex.ui.theme.MuscleXTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val backgroundColor = Color(0xFF2C5364) // replace with your desired background color

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exercises") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backgroundColor,
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.gradient_start_color),
                            colorResource(id = R.color.gradient_middle_color),
                            colorResource(id = R.color.gradient_end_color)
                        )
                    ))
                    .padding(16.dp)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(workoutList) { workout ->
                        WorkoutCard(
                            level = workout.level,
                            title = workout.title,
                            equipment = workout.equipment,
                            time = workout.time,
                            image = workout.image,navController
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun WorkoutCard(level: String, title: String, equipment: String, time: String, image: Int, navController: NavController) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Text(
                    text = level,
                    color = Color(color = 0xFF93291E),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = equipment,
                    color = Color.White
                )
                Text(
                    text = time,
                    color = Color.White
                )
            }
            Button(
                onClick = {navController.navigate(Screens.Exercise.route)},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFED213A)),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            ) {
                Text("Try It")
            }
        }
    }
}

// Data class for workout information
data class Workout(val level: String, val title: String, val equipment: String, val time: String, val image: Int)

// Sample list of workouts
val workoutList = listOf(
    Workout("Advanced Level", "Strong and Big Chest", "Full Equipment", "Total time: 45 minutes", R.drawable.bakichest),
    Workout("Beginner Level", "Back Workout", "Full Equipment", "Total time: 55 minutes", R.drawable.bakiback),
    Workout("Advanced Level", "The Total Attack", "Basic Equipment", "Total time: 60 minutes", R.drawable.bakiattack)
)