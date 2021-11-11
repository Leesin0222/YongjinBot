package com.yongjincompany.yongjinbote.utils

import com.yongjincompany.yongjinbote.utils.Constants.OPEN_GOOGLE
import com.yongjincompany.yongjinbote.utils.Constants.OPEN_SEARCH

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..5).random()
        val message = _message.toLowerCase()

        return when {

            message.contains("안녕") -> {
                when(random) {
                    0 -> "안녕?"
                    1 -> "안녕하세유"
                    2 -> "헬로우 월드!!"
                    3 -> "안녕 방가워"
                    4 -> "안녕 못하겠는데.."
                    5 -> "👋"
                    else -> "error"
                }
            }

            message.contains("오늘 어때?") -> {
                when(random) {
                    0 -> "너무 힘들다 오늘만 100명째..."
                    1 -> "기모찌~"
                    2 -> "오늘 기분 좋았지 넌 어때?"
                    3 -> "행복해"
                    4 -> "배고파 많이~"
                    5 -> "심심해.."
                    else -> "error"
                }
            }

            message.startsWith("던진다") && message.contains("동전") -> {
                var r = (0..1).random()
                val result = if (r == 0) "앞면" else "뒷면"

                "${result}이 나왔네요!"
            }

            message.startsWith("계산") -> {
                val equation: String? = message.substringAfter("계산")

                return try{
                    val answer = SolveMath.solveMath(equation ?: "0")
                    answer.toString()

                } catch (e: Exception){
                    "미안 난 못 풀어 이건 내 두뇌론 안돼"
                }
            }

            message.contains("시간") && message.contains("?") -> {
                Time.timeStamp()
            }

            message.startsWith("open") && message.contains("google") -> {
                OPEN_GOOGLE
            }

            message.startsWith("search") -> {
                OPEN_SEARCH
            }

            else -> {
                when (random) {
                    0 -> "이해가 안되..."
                    1 -> "어쩔티비"
                    2 -> "뭐라는거야"
                    3 -> "듣기 싫어"
                    4 -> "난 그런거 모르고 살아"
                    5 -> "내 지식수준은 2살이라 이해가 안됨.."
                    else -> "error"
                }
            }
        }
    }
}