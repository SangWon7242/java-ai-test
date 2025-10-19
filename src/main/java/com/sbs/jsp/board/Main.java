package com.sbs.jsp.board;

import dev.langchain4j.exception.RateLimitException;
import dev.langchain4j.model.openai.OpenAiChatModel;

public class Main {
  public static void main(String[] args) {
    String apiKey = System.getenv("");
    if (apiKey == null || apiKey.isBlank()) {
      System.err.println("Please set OPENAI_API_KEY environment variable");
      return;
    }

    // ChatLanguageModel 생성
    OpenAiChatModel model = OpenAiChatModel.builder()
        .apiKey(apiKey) // 인증키
        .modelName("gpt-4o") // 사용할 모델
        .temperature(0.7) // 모델의 출력 창의성 조절
        .build();

    // 간단한 질문
    try {
      String response = model.chat("Java에서 AI를 사용하는 방법은?");
      System.out.println(response);
    } catch (RateLimitException e) {
      System.err.println("API 할당량을 초과했습니다. 계정 잔액을 확인해주세요.");
      System.err.println("에러 상세: " + e.getMessage());
    }
  }
}