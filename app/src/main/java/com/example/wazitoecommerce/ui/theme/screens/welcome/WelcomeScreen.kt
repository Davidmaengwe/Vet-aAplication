package com.example.wazitoecommerce.ui.theme.screens.welcome


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.navigation.LOGIN_URL
import com.example.wazitoecommerce.ui.theme.BlueStart
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme
import com.example.wazitoecommerce.ui.theme.screens.gothicA1


@Composable
fun WelcomeScreen(navController: NavHostController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
    ){val navigationController = rememberNavController()





        Spacer(modifier = Modifier.height(100.dp))

        Box (modifier = Modifier
            .fillMaxWidth()
            .height(390.dp),
            contentAlignment = Alignment.Center)
        {
            Image(
                painter = painterResource(id = R.drawable.welcome),
                contentDescription = "Car",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop

            )


        }

        Text(
            text = "For the health and ",
            modifier = Modifier.padding(start = 100.dp),
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontFamily = gothicA1, fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp
        )

        Text(
            text = "care of your Pet ",
            modifier = Modifier.padding(start = 100.dp),
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontFamily = gothicA1, fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(20.dp))







        Spacer(modifier = Modifier.height(40.dp))




        Card (
            modifier = Modifier
                .height(60.dp)
                .width(60.dp)
                .align(Alignment.CenterHorizontally)
                .clickable { navController.navigate(LOGIN_URL) }
                .clip(CircleShape),
            colors = CardDefaults.cardColors(
                BlueStart
            )
        ){
           Text(text = ">>",
               color = Color.White,
               modifier = Modifier.padding(top = 12.dp, start = 17.dp),
               fontFamily = gothicA1, fontWeight = FontWeight.SemiBold,
               fontSize = 26.sp
               )


        }




  }

}


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WazitoECommerceTheme {
        WelcomeScreen(navController = rememberNavController())
    }
}