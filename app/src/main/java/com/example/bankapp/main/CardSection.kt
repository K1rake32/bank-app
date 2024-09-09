package com.example.bankapp.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.R
import com.example.bankapp.data.Card
import com.example.bankapp.ui.theme.BlueEnd
import com.example.bankapp.ui.theme.BlueStart
import com.example.bankapp.ui.theme.GreenEnd
import com.example.bankapp.ui.theme.GreenStart
import com.example.bankapp.ui.theme.OrangeEnd
import com.example.bankapp.ui.theme.OrangeStart
import com.example.bankapp.ui.theme.PurpleEnd
import com.example.bankapp.ui.theme.PurpleStart

val cards = listOf(

    Card(

        cardType = "VISA",
        cardNumber = "3664 7865 3786 3976",
        cardName = "Business",
        balance = 46.312,
        color = getGradient(PurpleStart, PurpleEnd),

    ),

    Card(

        cardType = "MASTER CARD",
        cardNumber = "2346 8732 1234 4321",
        cardName = "Savings",
        balance = 12.32,
        color = getGradient(BlueStart, BlueEnd),

        ),

    Card(

        cardType = "VISA",
        cardNumber = "0392 3214 3534 8549",
        cardName = "School",
        balance = 1.32,
        color = getGradient(OrangeStart, OrangeEnd),

        ),

    Card(

        cardType = "MASTER CARD",
        cardNumber = "3214 1264 9878 6458",
        cardName = "Trips",
        balance = 32.41,
        color = getGradient(GreenStart, GreenEnd),

        )

)


fun getGradient(

    startColor: Color,
    endColor: Color,

):Brush {

    return Brush.horizontalGradient(

        colors = listOf(startColor, endColor)

    )

}

@Composable
fun CardsSection() {

    LazyRow {

        items(cards.size) {index ->

            CardItem(index)

        }

    }

}


@Preview
@Composable
fun CardItem(

    index: Int

) {

    val card = cards[index]
    var lastItemPaddingEnd = 0.dp

    if (index == cards.size - 1) {

        lastItemPaddingEnd = 16.dp

    }

    var image = painterResource(id = R.drawable.ic_visa)

    if (card.cardType == "MASTER CARD") {

        image = painterResource(id = R.drawable.ic_mastercard)

    }
    
    Box(modifier = Modifier

        .padding(start = 16.dp, end = lastItemPaddingEnd)

    ) {

        Column(

            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .padding(vertical = 12.dp, horizontal = 16.dp)

        ) {

            Image(

                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier
                    .width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }

    }

}