package EjercicioArticulo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejerciciointroduccion.R
import com.example.ejerciciointroduccion.ui.theme.EjercicioIntroduccionTheme

@Composable
fun EjercicioArticulo(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    val title: String = stringResource(R.string.title)
    val subtitle: String = stringResource(R.string.subtitle)
    val paragraph: String = stringResource(R.string.paragraph)

    Scaffold() { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            Image(
                painter = image,
                contentDescription = null,
                Modifier.fillMaxWidth()
            )

            Text(
                text = title,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = subtitle,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )

            Text(
                text = paragraph,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}


@Preview(showBackground = true/*, locale = "es"*/)
@Composable
fun ArticuloPreview() {
    EjercicioIntroduccionTheme {
        EjercicioArticulo()
    }
}