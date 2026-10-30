package br.edu.fatecgarca.determinantessimplex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.fatecgarca.determinantessimplex.navigation.Screen
import br.edu.fatecgarca.determinantessimplex.ui.screens.MainScreen
import br.edu.fatecgarca.determinantessimplex.ui.screens.MatrixCalculatorScreen
import br.edu.fatecgarca.determinantessimplex.ui.screens.SimplexScreen
import br.edu.fatecgarca.determinantessimplex.ui.theme.DeterminantesSimplexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            DeterminantesSimplexTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Main.route) {
                    composable(Screen.Main.route) {
                        MainScreen(
                            onNavigateToDet2 = { navController.navigate(Screen.Det2.route) },
                            onNavigateToDet3 = { navController.navigate(Screen.Det3.route) },
                            onNavigateToDet4 = { navController.navigate(Screen.Det4.route) },
                            onNavigateToSimplex = { navController.navigate(Screen.Simplex.route) }
                        )
                    }
                    composable(Screen.Det2.route) {
                        MatrixCalculatorScreen(
                            title = "Determinante 2 x 2",
                            dimension = 2,
                            onBack = { navController.popBackStack() }
                        )
                    }
                    composable(Screen.Det3.route) {
                        MatrixCalculatorScreen(
                            title = "Determinante 3 x 3",
                            dimension = 3,
                            onBack = { navController.popBackStack() }
                        )
                    }
                    composable(Screen.Det4.route) {
                        MatrixCalculatorScreen(
                            title = "Determinante 4 x 4",
                            dimension = 4,
                            onBack = { navController.popBackStack() }
                        )
                    }
                    composable(Screen.Simplex.route) {
                        SimplexScreen(
                            onBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
