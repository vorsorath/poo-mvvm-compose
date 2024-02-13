package com.openclassrooms.notes

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.ui.theme.NotesTheme

/**
 * The main activity for the app.
 */
class MainActivity : ComponentActivity() {

    private val notesRepository = NotesRepository()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        initRecyclerView()
//        initFABButton()
//        collectNotes()

        setContent {
            NotesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(stringResource(id = R.string.app_name))
                            }
                        )
                    },
                ) {
                    Notes(
                        modifier = Modifier.padding(it),
                        notesRepository = notesRepository
                    )
                }
            }
        }
    }

//    /**
//     * Collects notes from the repository and updates the adapter.
//     */
//    private fun collectNotes() {
//        lifecycleScope.launch {
//            notesRepository.notes.collect {
//                notesAdapter.updateNotes(it)
//            }
//        }
//    }
//
//    /**
//     * Initializes the FAB button.
//     */
//    private fun initFABButton() {
//        binding.btnAdd.setOnClickListener {
//            MaterialAlertDialogBuilder(this).apply {
//                setTitle(R.string.coming_soon)
//                setMessage(R.string.not_available_yet)
//                setPositiveButton(android.R.string.ok, null)
//            }.show()
//        }
//    }
//
//    /**
//     * Initializes the RecyclerView.
//     */
//    private fun initRecyclerView() {
//        with(binding.recycler) {
//            addItemDecoration(
//                NoteItemDecoration(
//                    resources.getDimensionPixelSize(R.dimen.default_margin),
//                    resources.getInteger(R.integer.span_count)
//                )
//            )
//
//            adapter = notesAdapter
//        }
//
//    }

}

@Composable
private fun Notes(
    modifier: Modifier = Modifier,
    notesRepository: NotesRepository
) {
    val notes by notesRepository.notes.collectAsStateWithLifecycle(emptyList<Note>())

}