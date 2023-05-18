package com.example.demo_jp_compose

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_jp_compose.models.Message
import com.example.demo_jp_compose.models.Recipe
import com.example.demo_jp_compose.models.SampleData
import com.example.demo_jp_compose.ui.theme.Demo_JP_ComposeTheme

val recipeList = listOf(
    Recipe(R.mipmap.ic_ajolotl_foreground, "Receta Uno", listOf("Ingrediente uno", "Ingrediente dos","Ingrediente tres","Ingrediente cuatro")),
    Recipe(R.mipmap.ic_desert_foreground, "Receta Dos", listOf("Ingrediente uno", "Ingrediente dos","Ingrediente tres","Ingrediente cuatro")),
    Recipe(R.mipmap.ic_ajolotl_foreground, "Receta Tres", listOf("Ingrediente uno", "Ingrediente dos","Ingrediente tres","Ingrediente cuatro")),
    Recipe(R.mipmap.ic_desert_foreground, "Receta Cuatro", listOf("Ingrediente uno", "Ingrediente dos","Ingrediente tres","Ingrediente cuatro")))


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Demo_JP_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    color = MaterialTheme.colors.background
                ) {


                    //MessageCard(Message("Android", "Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose "))
                    Row() {
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Button 1 ")
                        }
                        Spacer(modifier = Modifier.padding(16.dp))
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Button 1 ")
                        }
                    }
                    Column() {
                        Greeting("DemoJPCompose")
                        RecipeColumnList(recipeList = recipeList)
                        Conversation(SampleData.conversationSample)
                    }
                }
            }
        }
    }
}

@Preview(
    name = "Light Mode",
    //backgroundColor = 0xFF00FF00,
    //widthDp = 50,
    //heightDp = 50
)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    //backgroundColor = 0xFF00FF00,
    //widthDp = 50,
    //heightDp = 50
)
@Composable
fun DefaultPreview() {
    Demo_JP_ComposeTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            color = MaterialTheme.colors.background
        ) {
            RecipeColumnList(recipeList = recipeList)
            RecipeCard(recipeList[0], onRecipeClick = {})

            //MessageCard(Message("Android", "Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose "))
            /*Column() {
                Greeting("DemoJPCompose")
                //DemoColumnas()
                Conversation(SampleData.conversationSample)
            }*/
        }
    }
}

@Composable
fun RecipeCard(reciped: Recipe, onRecipeClick : (Recipe)-> Unit) {
    val miImage = painterResource(R.mipmap.ic_ajolotl_foreground)
    Card(shape = RoundedCornerShape(8.dp), elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onRecipeClick(reciped) }){
        Column(modifier = Modifier.padding(8.dp)) {
            val imageModifier = Modifier
                .requiredHeight(150.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
            Image(painter = miImage, modifier = imageModifier, contentScale = ContentScale.Crop, contentDescription = "Content image" )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(text = reciped.title, style = MaterialTheme.typography.h6)
            for(ingredient in reciped.ingredientes){
                Text(text = "*$ingredient", style = MaterialTheme.typography.body2)
            }
        }


    }
}

@Composable
fun RecipeColumnList(recipeList: List<Recipe>) {
    LazyRow{                // MODO HORIZONTAL
        //LazyColumn{       // MODO VERTICAL
        items(recipeList){ recipe ->
            RecipeCard(reciped = recipe, onRecipeClick = {
                Log.d("Recipe", "RecipeColumnList: ${it.title}")
            })
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    Spacer(modifier = Modifier.padding(64.dp))
    Text(
        modifier = Modifier.clickable{
            Toast.makeText(context,"texto clicleable", Toast.LENGTH_LONG ).show()
        },
        text = "Hello $name!"
    )
    Spacer(modifier = Modifier.padding(4.dp))
    Box(Modifier.background(Color.LightGray)) {
        Text("Texto Box")
    }
}


@Composable
fun MessageCard(msg: Message) {
    //Spacer(modifier = Modifier.padding(32.dp))
    Row(modifier = Modifier.padding(all = 0.dp)) {
        Image(
            painter = painterResource(R.mipmap.ic_desert_foreground),
            contentDescription = "Contact profile picture",
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                // Set image size
                .size(108.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                //.clip(shape = RoundedCornerShape(8.dp))
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.surface,
        )

        // We toggle the isExpanded variable when we click on this Column
        Column(
            horizontalAlignment  = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(all = 8.dp)
                .clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                textAlign = TextAlign.Justify,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}


