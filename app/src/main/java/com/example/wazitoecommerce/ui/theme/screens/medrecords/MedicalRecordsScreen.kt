package com.example.wazitoecommerce.ui.theme.screens.medrecords

import android.annotation.SuppressLint
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Paragliding
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Paragliding
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Receipt
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
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
import com.example.wazitoecommerce.navigation.HOME_URL
import com.example.wazitoecommerce.navigation.SEARCH_URL
import com.example.wazitoecommerce.navigation.SETTING_URL
import com.example.wazitoecommerce.ui.theme.BlueStart
import com.example.wazitoecommerce.ui.theme.LightGreen1
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme
import com.example.wazitoecommerce.ui.theme.screens.gothicA1
import com.example.wazitoecommerce.ui.theme.screens.home.BottomNavItem



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MedicalRecordsScreen(navController: NavHostController){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        //TopAppBar
        TopAppBar(
            title = { Text(
                text = "My Pets",
                fontFamily = gothicA1, fontWeight = FontWeight.ExtraBold,
                fontSize = 17.sp,
                color = Color.White

            ) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(BlueStart),
            navigationIcon = {
                IconButton(onClick = { navController.navigate(HOME_URL) },) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "ArrowBack",
                        tint = Color.White
                    )

                }
            },
            actions = {
                IconButton(onClick = { navController.navigate(SEARCH_URL) }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search",
                        tint = Color.White
                    )

                }
                Spacer(modifier = Modifier.height(10.dp))

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
                        .padding(end = 10.dp)
                        .rotate(scale)
                        .clickable { navController.navigate(SETTING_URL) }
                        .size(20.dp),
                    painter = painterResource(R.drawable.settings),
                    contentDescription = stringResource(id = R.string.app_name),
                    tint = Color.White,

               )





    }
        )
        //End of TopAppBar
        var selected by rememberSaveable  { mutableIntStateOf(2) }
        Scaffold(
            bottomBar = {
                NavigationBar(
                    containerColor = Color.White
                ){
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route){

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
                                        tint = BlueStart
                                    )
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },



            //Content Section
            content = @Composable {

                Column {


                    Spacer(modifier = Modifier.height(6.dp))

                    // Start of Card
                    Card(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp)
                            .width(350.dp)
                            .height(220.dp),
                    ) {

                        Column {
                            //Image to fill the entire width of the card
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .width(350.dp)
                                    .height(220.dp),
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.dog1),
                                    contentDescription = "dog1",
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )

                                //text

                                Text(
                                    text = "Get your pet vaccinated",
                                    fontFamily = gothicA1, fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding(start = 225.dp , top = 70.dp)

                                )

                                //text


                            }


                        }


                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row {
                        Row(
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .horizontalScroll(rememberScrollState())
                        ) {
                            Text(
                                text = "Recent Activity",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier
                                    .height(10.dp)
                                    .width(170.dp)

                            )

                            Text(
                                text = "Scroll",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontSize = 15.sp
                            )


                            Spacer(
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(10.dp)

                            )

                        }


                    }


                    Spacer(modifier = Modifier.height(5.dp))


                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState())
                    ) {
                        //Start of Row1


                        // Start of Column1
                        Column(
                            modifier = Modifier
                                .padding(start = 20.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .height(130.dp)
                                    .width(160.dp)

                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                )
                                {
                                    Image(
                                        painter = painterResource(id = R.drawable.dogblack),
                                        contentDescription = "d",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(10.dp))


                        }
                        //End of  Column1


                        // Start of Column1
                        Column(modifier = Modifier.padding(start = 20.dp)) {
                            Card(
                                modifier = Modifier
                                    .height(130.dp)
                                    .width(160.dp)

                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                )
                                {
                                    Image(
                                        painter = painterResource(id = R.drawable.dogshock),
                                        contentDescription = "d",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(10.dp))


                        }
                        //End of  Column1


                        // Start of Column1
                        Column(modifier = Modifier.padding(start = 20.dp)) {
                            Card(
                                modifier = Modifier
                                    .height(130.dp)
                                    .width(160.dp)

                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                )
                                {
                                    Image(
                                        painter = painterResource(id = R.drawable.dog1),
                                        contentDescription = "d",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(10.dp))


                        }
                        //End of  Column1


                        // Start of Column1
                        Column(modifier = Modifier.padding(start = 20.dp)) {
                            Card(
                                modifier = Modifier
                                    .height(130.dp)
                                    .width(160.dp)

                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                )
                                {
                                    Image(
                                        painter = painterResource(id = R.drawable.dogblack),
                                        contentDescription = "d",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(8.dp))


                        }
                        //End of  Column1


                        // Start of Column1
                        Column(modifier = Modifier.padding(start = 20.dp)) {
                            Card(
                                modifier = Modifier
                                    .height(130.dp)
                                    .width(160.dp)

                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                )
                                {
                                    Image(
                                        painter = painterResource(id = R.drawable.dogcute),
                                        contentDescription = "d",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }


                        }
                        //End of  Column1


                    }

                    Spacer(modifier = Modifier.height(1.dp))
                    Row (modifier = Modifier
                        .padding(start = 20.dp)
                    ){
                        Text(
                            text = "Pet Vaccine Status",
                            fontFamily = gothicA1, fontWeight = FontWeight.SemiBold,
                            fontSize = 17.sp,
                            color = Color.Black

                        )
                    }
                    Spacer(modifier = Modifier.height(3.dp))

                    Column (
                        modifier = Modifier.verticalScroll(rememberScrollState())
                    ){

                        //CARD1
                        Box (contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .padding(start = 10.dp, end = 10.dp)
                        ){
                            Row {

                                Card (modifier = Modifier
                                    .fillMaxWidth()
                                    .height(90.dp),
                                    colors = CardDefaults.cardColors(
                                        Color.Transparent

                                    )
                                ){
                                    Row {
                                        Image(
                                            painter = painterResource(id = R.drawable.dogblack),
                                            contentDescription = "register",
                                            modifier = Modifier
                                                .padding(10.dp)
                                                .size(60.dp)
                                                .clip(shape = CircleShape),
                                            contentScale = ContentScale.Crop
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))

                                        Column (
                                            modifier = Modifier.padding(top = 10.dp)
                                        ){
                                            Text(
                                                text = "Koda",
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold,
                                                textAlign = TextAlign.Center
                                            )
                                            Row (
                                                modifier = Modifier
                                                    .padding(end = 10.dp)
                                                    .fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                            ){
                                                Text(
                                                    text = "2 years old",
                                                    fontSize = 20.sp,
                                                    textAlign = TextAlign.Center
                                                )

                                                Text(
                                                    text = "vaccinated",
                                                    fontFamily = gothicA1, fontWeight = FontWeight.ExtraLight,
                                                    fontSize = 15.sp,
                                                    color = LightGreen1

                                                )
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        //END OF CARD1
                        Spacer(modifier = Modifier.height(2.dp))

                        //CARD1
                        Box (contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .padding(start = 10.dp, end = 10.dp)
                        ){
                            Row {

                                Card (modifier = Modifier
                                    .fillMaxWidth()
                                    .height(90.dp),
                                    colors = CardDefaults.cardColors(
                                        Color.Transparent

                                    )
                                ){
                                    Row {
                                        Image(
                                            painter = painterResource(id = R.drawable.dogshock),
                                            contentDescription = "register",
                                            modifier = Modifier
                                                .padding(10.dp)
                                                .size(60.dp)
                                                .clip(shape = CircleShape),
                                            contentScale = ContentScale.Crop
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))

                                        Column (
                                            modifier = Modifier.padding(top = 10.dp)
                                        ){
                                            Text(
                                                text = "Frankie",
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold,
                                                textAlign = TextAlign.Center
                                            )
                                            Row (
                                                modifier = Modifier
                                                    .padding(end = 10.dp)
                                                    .fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                            ){
                                                Text(
                                                    text = "2.5 years old",
                                                    fontSize = 20.sp,
                                                    textAlign = TextAlign.Center
                                                )

                                                Text(
                                                    text = "sick",
                                                    fontFamily = gothicA1, fontWeight = FontWeight.ExtraLight,
                                                    fontSize = 15.sp,
                                                    color = Color.Red

                                                )
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        //END OF CARD1
                        Spacer(modifier = Modifier.height(2.dp))

                        //CARD1
                        Box (contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .padding(start = 10.dp, end = 10.dp)
                        ){
                            Row {

                                Card (modifier = Modifier
                                    .fillMaxWidth()
                                    .height(90.dp),
                                    colors = CardDefaults.cardColors(
                                        Color.Transparent

                                    )
                                ){
                                    Row {
                                        Image(
                                            painter = painterResource(id = R.drawable.catsick),
                                            contentDescription = "register",
                                            modifier = Modifier
                                                .padding(10.dp)
                                                .size(60.dp)
                                                .clip(shape = CircleShape),
                                            contentScale = ContentScale.Crop
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))

                                        Column (
                                            modifier = Modifier.padding(top = 10.dp)
                                        ){
                                            Text(
                                                text = "Nox",
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold,
                                                textAlign = TextAlign.Center
                                            )
                                            Row (
                                                modifier = Modifier
                                                    .padding(end = 10.dp)
                                                    .fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                            ){
                                                Text(
                                                    text = "1 year old",
                                                    fontSize = 20.sp,
                                                    textAlign = TextAlign.Center
                                                )

                                                Text(
                                                    text = "vaccination date 5/25/23",
                                                    fontFamily = gothicA1, fontWeight = FontWeight.ExtraLight,
                                                    fontSize = 10.sp,
                                                    color = Color.Blue

                                                )
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        //END OF CARD1

                        Spacer(modifier = Modifier.height(2.dp))

                        //CARD1
                        Box (contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .padding(start = 10.dp, end = 10.dp)
                        ){
                            Row {

                                Card (modifier = Modifier
                                    .fillMaxWidth()
                                    .height(90.dp),
                                    colors = CardDefaults.cardColors(
                                        Color.Transparent

                                    )
                                ){
                                    Row {
                                        Image(
                                            painter = painterResource(id = R.drawable.dogsimple),
                                            contentDescription = "register",
                                            modifier = Modifier
                                                .padding(10.dp)
                                                .size(60.dp)
                                                .clip(shape = CircleShape),
                                            contentScale = ContentScale.Crop
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))

                                        Column (
                                            modifier = Modifier.padding(top = 10.dp)
                                        ){
                                            Text(
                                                text = "Koda",
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold,
                                                textAlign = TextAlign.Center
                                            )
                                            Row (
                                                modifier = Modifier
                                                    .padding(end = 10.dp)
                                                    .fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                            ){
                                                Text(
                                                    text = "2 years old",
                                                    fontSize = 15.sp,
                                                    textAlign = TextAlign.Center
                                                )

                                                Text(
                                                    text = "vaccinated",
                                                    fontFamily = gothicA1, fontWeight = FontWeight.ExtraLight,
                                                    fontSize = 14.sp,
                                                    color = LightGreen1

                                                )
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        //END OF CARD1
                        Spacer(modifier = Modifier.height(2.dp))

                        //CARD1
                        Box (contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .padding(start = 10.dp, end = 10.dp)
                        ){
                            Row {

                                Card (modifier = Modifier
                                    .fillMaxWidth()
                                    .height(90.dp),
                                    colors = CardDefaults.cardColors(
                                        Color.Transparent

                                    )
                                ){
                                    Row {
                                        Image(
                                            painter = painterResource(id = R.drawable.catpeep),
                                            contentDescription = "register",
                                            modifier = Modifier
                                                .padding(10.dp)
                                                .size(60.dp)
                                                .clip(shape = CircleShape),
                                            contentScale = ContentScale.Crop
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))

                                        Column (
                                            modifier = Modifier.padding(top = 10.dp)
                                        ){
                                            Text(
                                                text = "Koda",
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold,
                                                textAlign = TextAlign.Center
                                            )
                                            Row (
                                                modifier = Modifier
                                                    .padding(end = 10.dp)
                                                    .fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                            ){
                                                Text(
                                                    text = "2 years old",
                                                    fontSize = 15.sp,
                                                    textAlign = TextAlign.Center
                                                )

                                                Text(
                                                    text = "vaccinated",
                                                    fontFamily = gothicA1, fontWeight = FontWeight.ExtraLight,
                                                    fontSize = 14.sp,
                                                    color = LightGreen1

                                                )
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        //END OF CARD1
                        Spacer(modifier = Modifier.height(2.dp))

                        //CARD1
                        Box (contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .padding(start = 10.dp, end = 10.dp)
                        ){
                            Row {

                                Card (modifier = Modifier
                                    .fillMaxWidth()
                                    .height(90.dp),
                                    colors = CardDefaults.cardColors(
                                        Color.Transparent

                                    )
                                ){
                                    Row {
                                        Image(
                                            painter = painterResource(id = R.drawable.dogi),
                                            contentDescription = "register",
                                            modifier = Modifier
                                                .padding(10.dp)
                                                .size(60.dp)
                                                .clip(shape = CircleShape),
                                            contentScale = ContentScale.Crop
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))

                                        Column (
                                            modifier = Modifier.padding(top = 10.dp)
                                        ){
                                            Text(
                                                text = "Koda",
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold,
                                                textAlign = TextAlign.Center
                                            )
                                            Row (
                                                modifier = Modifier
                                                    .padding(end = 10.dp)
                                                    .fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                            ){
                                                Text(
                                                    text = "2 years old",
                                                    fontSize = 15.sp,
                                                    textAlign = TextAlign.Center
                                                )

                                                Text(
                                                    text = "vaccinated",
                                                    fontFamily = gothicA1, fontWeight = FontWeight.ExtraLight,
                                                    fontSize = 14.sp,
                                                    color = LightGreen1

                                                )
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        //END OF CARD1






                    }



                }

                Spacer(modifier = Modifier.weight(1f))
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


@Preview(showBackground = true)
@Composable
fun MedicalRecordsScreenPreview() {
    WazitoECommerceTheme {
        MedicalRecordsScreen(navController = rememberNavController())
    }
}