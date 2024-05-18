package co.zsmb.requirektx

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.bundle.Bundle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}
