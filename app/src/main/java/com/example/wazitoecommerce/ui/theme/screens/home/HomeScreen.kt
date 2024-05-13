package com.example.wazitoecommerce.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Paragliding
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Paragliding
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Receipt
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.navigation.APPOINTMENT_URL
import com.example.wazitoecommerce.navigation.MEDICAL_URL
import com.example.wazitoecommerce.navigation.NOTIFICATION_URL
import com.example.wazitoecommerce.navigation.SEARCH_URL
import com.example.wazitoecommerce.navigation.SETTING_URL
import com.example.wazitoecommerce.navigation.SIGNUP_URL
import com.example.wazitoecommerce.navigation.VETPROFILE_URL
import com.example.wazitoecommerce.ui.theme.BlueStart
import com.example.wazitoecommerce.ui.theme.DarkBlack
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme
import com.example.wazitoecommerce.ui.theme.screens.gothicA1


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        var selected by rememberSaveable  { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar(
                    containerColor = Color.Transparent,
                ) {

                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                                {

                                }
                                },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title,
                                        tint = BlueStart)

                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            },

                        )
                    }
                }
            },



            //Content Section
            content = @Composable{

                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    modifier = Modifier.fillMaxSize()
                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 10.dp, end = 10.dp,
                                top = 10.dp
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Row {

                        Text(
                            text = "Vet",
                            fontFamily = gothicA1, fontWeight = FontWeight.ExtraBold,
                            fontSize = 22.sp,
                            color = BlueStart

                        )
                        Text(
                            text = "Care",
                            fontFamily = gothicA1, fontWeight = FontWeight.ExtraBold,
                            fontSize = 22.sp,
                            color = DarkBlack

                        )
                    }

                        val infiniteTransition = rememberInfiniteTransition()

                        // Creates a child animation of float type as a part of the [InfiniteTransition].
                        val scale by infiniteTransition.animateFloat(
                            initialValue = 0f,
                            targetValue = 360f,
                            animationSpec = infiniteRepeatable(
                                // Infinitely repeating a 1000ms tween animation using default easing curve.
                                animation = tween(2500),
                                // After each iteration of the animation (i.e. every 1000ms), the animation will
                                // start again from the [initialValue] defined above.
                                // This is the default [RepeatMode]. See [RepeatMode.Reverse] below for an
                                // alternative.
                                repeatMode = RepeatMode.Restart
                            ), label = ""
                        )



                        Icon(
                            modifier = Modifier
                                .rotate(scale)
                                .clickable { navController.navigate(SETTING_URL) }
                                .size(20.dp),
                            painter = painterResource(R.drawable.settings),
                            contentDescription = stringResource(id = R.string.app_name),
                            tint = BlueStart,

                        )


                    }


                    Spacer(modifier = Modifier.height(10.dp))


                    ElevatedCard(

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp,

                        ),

                        modifier = Modifier
                            .size(width = 370.dp, height = 190.dp)
                            .padding(start = 10.dp, end = 10.dp)
                            .clickable {
                                navController.navigate(SEARCH_URL)
                            },
                        colors = CardDefaults.cardColors(
                            BlueStart
                        )
                    ) {
                        Row (
                            modifier = Modifier
                                .padding(end = 25.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ){
                            Column(
                                modifier = Modifier
                                    .padding(start = 30.dp, top = 30.dp),

                            ) {
                                Text(
                                    text = "Find Nearest Clinics & ",
                                    modifier = Modifier,
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    fontFamily = gothicA1, fontWeight = FontWeight.SemiBold,
                                    fontSize = 22.sp
                                )
                                Text(
                                    text = "Veterinarians for",
                                    modifier = Modifier,
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    fontFamily = gothicA1, fontWeight = FontWeight.SemiBold,
                                    fontSize = 22.sp
                                )
                                Text(
                                    text = "Your Pet",
                                    modifier = Modifier,
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    fontFamily = gothicA1, fontWeight = FontWeight.SemiBold,
                                    fontSize = 22.sp
                                )


                            }

                            Image(
                                painter = painterResource(id = R.drawable.vetdog),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(170.dp)

                            )


                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Column (
                        modifier = Modifier
                            .padding(start = 15.dp)
                    ){
                        Text(
                            text = "Quick Access ",
                            modifier = Modifier,
                            color = BlueStart,
                            textAlign = TextAlign.Center,
                            fontFamily = gothicA1, fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp)

                    }


                    Spacer(modifier = Modifier.height(10.dp))


                    Column (
                        modifier = Modifier
                            .padding(start = 25.dp)
                    ){



                        Row(
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .fillMaxWidth(),
                        ) {


                            ElevatedCard(

                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 6.dp,

                                    ),



                                modifier = Modifier
                                    .size(width = 150.dp, height = 170.dp)
                                    .clickable {
                                        navController.navigate(VETPROFILE_URL)
                                    },

                                )
                            {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally

                                ) {


                                    Card (
                                        colors = CardDefaults.cardColors(
                                            Color.White
                                        )
                                    ){


                                        Image(
                                            painter = painterResource(id = R.drawable.veterinary),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .width(116.dp)
                                                .height(120.dp)

                                        )

                                        Text(
                                            text = " Vets ",
                                            modifier = Modifier
                                                .padding(start = 45.dp),
                                            color = BlueStart,
                                            textAlign = TextAlign.Center,
                                            fontFamily = gothicA1, fontWeight = FontWeight.SemiBold,
                                            fontSize = 11.sp)




                                    }
                                }



                            }

                            Spacer(modifier = Modifier.width(15.dp))


                            ElevatedCard(

                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 6.dp,

                                    ),



                                modifier = Modifier
                                    .size(width = 150.dp, height = 170.dp)
                                    .clickable {
                                        navController.navigate(NOTIFICATION_URL)
                                    },

                                )
                            {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally

                                ) {


                                    Card (
                                        colors = CardDefaults.cardColors(
                                            BlueStart
                                        )
                                    ){


                                        Image(
                                            painter = painterResource(id = R.drawable.vaccine1),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .width(116.dp)
                                                .height(120.dp)

                                        )

                                        Text(
                                            text = " Vaccines ",
                                            modifier = Modifier.padding(start = 35.dp),
                                            color = Color.White,
                                            textAlign = TextAlign.Center,
                                            fontFamily = gothicA1, fontWeight = FontWeight.SemiBold,
                                            fontSize = 11.sp)




                                    }
                                }



                            }


                        }



                        Spacer(modifier = Modifier.height(15.dp))


                        Row(
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .fillMaxWidth(),
                        ) {


                            ElevatedCard(

                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 6.dp,

                                    ),



                                modifier = Modifier
                                    .size(width = 150.dp, height = 170.dp)
                                    .clickable {
                                        navController.navigate(APPOINTMENT_URL)
                                    },

                                )
                            {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally

                                ) {


                                    Card (
                                        colors = CardDefaults.cardColors(
                                            BlueStart
                                        )
                                    ){


                                        Image(
                                            painter = painterResource(id = R.drawable.veterinarian),
                                            contentDescription = null,
                                            modifier = Modifier.padding(6.dp)
                                                .width(116.dp)
                                                .height(120.dp)

                                        )

                                        Text(
                                            text = " Book Appiontment ",
                                            modifier = Modifier.padding(start = 20.dp),
                                            color = Color.White,
                                            textAlign = TextAlign.Center,
                                            fontFamily = gothicA1, fontWeight = FontWeight.SemiBold,
                                            fontSize = 11.sp)




                                    }
                                }



                            }
                            Spacer(modifier = Modifier.width(15.dp))


                            ElevatedCard(

                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 6.dp,

                                    ),



                                modifier = Modifier
                                    .size(width = 150.dp, height = 170.dp)
                                    .clickable {
                                        navController.navigate(MEDICAL_URL)
                                    },

                                )
                            {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally

                                ) {


                                    Card (
                                        colors = CardDefaults.cardColors(
                                            Color.White
                                        )
                                    ){


                                        Image(
                                            painter = painterResource(id = R.drawable.dogl),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .width(116.dp)
                                                .height(120.dp)

                                        )

                                        Text(
                                            text = " My Pet ",
                                            modifier = Modifier.padding(start = 40.dp),
                                            color = BlueStart,
                                            textAlign = TextAlign.Center,
                                            fontFamily = gothicA1, fontWeight = FontWeight.SemiBold,
                                            fontSize = 11.sp)




                                    }
                                }



                            }


                        }




                        Spacer(modifier = Modifier.height(15.dp))






                    }










                }



            }

        )

    }
}

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route= "home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),


    BottomNavItem(
        title = "Appointment",
        route = "appointment",
        selectedIcon = Icons.Filled.Receipt,
        unselectedIcon = Icons.Outlined.Receipt,
        hasNews = true,
        badges = 5
    ),

    BottomNavItem(
        title = "My Pet",
        route = "medical",
        selectedIcon = Icons.Filled.Paragliding,
        unselectedIcon = Icons.Outlined.Paragliding,
        hasNews = false,
        badges = 0
    ),
    BottomNavItem(
        title = "Vets",
        route = "vet",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        hasNews = false,
        badges = 0
    ),


    )




data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)



@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    WazitoECommerceTheme {
        HomeScreen(navController = rememberNavController())
    }
}