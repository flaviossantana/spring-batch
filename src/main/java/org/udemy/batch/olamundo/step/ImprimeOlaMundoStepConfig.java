package org.udemy.batch.olamundo.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeOlaMundoStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step imprimeOlaMundoStep(Tasklet imprimeOlaMundoTasklet) {
        return stepBuilderFactory
                .get("imprimeOlaMundoStep")
                .tasklet(imprimeOlaMundoTasklet)
                .build();
    }


}
