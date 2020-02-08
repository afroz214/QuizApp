package com.smartherd.quizapp

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
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
    fun rightAnswer(){
        right_answer.visibility = View.VISIBLE
        right_answer.setBackgroundColor(Color.GREEN)
        right_answer.text = question

        val handler = Handler()
        handler.postDelayed({startQuiz()},3000)
    }
    fun wrongAnswer(){
        right_answer.visibility = View.VISIBLE
        right_answer.setBackgroundColor(Color.RED)
        right_answer.text = user_answer.text
    }

    fun startQuiz() {
        right_answer.text = ""
        right_answer.visibility = View.INVISIBLE
        random = Random
       question = questions[random.nextInt(questions.size)]
        question_textview.text = mixLetter(question)


    }

    fun showAnswer(view: View) {
        right_answer.visibility = View.VISIBLE
        right_answer.text = question
    }

    fun checkAnswer(view: View) {

        if (user_answer.text.toString().equals(question, ignoreCase = true)){
            rightAnswer()
            Toast.makeText(this, "good job", Toast.LENGTH_SHORT).show()
        }else{
            wrongAnswer()
            Toast.makeText(this, "Bad job", Toast.LENGTH_SHORT).show()
        }

    }

    fun changeAnswer(view: View) {
        startQuiz()

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

