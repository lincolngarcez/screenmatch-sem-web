package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("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");
        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();
        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
