package co.zsmb.requirektx

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.navArgument
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController,
        startDestination = "home"
    ) {
        composable("home") {
            Home(onSelectNumber = { number -> navController.navigate("detail/$number") })
        }
        composable(
            "detail/{param}",
            arguments = listOf(navArgument("param") { type = NavType.IntType }),
        ) { backStackEntry ->
            val args = backStackEntry.requireArguments()
            val number = args.requireInt("param")
            Detail(number = number, onNavigateBack = { navController.popBackStack() })
        }
    }
}

@Composable
@Preview
fun DetailPreview() {
    Detail(42, {})
}

@Composable
fun Detail(number: Int, onNavigateBack: () -> Unit) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        IconButton(onClick = { onNavigateBack() }, modifier = Modifier.align(Alignment.TopStart)) {
            Icon(Icons.AutoMirrored.Default.ArrowBack, "Back")
        }
        Text("Your number was $number", fontSize = 20.sp)
    }
}

@Composable
@Preview
fun HomePreview() {
    Home(onSelectNumber = {})
}

@Preview
@Composable
fun Home(onSelectNumber: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter a number", fontSize = 24.sp)

        Spacer(Modifier.height(20.dp))

        var inputState by remember { mutableStateOf("") }
        val number = inputState.toIntOrNull()

        TextField(
            value = inputState,
            onValueChange = { inputState = it },
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = { onSelectNumber(number!!) },
            enabled = number != null,
        ) {
            Text("Send")
        }
    }
}

