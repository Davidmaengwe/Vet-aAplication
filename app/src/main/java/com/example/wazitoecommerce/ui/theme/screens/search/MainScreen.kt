package com.example.wazitoecommerce.ui.theme.screens.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardVoice
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.models.MainViewModel
import com.example.wazitoecommerce.ui.theme.DarkBlack
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {

    var isSearchActive by rememberSaveable { mutableStateOf(false) }

    val viewModel = MainViewModel()

    //Collecting states from ViewModel
    val searchText by viewModel.searchText.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    val countriesList by viewModel.countriesList.collectAsState()

    Scaffold(
        topBar = {val mContext = LocalContext.current
            SearchBar(
                query = searchText,//text showed on SearchBar
                onQueryChange = viewModel::onSearchTextChange, //update the value of searchText
                onSearch = viewModel::onSearchTextChange, //the callback to be invoked when the input service triggers the ImeAction.Search action
                active = isSearching, //whether the user is searching or not
                onActiveChange = { viewModel.onToogleSearch() }, //the callback to be invoked when this search bar's active state is changed
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                   placeholder = { Text(text = "What do you want to search",
                       color = DarkBlack
                   ) },
                trailingIcon =  {

                    IconButton(onClick = {

                    },) {
                        Icon(
                            imageVector = Icons.Default.KeyboardVoice,
                            contentDescription ="",
                            tint = MaterialTheme.colorScheme.primary,
                        )
                    }
                },

                leadingIcon = {
                    IconButton(
                        onClick = {

                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription ="",
                            tint = MaterialTheme.colorScheme.primary,
                        )
                    }
                },
                colors = SearchBarDefaults.colors(
                    containerColor = Color.Gray
                ),
            )  {
                LazyColumn {
                    items(countriesList) { country ->
                        Text(
                            text = country,
                            modifier = Modifier.padding(
                                start = 8.dp,
                                top = 4.dp,
                                end = 8.dp,
                                bottom = 4.dp)
                        )
                    }
                }
            }
        }
    ) {

    }

}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview(){
    WazitoECommerceTheme {
        MainScreen(navController = rememberNavController())
    }
}


