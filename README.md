# Java GeoModel

git fork of https://github.com/theganyo/javageomodel/

Created to support custom changes (features/fixes).

This model is used to support geospatial queries using [geohashes](https://en.wikipedia.org/wiki/Geohash) specifically on Google's Datastore

# Dependency
The Gradle dependency is available via jCenter.

```gradle
dependencies {
	// ... other dependencies here
    compile 'com.github.ncalderini:geocell:0.1'
}
```

# Usage

### Entities

You must add location and geoCells fields to your searcheable entity and implement LocationCapable interface.

```java
@Entity
public class MyEntity implements LocationCapable {

    @Id
    private Long id;

    /**
     * The geolocation field
     */
    @Index
    @Location
    private GeoPt location;

    /**
    * A list of geohashes containing the location
    */
    @Index
    @Geocells
    private List<String> geoCells;
    
    ...
}
```

### Query

An example query could be

```java
@ApiMethod(name = "myGeoMethod", path = "myGeoPath", httpMethod = ApiMethod.HttpMethod.GET)
    public List<MyEntity> myGeoMethod(@Named("latitude") Double latitude, @Named("longitude") Double longitude,
                                       @Named("maxDistance")Double maxDistanceInMeters) {
        Point center = new Point(lat, lng);
        //instantiate your implementation of query engine
        GeocellQueryEngine queryEngine = new ObjectifyGeocellQueryEngine();

        //pass it as an argument to GeocellManager#proximitySearch
        List<MyEntity> myEntityList = GeocellManager.proximitySearch(center,
                10, 0, maxDistanceInMeters, MyEntity.class, null,
                queryEngine, GeocellManager.MAX_GEOCELL_RESOLUTION)
                .getResults();

        return myEntityList;
    }
```

