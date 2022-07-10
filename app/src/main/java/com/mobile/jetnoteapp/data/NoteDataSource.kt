package com.mobile.jetnoteapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.mobile.jetnoteapp.models.Note

@RequiresApi(Build.VERSION_CODES.O)
class NoteDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(
                title = "Daily Mental Health Journal",
                description = "Record your thoughts to help find inspiration and enhance your self-care skills."
            ),
            Note(
                title = "Business Plan",
                description = "Clarify your business goals, so you can stay focused on what’s important in your day-to-day."
            ),
            Note(
                title = "Sales Pre-Call Planner",
                description = "Be fully prepared for your sales meeting with key notes and questions you need to ask—or think you may be asked—so you’ll already have the answers."
            ),
            Note(
                title = "Call Debrief Tool",
                description = "Make each call count by capturing important details on how best to follow up and go forward—before you forget."
            ),
            Note(
                title = "Weekly Planner",
                description = "Keep your week in focus with this helpful calendar."
            ),
            Note(
                title = "2022 Monthly Calendar",
                description = "Stay organized and productive all month long with this convenient calendar."
            ),
        )
    }

}