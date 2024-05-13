package com.example.wazitoecommerce.ui.theme.screens.pet

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme


@Composable
fun PetProfileScreen(navController: NavHostController){


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box (modifier = Modifier.align(Alignment.Start)
        ){

            val infiniteTransition = rememberInfiniteTransition(label = "")

            val heartSize by infiniteTransition.animateFloat(
                initialValue = 100.0f,
                targetValue = 250.0f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        800,
                        delayMillis = 100,
                        easing = FastOutLinearInEasing
                    ),
                    repeatMode = RepeatMode.Reverse
                ), label = ""
            )
            Image(
                painter = painterResource(R.drawable.dog),

                contentDescription = "heart",
                modifier = Modifier
                    .size(heartSize.dp)
            )
        }

    }


}





@Preview(showBackground = true)
@Composable
fun PetProfileScreenPreview() {
    WazitoECommerceTheme {
        PetProfileScreen(navController = rememberNavController())
    }
}
