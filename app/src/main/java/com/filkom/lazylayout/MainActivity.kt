package com.filkom.lazylayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.filkom.lazylayout.ui.theme.LazyLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyLayoutTheme {
                GadgetListHeader(
                    gadgets = sampleGadgets,
                    nim = "245150407111037",
                    nama = "Muhammad Murfid Kharomen",
                )
            }
        }
    }
}

// Sample Data
private val sampleGadgets = listOf(
    Gadget(1, "Smartphone", "Perangkat komunikasi genggam", R.drawable.ic_smartphone),
    Gadget(2, "Laptop", "Komputer portabel untuk bekerja", R.drawable.ic_laptop),
    Gadget(3, "Tablet", "Perangkat layar sentuh antara hp dan laptop", R.drawable.ic_tablet),
    Gadget(4, "Smartwatch", "Jam tangan pintar pelacak kesehatan", R.drawable.ic_smartwatch),
    Gadget(5, "Earbuds", "Perangkat audio nirkabel", R.drawable.ic_earbuds),
    Gadget(6, "Laptop", "Perangkat komputasi portabel", R.drawable.ic_laptop),
    Gadget(7, "Smartphone", "Perangkat komunikasi genggam", R.drawable.ic_smartphone),
    Gadget(8, "Laptop", "Komputer portabel untuk bekerja", R.drawable.ic_laptop),
    Gadget(9, "Tablet", "Perangkat layar sentuh antara hp dan laptop", R.drawable.ic_tablet),
    Gadget(10, "Smartwatch", "Jam tangan pintar pelacak kesehatan", R.drawable.ic_smartwatch),
    Gadget(11, "Earbuds", "Perangkat audio nirkabel", R.drawable.ic_earbuds),
    Gadget(12, "Laptop", "Perangkat komputasi portabel", R.drawable.ic_laptop),
)

@Composable
fun GadgetItem(gadget: Gadget, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = gadget.imageRes),
                contentDescription = gadget.name,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = gadget.name,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = gadget.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GadgetListHeader(
    gadgets: List<Gadget>,
    nim: String,
    nama: String,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {
        stickyHeader {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "NIM: $nim",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = "Nama: $nama",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
        items(gadgets, key = { it.id }) { gadget ->
            GadgetItem(gadget)
        }
    }
}

@Composable
fun GadgetGrid(
    gadgets: List<Gadget>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(gadgets, key = { it.id }) { gadget ->
            GadgetItem(gadget)
        }
    }
}