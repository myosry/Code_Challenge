package com.mustafa.codechallenge.ui.viewmodel

import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mustafa.codechallenge.data.repository.MainRepository
import com.mustafa.codechallenge.utils.NetworkHelper
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewModelTest{

    private lateinit var tasksViewModel: MainViewModel
    private lateinit var repository: MainRepository
    private lateinit var networkHelper:NetworkHelper

    // Executes each task synchronously using Architecture Components.
//    @get:Rule
//    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        tasksViewModel = MainViewModel(repository,networkHelper))
    }

    @Test
    fun getStoriesBrochures_getEvent() {
        tasksViewModel.fetchStoryBrochures()

        // Then the is triggered
        val value = tasksViewModel.brochures

        assertThat(Result.success(value), not(nullValue()))
    }
}