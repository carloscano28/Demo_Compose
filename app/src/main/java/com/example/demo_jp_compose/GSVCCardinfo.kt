package mx.com.superapp.gssavisualcomponents.uicatalog.compose.buttons

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_jp_compose.R
import com.example.demo_jp_compose.models.Message
import com.example.demo_jp_compose.models.Recipe
import com.example.demo_jp_compose.models.SampleData
import com.example.demo_jp_compose.ui.theme.Demo_JP_ComposeTheme


@Composable
fun GSVCCardInfo(text: String, iconCard: Int, colorCard: Color,onclose:()->Unit
                 ,cardType:Int=0,subText:String="CTA",subText1: String="texto2") {

    Box( modifier=Modifier.clip(shape = RoundedCornerShape(10.dp))
        .background(Color.Transparent)) {

        var size = 57.dp
        var verticalA = Alignment.CenterVertically
        val horizontalA = Arrangement.Start
        var tp = 16

        if (cardType == 1) {
            size = 76.dp
            verticalA = Alignment.Top
            tp = 16
        }

        if (cardType == 2) {
            size = 166.dp
            verticalA = Alignment.Top
            tp = 16
        }

        Row(
            modifier = Modifier
                .height(size)
                .fillMaxWidth()
                .background(colorCard),
            verticalAlignment = verticalA,
            horizontalArrangement = horizontalA
        )
        {
            Image(
                modifier = Modifier.padding(top=tp.dp,start = 16.dp, end = 16.dp, bottom = tp.dp),
                painter = painterResource(iconCard),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Black)
            )
            Column {
                when (cardType) {
                    0 -> {
                        Box(modifier = Modifier.padding(top=19.dp, bottom = 18.dp)
                            .height(20.dp)
                            .background(colorCard)){
                            Text(
                                text = text,
                                color = Color.Black,
                                fontSize = 14.sp,
                                //fontFamily = poppinsFamily
                            )
                        }
                    }
                    1 -> {
                        Box (modifier=Modifier.height(size)
                            .fillMaxWidth()){
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp))
                            {
                                Text(
                                    modifier=Modifier.padding(top=tp.dp),
                                    text = text,
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    //fontFamily = poppinsFamily
                                )
                                Text(
                                    text = subText,
                                    //color = GSVCTextPurple,
                                    fontSize = 14.sp,
                                    //fontFamily = poppinsFamily
                                )
                            }
                            CloseButton(hsize = size, onclose = onclose, padding = 14.dp)
                        }
                    }
                    2 -> {
                        Box(modifier=Modifier.height(size)
                            .fillMaxWidth()) {
                            Column(verticalArrangement = Arrangement.spacedBy(12.dp))
                            {
                                Text(
                                    modifier=Modifier.padding(top=tp.dp),
                                    text = text,
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    //fontFamily = poppinsFamily
                                )
                                Text(
                                    text = subText,
                                    color = Color.Black,
                                    fontSize = 12.sp,
                                    //fontFamily = poppinsFamily
                                )
                                Text(
                                    modifier = Modifier.padding(top = 22.dp),
                                    text = subText1,
                                    //color = GSVCTextPurple,
                                    fontSize = 14.sp,
                                    //fontFamily = poppinsFamily
                                )
                            }
                            CloseButton(hsize = size, onclose = onclose, padding = 14.dp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun CloseButton(hsize: Dp, onclose: () -> Unit,padding:Dp) {
    Row(
        modifier = Modifier
            .height(hsize)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.End
    ) {

        Column {
            Image(
                modifier = Modifier
                    .padding(top = padding, end = padding)
                    .clickable(onClick = onclose),
                painter = painterResource(R.mipmap.ic_desert),
                contentDescription = "",
                //colorFilter = ColorFilter.tint(GSVCPurpleIconClose)
            )
        }

    }
}

