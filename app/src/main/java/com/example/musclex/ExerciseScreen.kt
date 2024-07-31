import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.musclex.Exercise
import com.example.musclex.R

@Composable
fun ExerciseScreen(navController: NavController) {
    val context = LocalContext.current
    var exercises by remember { mutableStateOf(emptyList<Exercise>()) }

    LaunchedEffect(Unit) {
        exercises = listOf(
            Exercise(name = "Push ups", duration = "30s", imageResId = R.drawable.pushups),
            Exercise(name = "Jumping Jack", duration = "45s", imageResId = R.drawable.jumpingjacks),
            Exercise(name = "Skipping", duration = "45s", imageResId = R.drawable.skipping),
            Exercise(name = "Squat", duration = "45s", imageResId = R.drawable.squat),
            Exercise(name = "Arm Raises", duration = "45s", imageResId = R.drawable.raises),
            Exercise(name = "Rest and Drink", duration = "45s", imageResId = R.drawable.rest)
        )
    }

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            colorResource(id = R.color.gradient_start_color),
            colorResource(id = R.color.gradient_middle_color),
            colorResource(id = R.color.gradient_end_color)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush)
            .padding(16.dp)
    ) {
        Text(text = "Exercises", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        exercises.forEachIndexed { index, exercise ->
            ExerciseItem(exercise)
            if (index < exercises.size - 1) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ExerciseItem(exercise: Exercise) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = exercise.imageResId),
            contentDescription = exercise.name,
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = exercise.name, fontSize = 20.sp)
            Text(text = exercise.duration, fontSize = 16.sp, color = Color.Gray)
        }
    }
}