package com.example.simplelist.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.simplelist.R
import com.example.simplelist.model.Item

@Composable
fun ListItem(item: Item, deleteItem: (Int) -> Unit, navigateToItem: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        Column(modifier = Modifier
            .fillMaxWidth(0.75f)
            .padding(4.dp)) {
            Text(text = item.title)
        }

        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_pen),
                contentDescription = "Edit item icon",
                modifier = Modifier.clickable { navigateToItem(item.id) }
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_trash),
                contentDescription = "Delete item icon",
                modifier = Modifier.clickable { deleteItem(item.id) }
            )
        }
    }
}
