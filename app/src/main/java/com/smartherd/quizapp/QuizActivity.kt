package com.smartherd.quizapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlin.random.Random


class QuizActivity : AppCompatActivity() {

    var questions = arrayOf("web development", "web Designing", "game Development")

    lateinit var random: Random
    lateinit var question: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        startQuiz()
    }

    fun startQuiz() {
        random = Random
       question = questions[random.nextInt(questions.size)]
        question_textview.text = mixLetter(question)


    }

    fun showAnswer(view: View) {

    }

    fun checkAnswer(view: View) {

    }

    fun changeAnswer(view: View) {

    }
    fun mixLetter (word:String):String{
        val characters: CharArray = word.toCharArray()
        for (i in characters.indices) {
            val randomIndex = (Math.random() * characters.size).toInt()
            val temp = characters[i]
            characters[i] = characters[randomIndex]
            characters[randomIndex] = temp
        }
        return String(characters)
    }
}

