package AdministradorTareas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejerciciointroduccion.R
import com.example.ejerciciointroduccion.ui.theme.EjercicioIntroduccionTheme

@Composable
fun EjercicioAdmin(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    val line1: String = stringResource(R.string.sentence1)
    val line2: String = stringResource(R.string.sentence2)
    Scaffold() { paddingValues ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Image(
                painter = image,
                contentDescription = null
            )
            Text(
                text = line1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = line2,
                fontSize = 16.sp
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun AdminTareasPreview() {
    EjercicioIntroduccionTheme {
        EjercicioAdmin()
    }
}