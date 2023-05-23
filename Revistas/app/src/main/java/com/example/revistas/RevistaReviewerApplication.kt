package com.example.revistas

import android.app.Application
import com.example.revistas.repository.Revistarepository

class RevistaReviewerApplication : Application() {
    val revistarepository : Revistarepository by lazy {
        Revistarepository(revista)
    }
}