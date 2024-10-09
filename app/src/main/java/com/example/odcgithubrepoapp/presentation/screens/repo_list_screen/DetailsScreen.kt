package com.example.odcgithubrepoapp.presentation.screens.repo_list_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.odcgithubrepoapp.R
import com.example.odcgithubrepoapp.presentation.common_component.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details(modifier: Modifier = Modifier) {
    val fadeDuration = 1000
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            AppBar(
                title = R.string.details_app_bar_title,
                showBackButton = true
                , modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            )
        }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = "https//...").apply {
                            crossfade(fadeDuration)
                            placeholder(R.drawable.google_logo)
                            error(R.drawable.google_logo)
                        }.build()
                ), contentDescription = null,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .size(200.dp))

            Text(text = stringResource(R.string.language) , style = MaterialTheme.typography.titleLarge )
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                RepoDetailsInfo(imageResId = R.drawable.ic_star, stringResId =  R.string.start_number)
                RepoDetailsInfo(imageResId = R.drawable.ic_star, stringResId =  R.string.start_number)
                RepoDetailsInfo(imageResId = R.drawable.ic_star, stringResId =  R.string.start_number)
            }
            Text(text = stringResource(id = R.string.details_info_screen_description))
            Button(onClick = { /*TODO*/ }
                ,modifier = Modifier.clip(MaterialTheme.shapes.large)

            ) {


            }
        }

    }
}

@Preview
@Composable
private fun DetailsScreenContent() {
    Details()
}

@Composable
fun RepoDetailsInfo(modifier: Modifier = Modifier,imageResId :Int,stringResId:Int ) {
    Row {
        Text(text = stringResource(stringResId) , style = MaterialTheme.typography.titleMedium )
        Image(painter = rememberAsyncImagePainter(model =
        ImageRequest.Builder(LocalContext.current).data("https://").apply {
            placeholder(imageResId)
            error(imageResId)
        }.build()
        ), contentDescription = null,modifier = Modifier
            .padding(8.dp)
            .size(10.dp))
    }


}
