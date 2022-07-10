package com.mobile.jetnoteapp.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mobile.jetnoteapp.R
import com.mobile.jetnoteapp.components.NoteButton
import com.mobile.jetnoteapp.components.NoteInputText
import com.mobile.jetnoteapp.components.NoteRow
import com.mobile.jetnoteapp.models.Note

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalComposeUiApi
@Composable
fun NoteScreen(
    noteList: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    val context = LocalContext.current

    Column(modifier = Modifier.padding(1.dp)) {
        var title by remember {
            mutableStateOf("")
        }

        var description by remember {
            mutableStateOf("")
        }

        TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Notifications"
                )
            },
            contentColor = Color(0xFF45159B),
            backgroundColor = Color.White,
            elevation = 5.dp
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(1.dp)
                .fillMaxWidth()
        ) {

            NoteInputText(
                modifier = Modifier.padding(1.dp),
                text = title,
                label = "Title",
                onTextChanged = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = it
                })
            NoteInputText(
                modifier = Modifier.padding(1.dp),
                text = description,
                label = "Add a Note",
                onTextChanged = {
                    if (it.all { char ->
                            char.isWhitespace() || char.isLetter()
                        }) description = it
                })
            NoteButton(text = "SAVE", onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    onAddNote(Note(title = title, description = description))
                    Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                    title = ""
                    description = ""
                }
            }, enabled = true)

            Divider(modifier = Modifier.padding(5.dp))

            LazyColumn {
                items(noteList) { note ->

                    if (noteList.isNotEmpty()) {
                        NoteRow(note = note, onNoteClicked = { onRemoveNote(note) })
                    } else {
                        Box {
                        }
                    }
                }
            }
        }
    }
}
