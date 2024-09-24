package fr.valentinisis.tp_initiation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ProfilCompact(modifier: Modifier = Modifier) {
    Text(
        text = "Mon profil !",
        modifier= Modifier.padding(15.dp)
    )
}

@Composable
fun ProfilNotCompact(modifier: Modifier = Modifier) {
    //TODO
}