package EjercicioCuadrante

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat.getColor
import com.example.ejerciciointroduccion.R
import com.example.ejerciciointroduccion.ui.theme.EjercicioIntroduccionTheme

@Composable
fun EjercicioCuadrante(modifier: Modifier = Modifier) {
    val palePurple = colorResource(R.color.pale_purple)
    val babyPurple = colorResource(R.color.baby_purple)
    val softPurple = colorResource(R.color.soft_purple)
    val vibrantPurple = colorResource(R.color.vibrant_purple)
    val text_title: String = stringResource(R.string.text_title)
    val text_p: String = stringResource(R.string.text_p)
    val image_title: String = stringResource(R.string.image_title)
    val image_p: String = stringResource(R.string.image_p)
    val row_title: String = stringResource(R.string.row_title)
    val row_p: String = stringResource(R.string.row_p)
    val column_title: String = stringResource(R.string.column_title)
    val column_p: String = stringResource(R.string.column_p)

    Scaffold() { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
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
                            .background(babyPurple)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = text_title,
                                fontWeight = FontWeight.Bold,
                                modifier = modifier.padding(bottom = 16.dp)
                            )
                            Text(
                                text = text_p, textAlign = TextAlign.Justify
                            )

                        }
                    }
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .background(softPurple)
                            .padding(16.dp), contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = image_title,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                            Text(
                                text = image_p, textAlign = TextAlign.Justify
                            )

                        }
                    }
                }
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .background(vibrantPurple)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = row_title,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                            Text(
                                text = row_p, textAlign = TextAlign.Justify
                            )

                        }
                    }
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .background(palePurple)
                            .padding(16.dp), contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = column_title,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                            Text(
                                text = column_p, textAlign = TextAlign.Justify
                            )

                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CuadrantesPreview() {
    EjercicioIntroduccionTheme {
        EjercicioCuadrante()
    }
}