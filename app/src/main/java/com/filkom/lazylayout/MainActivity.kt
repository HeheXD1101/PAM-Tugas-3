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
                HewanListHeader(
                    hewanList = sampleHewan,
                    nim = "245150407111037",
                    nama = "Muhammad Murfid Kharomen",
                )
            }
        }
    }
}

// Sample Data Hewan
private val sampleHewan = listOf(
    Hewan(1, "Kucing", "mamalia berkaki empat", R.drawable.kucing_icon),
    Hewan(2, "Ikan", "Hewan air yang bernapas menggunakan insang", R.drawable.ikan_icon),
    Hewan(3, "Burung", "Hewan yang bisa terbang", R.drawable.burung_icon),
    Hewan(4, "Laba-Laba", "Hewan arachnida berkaki delapan", R.drawable.labalaba_icon),
    Hewan(5, "Kucing", "mamalia berkaki empat", R.drawable.kucing_icon),
    Hewan(6, "Ikan", "Hewan air yang bernapas menggunakan insang", R.drawable.ikan_icon),
    Hewan(7, "Burung", "Hewan yang bisa terbang", R.drawable.burung_icon),
    Hewan(8, "Laba-Laba", "Hewan arachnida berkaki delapan", R.drawable.labalaba_icon),
    Hewan(9, "Kucing", "mamalia berkaki empat", R.drawable.kucing_icon),
    Hewan(10, "Ikan", "Hewan air yang bernapas menggunakan insang", R.drawable.ikan_icon),
    Hewan(11, "Burung", "Hewan yang bisa terbang", R.drawable.burung_icon),
    Hewan(12, "Laba-Laba", "Hewan arachnida berkaki delapan", R.drawable.labalaba_icon),
)

@Composable
fun HewanItem(hewan: Hewan, modifier: Modifier = Modifier) {
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
                painter = painterResource(id = hewan.imageRes),
                contentDescription = hewan.name,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = hewan.name,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = hewan.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HewanListHeader(
    hewanList: List<Hewan>,
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
        items(hewanList, key = { it.id }) { hewan ->
            HewanItem(hewan)
        }
    }
}

@Composable
fun HewanGrid(
    hewanList: List<Hewan>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(hewanList, key = { it.id }) { hewan ->
            HewanItem(hewan)
        }
    }
}