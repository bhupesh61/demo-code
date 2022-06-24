package com.example.demoapplication

import com.example.demoapplication.model.UsersDataModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Call
import retrofit2.Response

@RunWith(JUnit4::class)
class UsersListViewModelTest {

    @Mock
    lateinit var repository: com.example.demoapplication.repository.Repository

    lateinit var usersListViewModel: UsersListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.usersListViewModel = UsersListViewModel(this.repository)
    }


    @Test
    fun retrofitTest() {

        val call: Call<List<UsersDataModel>> = repository.getUsersListData()

        try {
            val response: Response<List<UsersDataModel>> = call.execute()
            val userList: List<UsersDataModel>? = response.body()
            Assert.assertTrue(response.isSuccessful)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}
