package az.edu.bhos.l14todoapp.flows

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import az.edu.bhos.l14todoapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    private lateinit var searchBtn: View
    private lateinit var emptyView: View
    private lateinit var addNewBtn: View
    private lateinit var contentView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupUI()

        addNewBtn.setOnClickListener {
            addNewTodo()
        }

        viewModel.todoEntities.observe(this) { todoEntities ->
            // todo show empty view if `todoEntities` is empty
            // todo show content view (todo list) if `todoEntities` is not empty
        }
    }

    private fun setupUI() {
        searchBtn = findViewById(R.id.searchBtn)
        emptyView = findViewById(R.id.emptyView)
        addNewBtn = findViewById(R.id.addNewBtn)
        contentView = findViewById(R.id.contentView)
    }

    private fun addNewTodo() {
        // todo: navigate to task create page `EditTodoActivity`
    }
}