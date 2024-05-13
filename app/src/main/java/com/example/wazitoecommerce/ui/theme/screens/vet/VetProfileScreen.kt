package com.example.wazitoecommerce.ui.theme.screens.vet

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.navigation.APPOINTMENT_URL
import com.example.wazitoecommerce.ui.theme.BlueStart
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VetProfileScreen(navController: NavHostController) {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val mContext = LocalContext.current

        //End of TopAppBar


        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            val mContext = LocalContext.current
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .horizontalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Featured",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    color = Color.Black
                )

                Spacer(
                    modifier = Modifier
                        .height(60.dp)
                        .width(30.dp)

                )

                Text(
                    text = "New",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp
                )



            }
            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Row(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .horizontalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "120 Products",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )

                    Spacer(
                        modifier = Modifier
                            .height(10.dp)
                            .width(190.dp)

                    )

                    Text(
                        text = "popular",
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


            //Start of Row1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                //Star of column 1
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.vettdog),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            fontSize = 10.sp,
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column1


                //Star of column 2
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.docta),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column2

            }
            //End of row

            Spacer(modifier = Modifier.height(10.dp))

            //Start of Row1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                //Star of column 1
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.dogdoctor),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column1


                //Star of column 2
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.doct),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column2

            }
            //End of row

            Spacer(modifier = Modifier.height(10.dp))

            //Start of Row1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                //Star of column 1
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.dogdoctor),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column1


                //Star of column 2
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.doct),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column2

            }
            //End of row

            Spacer(modifier = Modifier.height(10.dp))
            //Start of Row1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                //Star of column 1
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.vettdog),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column1


                //Star of column 2
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.docta),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column2

            }
            //End of row

            Spacer(modifier = Modifier.height(10.dp))

            //Start of Row1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                //Star of column 1
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.dogdoctor),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column1


                //Star of column 2
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.doct),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column2

            }
            //End of row

            Spacer(modifier = Modifier.height(10.dp))
            //Start of Row1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                //Star of column 1
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.vettdog),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column1


                //Star of column 2
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.docta),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column2

            }
            //End of row

            Spacer(modifier = Modifier.height(10.dp))
            //Start of Row1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                //Star of column 1
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.vettdog),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column1


                //Star of column 2
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(160.dp)
                ) {


                    Card {
                        var expanded by remember { mutableStateOf(false) }
                        Column(Modifier.clickable { expanded = !expanded }) {
                            Image(
                                painter = painterResource(id = R.drawable.docta),
                                contentDescription = "d",
                            )

                            this@Card.AnimatedVisibility(expanded) {
                                Column {
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Dr.Linda Bett",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = "A certified Vet with an Approved PhD",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 30.dp)
                                    )




                                    Row {

                                        IconButton(onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0799822665".toUri()
                                            mContext.startActivity(callIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = "Call",
                                                Modifier
                                                    .size(20.dp)
                                                    .padding(start = 2.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        IconButton(onClick = {
                                            val shareIntent = Intent(Intent.ACTION_SEND)
                                            shareIntent.type = "text/plain"
                                            shareIntent.putExtra(
                                                Intent.EXTRA_EMAIL,
                                                arrayOf("dmaengwe8@gmail.com")
                                            )
                                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                            shareIntent.putExtra(
                                                Intent.EXTRA_TEXT,
                                                "Hello, this is the email body"
                                            )
                                            mContext.startActivity(shareIntent)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = "Email",
                                                Modifier.size(20.dp),
                                                BlueStart
                                            )

                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 2.dp, top = 10.dp)
                                                .clickable { navController.navigate(APPOINTMENT_URL) },
                                            text = "Appointment ",
                                            color = Color.Blue
                                        )


                                    }
                                }
                            }

                        }

                    }


                }
                //End of  Column2

            }
            //End of row








        }







    }


}


@Preview(showBackground = true)
@Composable
fun VetProfileScreenPreview() {
    WazitoECommerceTheme {
        VetProfileScreen(navController = rememberNavController())
    }
}