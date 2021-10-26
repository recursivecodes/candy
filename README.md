## mn-candy

An implementation of [candy-server](https://github.com/oracle-devrel/weekend-hacks/tree/main/candy/server) by [Chris Bensen](https://twitter.com/chrisbensen) written in Java, using Micronaut 3.1.1.

### Run

To run:

```shell
$ ./gradlew run
```

## Native Image

To build a native image:

```shell
$ ./gradlew clean && ./gradlew assemble && ./gradlew nativeImage
```

Then go to `build/native-image` and run with `./candy`.