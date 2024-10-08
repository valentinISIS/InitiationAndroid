package fr.valentinisis.tp_initiation

import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import fr.valentinisis.tp_initiation.ui.theme.Tp_InitiationTheme

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun HomeCompact(modifier: Modifier = Modifier, navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        profilImage()
        name()
        infos()
        contact()
        start(navController = navController)
    }
}

@Composable
fun HomeNotCompact(modifier: Modifier = Modifier, navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                profilImage()
                name()
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                infos()
                contact()
                start(navController = navController)
            }
        }
    }
}

@Composable
fun profilImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.panda) ,
        contentDescription = "profil Image",
        contentScale = ContentScale.Crop,
        modifier= Modifier
            .padding(15.dp)
            .size(200.dp)
            .clip(CircleShape)
    )
}

@Composable
fun name(modifier: Modifier = Modifier) {
    Text(
        text = "Valentin Beaumelle",
        fontSize = 30.sp,
        modifier= Modifier.padding(15.dp)
    )
}

@Composable
fun infos(modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier.padding(40.dp))
    {
        Text(
            text = "Etudiant ingénieur en e-santé",
            fontSize = 15.sp
        )
        Text(
            text = "Ecole d'ingénieur ISIS, INU Champolion",
            fontSize = 15.sp
        )
    }
}


@Composable
fun contact(modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier.padding(40.dp))
    {
        Text(
            text = "valentin.beaumelle@gmail.com",
            fontSize = 15.sp
        )
        Text(
            text = "https://github.com/valentinISIS",
            fontSize = 15.sp
        )
    }
}

@Composable
fun start(modifier: Modifier = Modifier, navController: NavController){
    Button(
        onClick = { navController.navigate(ProfilDestination()) },
        Modifier.padding(40.dp))
    {
        Text(text = "Démarrer")
    }
}