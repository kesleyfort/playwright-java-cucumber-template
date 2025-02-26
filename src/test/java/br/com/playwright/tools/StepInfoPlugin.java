package br.com.playwright.tools;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestStepStarted;
import io.cucumber.plugin.event.PickleStepTestStep;
/**
 * Um plugin que escuta eventos de teste do Cucumber e fornece informações sobre os passos de teste.
 * Este plugin implementa a interface EventListener para manipular eventos de teste do Cucumber.
 */
public class StepInfoPlugin implements EventListener {
    /** Armazena o nome do passo de teste atual sendo executado. */
    public static String stepName;
    /**
     * Manipula o evento quando um test step é iniciado.
     * Este método é chamado quando um novo passo de teste começa a ser executado.
     * Ele extrai e imprime o texto do step, e atualiza a variável estática stepName.
     *
     * @param event O evento TestStepStarted que contém informações sobre o step iniciado.
     *              Este evento é acionado no início da execução de cada passo de teste.
     */
    public void onTestStepStarted(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
            String stepText = testStep.getStep().getText();
            System.out.println("Step atual: " + stepText);
            stepName = stepText;
        }
    }

    /**
     * Configura o publicador de eventos para este listener.
     * Este método é chamado pelo Cucumber para registrar o handler de eventos.
     *
     * @param publisher O publicador de eventos fornecido pelo Cucumber.
     *                  É usado para registrar o handler para eventos específicos.
     */
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, this::onTestStepStarted);
    }
}


