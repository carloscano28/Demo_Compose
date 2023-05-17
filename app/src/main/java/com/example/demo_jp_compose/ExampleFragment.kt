package com.example.demo_jp_compose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment

class ExampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            addView(ComposeView(requireContext()).apply {
                id = R.id.compose_view_x
                setContent { // In here, we can call composables!
                    MaterialTheme {
                        Greeting(name = "compose 1")
                    }
                }
            })
            //addView(TextView())
            addView(ComposeView(requireContext()).apply {
                id = R.id.compose_view_y
                setContent { // In here, we can call composables!
                    MaterialTheme {
                        Greeting(name = "compose 2")
                    }
                }
            })
        }
    }


    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }
}

