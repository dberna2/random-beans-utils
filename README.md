# Create dynamic beans using random-beans libraryExample

## Requirements
You'll need 
 - [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-3848520.html).
 - [Meven 3.X](https://maven.apache.org/download.cgi).

## Library used:
- [random-beans](https://github.com/benas/random-beans)

## Description
 Random Beans is a library that generates random Java beans. This library allows us
 to generate random data like beans with configurations in order to have objects with
 specific data. These specific data can be done through annotations or code.
 
## Configuration
- The `EnhancedRandomBuilder` is the main entry point to configure `EnhancedRandom` instances. It allows you to set all parameters to control how random data is generated:

    ```
     EnhancedRandomBuilder randomBuilder = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                    .charset(forName("UTF-8"))
                    .randomizationDepth(5)
                    .overrideDefaultInitialization(true)
                    .scanClasspathForConcreteTypes (true)
                    .collectionSizeRange(2, 5).build();
     ```

To see the functionality that each parameter has and how it can be configured, you can see it in detail in the following link
- [Randomization-parameters](https://github.com/benas/random-beans/wiki/Randomization-parameters)


To see how it is used, we can use it in the following test, where the TestSupport class is used, which has two methods:
- `getObjectByClassReference`: Generate an Object using a specific class
- `getListByClassReference`: Generate a list using a specific class

## Comparation
Once generated our objects we would pass this

```
@Test
    public void generateObjectByClassReferenceTest() throws Exception {

        Engine engine = new Engine();
        engine.setId(UUID.randomUUID().toString());
        engine.setBrand("BMW");
        engine.setHorsePower(1600);
        engine.setType(EngineTypeEnum.COMBUSTION);

        Car car = new Car();
        car.setBrand("BMW");
        car.setColor("RED");
        car.setEngine(engine);

        CarDTO carDto = CarMapper.INSTANCE.mapCarToCarDto(car);

        assertEquals(car.getColor(), carDto.getColor());
        assertEquals(car.getBrand(), carDto.getBrand());
        assertNotNull(car.getEngine());
        assertEquals(car.getEngine().getId(), carDto.getEngine().getId());
        assertEquals(car.getEngine().getBrand(), carDto.getEngine().getBrand());
        assertEquals(car.getEngine().getHorsePower(), carDto.getEngine().getHorsePower());
        assertEquals(car.getEngine().getType(), carDto.getEngine().getType());
    }
```

To this

```
@Test
    public void getObjectByClassReferenceWhitAnnotationsTest() throws Exception {

        Car car = testSupport.getObjectByClassReference(Car.class);

        CarDTO carDto = CarMapper.INSTANCE.mapCarToCarDto(car);

        System.out.println(carDto.toString());

        assertEquals(car.getColor(), carDto.getColor());
        assertEquals(car.getBrand(), carDto.getBrand());
        assertNotNull(car.getEngine());
        assertEquals(car.getEngine().getId(), carDto.getEngine().getId());
        assertEquals(car.getEngine().getBrand(), carDto.getEngine().getBrand());
        assertEquals(car.getEngine().getHorsePower(), carDto.getEngine().getHorsePower());
        assertEquals(car.getEngine().getType(), carDto.getEngine().getType());
    }
```

If you need to create a list, we pass this

```
 @Test
    public void generateObjectByClassReferenceTest() throws Exception {

        List<Car> carList = new ArrayList<>();
        
        Engine engine = new Engine();
        engine.setId(UUID.randomUUID().toString());
        engine.setBrand("BMW");
        engine.setHorsePower(1600);
        engine.setType(EngineTypeEnum.COMBUSTION);

        Car bmw = new Car();
        bmw.setBrand("BMW");
        bmw.setColor("RED");
        bmw.setEngine(engine);

        carList.add(bmw);

        Car mazda = new Car();
        mazda.setBrand("MAZDA");
        mazda.setColor("BLUE");
        mazda.setEngine(engine);

        carList.add(mazda);

        List<CarDTO> carDto = CarMapper.INSTANCE.mapCarToCarDtoList(carList);

        assertEquals...
```

To this

```
@Test
public void generateObjectByClassReferenceTest() throws Exception {
    
     int elementsToGenerate = 4;
    
     List<Car> carList = testSupport.getListByClassReference(Car.class, elementsToGenerate);
    
     List<CarDTO> carDTOList = CarMapper.INSTANCE.mapCarToCarDtoList(carList);
}
```

NOTE: The method `getListByClassReference` accepts as a second parameter the number of items we want to generate, in this case and generate different objects in each item <3

## Generate custom beans

One of the great advantages of this library, is that it gives us the possibility to indicate how we want to generate information about our objects.

For this we can do it in two ways: programmatically or through annotations

## Programmatically

In this example we will continue with our Car class, where we see that we indicate for each tribute a `Randomizer` that will generate the data of face attribute

```
    public static EnhancedRandomBuilder buildEngineRandomize(EnhancedRandomBuilder randomBuilder) {
        randomBuilder.randomize(FieldDefinitionBuilder.field().named("id").ofType(String.class).inClass(Engine.class).get(), new EngineIdRandomizer());
        randomBuilder.randomize(FieldDefinitionBuilder.field().named("type").ofType(String.class).inClass(Engine.class).get(), new EngineTypeRandomizer());
        randomBuilder.randomize(FieldDefinitionBuilder.field().named("horsePower").ofType(String.class).inClass(Engine.class).get(), new EngineHorsePowerRandomizer());
        randomBuilder.randomize(FieldDefinitionBuilder.field().named("brand").ofType(String.class).inClass(Engine.class).get(), new EngineBrandRandomizer());
        return randomBuilder;
    }
```

For the horsePower attribute, we have the `Randomizer` `EngineHorsePowerRandomizer`, which is built in the following way:
```
public class EngineHorsePowerRandomizer implements Randomizer<Integer> {

    List<Integer> horsePowerList  = Arrays.asList(1000, 1500, 1800);
    
    @Override
    public Integer getRandomValue() {
        return horsePowerList.get(new Random().nextInt(horsePowerList.size()));
    }
}
```

## Annotation

To generate our data with annotations is much simpler, the only thing we must do is write down the attribute that we want to have specific data with the annotation `@Randomizer`

```
  public class Car {
  
      @Randomizer(CarColorRandomizer.class)
      private String color;
      @Randomizer(CarBrandRandomizer.class)
      private String brand;
      @Randomizer(CarEngineRandomizer.class)
      private Engine engine;
  }
```
Classes `CarColorRandomizer`, `CarBrandRandomizer`, `CarEngineRandomizer`  were created as the previous example of the class `EngineHorsePowerRandomizer`


