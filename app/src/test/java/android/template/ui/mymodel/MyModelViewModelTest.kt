/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.template.ui.mymodel


import android.template.data.MyModelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class MyModelViewModelTest {

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun uiState_initiallyLoading() = runTest {
        val viewModel = MyModelViewModel(FakeMyModelRepository())
        assertEquals(MyModelUiState.Loading, viewModel.uiState.value)
        assertEquals(MyModelUiState.Success(emptyList()), viewModel.uiState.first())
    }

    @Test
    fun uiState_onItemSaved_isDisplayed() = runTest {
        val viewModel = MyModelViewModel(FakeMyModelRepository())
        assertEquals(MyModelUiState.Loading, viewModel.uiState.value)
        assertEquals(MyModelUiState.Success(emptyList()), viewModel.uiState.first())
    }
}

private class FakeMyModelRepository : MyModelRepository {

    private val data = MutableStateFlow(emptyList<String>())

    override val myModels: StateFlow<List<String>> = data.asStateFlow()

    override suspend fun add(name: String) {
        data.update { it.plus(name) }
    }
}
