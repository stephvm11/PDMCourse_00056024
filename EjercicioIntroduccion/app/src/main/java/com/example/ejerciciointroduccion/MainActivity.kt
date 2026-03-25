package com.example.ejerciciointroduccion

import AdministradorTareas.EjercicioAdmin
import EjercicioArticulo.EjercicioArticulo
import EjercicioCuadrante.EjercicioCuadrante
import EjercicioIntro.Ejercicio1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejerciciointroduccion.ui.theme.EjercicioIntroduccionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjercicioIntroduccionTheme {
                Scaffold() { innerPadding ->
                    Ejercicio1(
                        modifier = Modifier.padding(innerPadding)
//                    EjercicioArticulo(
//                        modifier = Modifier.padding(innerPadding)
//                                EjercicioAdmin(
//                                      modifier = Modifier.padding(innerPadding)
//                                      EjercicioCuadrante(
//                                          modifier = Modifier.padding(innerPadding)

                    )
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    EjercicioIntroduccionTheme {
//        Greeting("Android")
//    }
//}