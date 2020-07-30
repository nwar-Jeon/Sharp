package com.nwar.uuid.viewModel.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.entity.SurveyQuestion
import com.nwar.domain.enumerate.Satisfaction
import com.nwar.domain.usecase.GetSurveyQuestionListUseCase
import com.nwar.domain.usecase.SubmitSurveyUseCase
import com.nwar.uuid.ui.base.BaseViewModel
import com.nwar.uuid.util.Subscriber

class SurveyQuestionViewModel(val getSurveyQuestionListUseCase: GetSurveyQuestionListUseCase, val submitSurveyUseCase: SubmitSurveyUseCase) : BaseViewModel() {

    val index = MutableLiveData<Int>()
    val tempQuestList : MutableList<ObservableField<SurveyQuestion>> = mutableListOf()
    val questionList = MutableLiveData<List<ObservableField<SurveyQuestion>>>()
    val question = MutableLiveData("")

    val surveyQuestionSubscriber get() = Subscriber<SurveyQuestion>({
        tempQuestList.add(ObservableField(it))
    },{
        if(tempQuestList.size==0) {
            toast.postValue("설문 질문내용이 없습니다.")
            navigateUp.postValue(true)
        } else {
            questionList.postValue(tempQuestList)
        }
    },{
        toast.postValue(it?.message)
    })

    val submitSurveySubscriber get() = Subscriber<Unit>({},{
        requireNavigateUp()
    },{
        toast.postValue(it?.message)
    })

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
        getSurveyQuestionListUseCase.execute(Unit, surveyQuestionSubscriber)
    }

    fun requireVeryGood() {
        saveSelection(Satisfaction.VERY_GOOD)
    }

    fun requireGood() {
        saveSelection(Satisfaction.GOOD)
    }

    fun requireNotBad() {
        saveSelection(Satisfaction.NOT_BAD)
    }

    fun requireBad() {
        saveSelection(Satisfaction.BAD)
    }

    fun requireVeryBad() {
        saveSelection(Satisfaction.VERY_BAD)
    }

    fun saveSelection(state : Satisfaction) {
        val value = questionList.value?.get(index.value!!)
        value?.get()?.selection = state
        value?.notifyChange()
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
        val list = questionList.value?.map { it.get()?.selection?.type ?: -1 }
        if(list != null && list.all { it!=-1 }) submitSurveyUseCase.execute(list, submitSurveySubscriber)
        questionList.value!!.size - 1
    } else index.value!!+1
}