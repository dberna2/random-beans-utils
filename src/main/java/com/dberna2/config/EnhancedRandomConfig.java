package com.dberna2.config;

import com.dberna2.randomizer.motor.config.EngineRandomizerConfiguration;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;

import static java.nio.charset.Charset.forName;

public class EnhancedRandomConfig {

    public static EnhancedRandom buildEnhancedRandomConfiguration(){
        EnhancedRandomBuilder randomBuilder = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .charset(forName("UTF-8"))
                .randomizationDepth(5)
                .overrideDefaultInitialization(true)
                .scanClasspathForConcreteTypes (true)
                .collectionSizeRange(2, 5);
        return buildCustomRandomize(randomBuilder).build();
    }

    private static EnhancedRandomBuilder buildCustomRandomize(EnhancedRandomBuilder randomBuilder) {
        EngineRandomizerConfiguration.buildEngineRandomize(randomBuilder);
        return randomBuilder;
    }
}
