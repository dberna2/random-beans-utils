package com.dberna2.randomizer.motor.config;

import com.dberna2.model.Engine;
import com.dberna2.randomizer.motor.EngineBrandRandomizer;
import com.dberna2.randomizer.motor.EngineIdRandomizer;
import com.dberna2.randomizer.motor.EngineHorsePowerRandomizer;
import com.dberna2.randomizer.motor.EngineTypeRandomizer;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.FieldDefinitionBuilder;

public class EngineRandomizerConfiguration {

    public static EnhancedRandomBuilder buildEngineRandomize(EnhancedRandomBuilder randomBuilder) {
        randomBuilder.randomize(FieldDefinitionBuilder.field().named("id").ofType(String.class).inClass(Engine.class).get(), new EngineIdRandomizer());
        randomBuilder.randomize(FieldDefinitionBuilder.field().named("type").ofType(String.class).inClass(Engine.class).get(), new EngineTypeRandomizer());
        randomBuilder.randomize(FieldDefinitionBuilder.field().named("horsePower").ofType(String.class).inClass(Engine.class).get(), new EngineHorsePowerRandomizer());
        randomBuilder.randomize(FieldDefinitionBuilder.field().named("brand").ofType(String.class).inClass(Engine.class).get(), new EngineBrandRandomizer());
        return randomBuilder;
    }
}
