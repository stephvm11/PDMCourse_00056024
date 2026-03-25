package EjercicioIntro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejerciciointroduccion.ui.theme.EjercicioIntroduccionTheme

@Composable
fun Ejercicio1(modifier: Modifier = Modifier) {
    Column() {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Ejemplo 1"
            )
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Row() {
                Box(
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Ejemplo 2"
                    )
                }
                Box(
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .background(Color.Green),
                    contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        text = "Ejemplo 3"
                    )
                }
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = "Ejemplo 4"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Ejercicio1Preview() {
    EjercicioIntroduccionTheme {
        Ejercicio1()
    }
}