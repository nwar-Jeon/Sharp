package com.nwar.uuid.viewModel.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.dummyData.getQuestionList
import com.nwar.domain.entity.SurveyQuestion
import com.nwar.domain.enumerate.Satisfaction
import com.nwar.uuid.ui.base.BaseViewModel

class SurveyQuestionViewModel() : BaseViewModel() {

    val index = MutableLiveData<Int>()
    val questionList = MutableLiveData<List<ObservableField<SurveyQuestion>>>()
    val question = MutableLiveData("")

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_CREATE -> onCreate()
        }
    }

    fun requireNavigateUp() {
        navigateUp.postValue(true)
    }

    override fun onCreate() {
        index.postValue(0)
        questionList.postValue(getQuestionList().map { ObservableField(it) })
    }

    fun requireClickBefore() {
        index.postValue(beforeIndex())
    }

    fun requireClickAfter() {
        index.postValue(afterIndex())
    }

    fun changeQuestion(position : Int) {
        question.postValue(questionList.value?.get(position)?.get()?.question ?: "")
    }

    fun beforeIndex() = if(index.value!!<=0) 0 else index.value!!-1

    fun afterIndex() = if(index.value!!>=questionList.value!!.size - 1) {
        requireNavigateUp()
        questionList.value!!.size - 1
    } else index.value!!+1

    fun clickSatisfaction(type : Satisfaction) { questionList.value?.get(index.value!!)?.get()?.selection = type }
}