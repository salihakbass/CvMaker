package com.salihakbas.cvmaker.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.salihakbas.cvmaker.navigation.Screen.Splash
import com.salihakbas.cvmaker.navigation.Screen.Home
import com.salihakbas.cvmaker.navigation.Screen.CreateCv
import com.salihakbas.cvmaker.navigation.Screen.Settings
import com.salihakbas.cvmaker.navigation.Screen.PersonalInfo
import com.salihakbas.cvmaker.navigation.Screen.EducationInfo
import com.salihakbas.cvmaker.navigation.Screen.ExperienceInfo
import com.salihakbas.cvmaker.navigation.Screen.SkillsInfo
import com.salihakbas.cvmaker.navigation.Screen.HobbyInfo
import com.salihakbas.cvmaker.navigation.Screen.ProjectInfo
import com.salihakbas.cvmaker.navigation.Screen.ReferenceInfo
import com.salihakbas.cvmaker.navigation.Screen.TemplateSelection
import com.salihakbas.cvmaker.navigation.Screen.Preview
import com.salihakbas.cvmaker.navigation.Screen.EditCv
import com.salihakbas.cvmaker.navigation.Screen.LanguageInfo
import com.salihakbas.cvmaker.ui.splash.SplashScreen
import com.salihakbas.cvmaker.ui.splash.SplashViewModel
import com.salihakbas.cvmaker.ui.home.HomeScreen
import com.salihakbas.cvmaker.ui.home.HomeViewModel
import com.salihakbas.cvmaker.ui.createcv.CreateCvScreen
import com.salihakbas.cvmaker.ui.createcv.CreateCvViewModel
import com.salihakbas.cvmaker.ui.settings.SettingsScreen
import com.salihakbas.cvmaker.ui.settings.SettingsViewModel
import com.salihakbas.cvmaker.ui.personalinfo.PersonalInfoScreen
import com.salihakbas.cvmaker.ui.personalinfo.PersonalInfoViewModel
import com.salihakbas.cvmaker.ui.educationinfo.EducationInfoScreen
import com.salihakbas.cvmaker.ui.educationinfo.EducationInfoViewModel
import com.salihakbas.cvmaker.ui.experienceinfo.ExperienceInfoScreen
import com.salihakbas.cvmaker.ui.experienceinfo.ExperienceInfoViewModel
import com.salihakbas.cvmaker.ui.skillsinfo.SkillsInfoScreen
import com.salihakbas.cvmaker.ui.skillsinfo.SkillsInfoViewModel
import com.salihakbas.cvmaker.ui.hobbyinfo.HobbyInfoScreen
import com.salihakbas.cvmaker.ui.hobbyinfo.HobbyInfoViewModel
import com.salihakbas.cvmaker.ui.projectinfo.ProjectInfoScreen
import com.salihakbas.cvmaker.ui.projectinfo.ProjectInfoViewModel
import com.salihakbas.cvmaker.ui.referenceinfo.ReferenceInfoScreen
import com.salihakbas.cvmaker.ui.referenceinfo.ReferenceInfoViewModel
import com.salihakbas.cvmaker.ui.templateselection.TemplateSelectionScreen
import com.salihakbas.cvmaker.ui.templateselection.TemplateSelectionViewModel
import com.salihakbas.cvmaker.ui.preview.PreviewScreen
import com.salihakbas.cvmaker.ui.preview.PreviewViewModel
import com.salihakbas.cvmaker.ui.editcv.EditCvScreen
import com.salihakbas.cvmaker.ui.editcv.EditCvViewModel
import com.salihakbas.cvmaker.ui.languageinfo.LanguageInfoScreen
import com.salihakbas.cvmaker.ui.languageinfo.LanguageInfoViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Screen,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<Splash> {
            val viewModel: SplashViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            SplashScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Home> {
            val viewModel: HomeViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            HomeScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<CreateCv>(
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            val viewModel: CreateCvViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            CreateCvScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction,
                navigateToPersonalInfo = { navController.navigate(PersonalInfo) },
                navigateToEducationInfo = { navController.navigate(EducationInfo) },
                navigateToExperienceInfo = { navController.navigate(ExperienceInfo) },
                navigateToSkillsInfo = { navController.navigate(SkillsInfo) },
                navigateToLanguageInfo = { navController.navigate(LanguageInfo) },
                navigateToProjectInfo = { navController.navigate(ProjectInfo) },
                navigateToHobbyInfo = { navController.navigate(HobbyInfo) },
                navigateToReferenceInfo = { navController.navigate(ReferenceInfo) },
            )
        }
        composable<Settings> {
            val viewModel: SettingsViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            SettingsScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<PersonalInfo>(
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            }
        ) {
            val viewModel: PersonalInfoViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            PersonalInfoScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<EducationInfo>(
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            }
        ) {
            val viewModel: EducationInfoViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            EducationInfoScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<ExperienceInfo>(
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            }
        ) {
            val viewModel: ExperienceInfoViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            ExperienceInfoScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<SkillsInfo>(
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            }
        ) {
            val viewModel: SkillsInfoViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            SkillsInfoScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<HobbyInfo>(
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            }
        ) {
            val viewModel: HobbyInfoViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            HobbyInfoScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<ProjectInfo>(
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            }
        ) {
            val viewModel: ProjectInfoViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            ProjectInfoScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<ReferenceInfo>(
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            }
        ) {
            val viewModel: ReferenceInfoViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            ReferenceInfoScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<TemplateSelection>(
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            }
        ) {
            val viewModel: TemplateSelectionViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            TemplateSelectionScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Preview> {
            val viewModel: PreviewViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            PreviewScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<EditCv> {
            val viewModel: EditCvViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            EditCvScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<LanguageInfo>(
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = {it}) + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = {it}) + fadeOut()
            }
        ) {
            val viewModel: LanguageInfoViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            LanguageInfoScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
    }
}