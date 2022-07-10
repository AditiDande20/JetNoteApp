package com.mobile.jetnoteapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.mobile.jetnoteapp.models.Note

@ExperimentalComposeUiApi
@Composable
fun NoteInputText(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int = 1,
    label: String,
    onTextChanged: (String) -> Unit,
    imeAction: () -> Unit = {}
) {

    val keyBoardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = onTextChanged,
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
        label = { Text(text = label) },
        maxLines = maxLines,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            imeAction()
            keyBoardController?.hide()
        })
    )

}

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun NoteRow(note: Note, onNoteClicked: (Note) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topEnd = 40.dp, bottomStart = 40.dp))
            .padding(5.dp),
        color = Color(0xFFEAE2F3)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .clickable { onNoteClicked(note) },
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.padding(4.dp),
                text = note.title,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                modifier = Modifier.padding(4.dp),
                text = note.description,
                style = MaterialTheme.typography.caption
            )
            Text(
                modifier = Modifier.padding(4.dp),
                text = note.dateCreated,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

