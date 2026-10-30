package br.edu.fatecgarca.determinantessimplex.navigation

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Det2 : Screen("det2")
    object Det3 : Screen("det3")
    object Det4 : Screen("det4")
    object Simplex : Screen("simplex")
}
