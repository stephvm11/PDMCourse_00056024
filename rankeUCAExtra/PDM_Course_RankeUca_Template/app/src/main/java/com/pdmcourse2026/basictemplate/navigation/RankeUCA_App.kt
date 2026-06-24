package com.pdmcourse2026.basictemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdmcourse2026.basictemplate.screensRoom.HomeScreen.HomeScreen
import com.pdmcourse2026.basictemplate.screensRoom.OptionsScreen.OptionsScreen
import com.pdmcourse2026.basictemplate.screensRoom.QuestionsScreen.QuestionScreen

@Composable
fun RankeUCA_App() {
    val backstack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backstack,
        onBack = { backstack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                HomeScreen(navigateToQuestion = {
                    backstack.add(Routes.Questions)
                })
            }
            entry<Routes.Questions> {
                QuestionScreen(onQuestionClick = { id ->
                    backstack.add(Routes.Options(id = id))
                })
            }
            entry<Routes.Options> { option ->
                OptionsScreen(questionId = option.id)
            }
        },
    )
}