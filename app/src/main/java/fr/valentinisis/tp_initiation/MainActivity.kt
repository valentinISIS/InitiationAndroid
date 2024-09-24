package fr.valentinisis.tp_initiation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import fr.valentinisis.tp_initiation.ui.theme.Tp_InitiationTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tp_InitiationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
                    Screen(windowSizeClass)
                }
            }
        }
    }
}

@Serializable class HomeDestination
@Serializable class ProfilDestination

@Composable
fun Screen(classes: WindowSizeClass){
    val classeLargeur = classes.windowWidthSizeClass

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeDestination()){
        composable<HomeDestination> {
            if  (WindowWidthSizeClass.COMPACT == classeLargeur) {
                HomeCompact(navController = navController)
            }
            else
            {
                HomeNotCompact(navController = navController)
            }
        }
        composable<ProfilDestination> {
            if  (WindowWidthSizeClass.COMPACT == classeLargeur) {
                ProfilCompact()
            }
            else
            {
                ProfilNotCompact()
            }
        }
    }
}